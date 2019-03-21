package com.like.restful;

import com.like.entity.OrderLike;
import com.like.service.OrderLikeService;
import com.util.Config;
import com.util.LayuiDataTemplet;
import com.util.VersionCompare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Lovelyz
 * on 2019-03-21 14:01
 */
@Controller
@RequestMapping("/orderlike")
public class F_OrderLikeRestful {

    @Autowired
    private OrderLikeService orderLikeService;

    /**
     * 根据OrderLike实体添加
     *
     * @param  orderLike
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/insertByOrderLike")
    public LayuiDataTemplet<OrderLike> insertByOrderLike(@RequestBody OrderLike orderLike) {
        LayuiDataTemplet<OrderLike> returnData = new LayuiDataTemplet<OrderLike>();
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不能为空，验证版本号
        try {
            if (null != orderLike.getVersion() && !orderLike.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(orderLike.getVersion(), Config.VERSION);
                if (compare < 0) {
                    returnData.setMsg("版本较低，请更新版本！");
                    return returnData;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

            returnData.setMsg("版本比较发生异常！");
            return returnData;
        }

        //判断登录名不能重复
        OrderLike orderLikeData = new OrderLike();
        orderLikeData.setPagenumber(-1);//不分页
        orderLikeData.setLikeMenuid("123");
        orderLike.setLikeUserid("123");
        orderLikeData.setLikeMenuid(orderLike.getLikeMenuid());//菜品名id
        orderLikeData.setLikeUserid(orderLike.getLikeUserid());//点赞人id
        List<OrderLike> OrderLikeList = orderLikeService.selectByOrderLike(orderLikeData); // 查询数据
        int count = 0;
        if (OrderLikeList.size() > 0) {
            returnData.setMsg("该菜品名已注册、请更换！");
            /**
             * 点赞加1
             */
            OrderLike orderLikeone =   OrderLikeList.get(0);

            orderLikeone.setLikeCount(orderLikeone.getLikeCount()+1);

            count = orderLikeService.updateByOrderLike(orderLikeone);
        }else {
            // 添加数据
            orderLike.setLikeId(Config.DZ + UUID.randomUUID().toString()); // 用户ID(YH+UUID)
            orderLike.setLikeState(1);//删除状态（0：删除/1：未删除）
            orderLike.setLikeUpdatetime(new Date()); // 用户创建时间
            orderLike.setLikeCreatetime(new Date());//用户更新时间
            // 添加
            count = orderLikeService.insertByOrderLike(orderLike);
            // 返回数据
        }
        if (count == 0) {
            returnData.setMsg("点赞失败！");
        } else {
            returnData.setCount(count);
            returnData.setMsg("点赞成功！");
        }

        return returnData;
    }

    /**
     * 根据OrderLike实体更新
     *
     * @param orderLike
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/updateByOrderLike")
    public LayuiDataTemplet<OrderLike> updateByOrderLike(@RequestBody OrderLike orderLike) {
        LayuiDataTemplet<OrderLike> returnData = new LayuiDataTemplet<OrderLike>();
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不能为空，验证版本号
        try {
            if (null != orderLike.getVersion() && !orderLike.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(orderLike.getVersion(), Config.VERSION);
                if (compare < 0) {
                    returnData.setMsg("版本较低，请更新版本！");
                    return returnData;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

            returnData.setMsg("版本比较发生异常！");
            return returnData;
        }
        // 更新判断
        orderLike.setLikeId("ME45938d0b-8801-4002-a142-7d317420a611");
        if (orderLike.getLikeId() == null || orderLike.getLikeId() == "") {
            if (orderLike.getLikeId()   == null ||orderLike.getLikeId()  .isEmpty()) {
                returnData.setMsg("缺少更新条件，更新失败！");
                return returnData;
            }
        }

        // 更新数据
        orderLike.setLikeUpdatetime(new Date()); // 更新时间
        // 更新
        int count = 0;
        count = orderLikeService.updateByOrderLike(orderLike);

        // 返回数据
        if (count == 0) {
            returnData.setMsg("更新失败！");
        } else {
            returnData.setCount(count);
            returnData.setMsg("更新成功！");
        }

        return returnData;
    }

    /**
     * 根据OrderLike实体联表查询
     *
     * 可以进行分页查询
     *
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     *
     * pageSize 每页的数据量
     *
     * @param orderLike
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/selectByOrderLike")
    public LayuiDataTemplet<OrderLike> selectByOrderLike(@RequestBody OrderLike orderLike) {
        LayuiDataTemplet<OrderLike> returnData = new LayuiDataTemplet<OrderLike>();
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不能为空，验证版本号
        try {
            if (null != orderLike.getVersion() && !orderLike.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(orderLike.getVersion(), Config.VERSION);
                if (compare < 0) {
                    returnData.setMsg("版本较低，请更新版本！");
                    return returnData;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

            returnData.setMsg("版本比较发生异常！");
            return returnData;
        }

        // 分页数据
        // 使用limit分页查询，根据偏移量查询
        // 第一个参数为第一个返回记录行的偏移量，第二个参数为返回记录行的最大数目
        // MySQL > SELECT * FROM table LIMIT 5, 10; // 查询第6-15行数据
        if (orderLike.getPagenumber() != null) {
            // 计算偏移量
            if (orderLike.getPagenumber() != -1) {
                if (orderLike.getPagesize() == null) {
                    returnData.setMsg("传递的分页数据(每页数量)错误！");
                    return returnData;
                }

                // 获取传递过来的数据
                int pageNumber = orderLike.getPagenumber();
                int pageSize = orderLike.getPagesize();
                orderLike.setPagenumber((pageNumber - 1) * pageSize); // 当前页数(如果不进行分页，该条数据默认为-1)
                orderLike.setPagesize(pageSize); // 每页的数据量
            }

            // 查询数量
            int count = 0;
            count = orderLikeService.selectCountByOrderLike(orderLike);

            // 返回数据
            if (count == 0) {
                returnData.setMsg("暂无数据！");
            } else {
                returnData.setCount(count);
                returnData.setMsg("查询成功！");
                List<OrderLike> orderLikeList = orderLikeService.selectByOrderLike(orderLike); // 查询数据
                returnData.setData(orderLikeList);
            }
        } else {
            returnData.setMsg("传递的分页数据(页数)错误！");
        }

        return returnData;
    }

    /**
     * 根据OrderLike实体联表模糊查询
     *
     * 可以进行分页查询
     *
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     *
     * pageSize 每页的数据量
     *
     * @param orderLike
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/selectBySelectData")
    public LayuiDataTemplet<OrderLike> selectBySelectData(@RequestBody OrderLike orderLike) {
        LayuiDataTemplet<OrderLike> returnData = new LayuiDataTemplet<OrderLike>();
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不能为空，验证版本号
        try {
            if (null != orderLike.getVersion() && !orderLike.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(orderLike.getVersion(), Config.VERSION);
                if (compare < 0) {
                    returnData.setMsg("版本较低，请更新版本！");
                    return returnData;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

            returnData.setMsg("版本比较发生异常！");
            return returnData;
        }
        // 分页数据
        // 使用limit分页查询，根据偏移量查询
        // 第一个参数为第一个返回记录行的偏移量，第二个参数为返回记录行的最大数目
        // MySQL > SELECT * FROM table LIMIT 5, 10; // 查询第6-15行数据
        if (orderLike.getPagenumber() != null) {
            // 计算偏移量
            if (orderLike.getPagenumber() != -1) {
                if (orderLike.getPagesize() == null) {
                    returnData.setMsg("传递的分页数据(每页数量)错误！");
                    return returnData;
                }

                // 获取传递过来的数据
                int pageNumber = orderLike.getPagenumber();
                int pageSize = orderLike.getPagesize();
                orderLike.setPagenumber((pageNumber - 1) * pageSize); // 当前页数(如果不进行分页，该条数据默认为-1)
                orderLike.setPagesize(pageSize); // 每页的数据量
            }

            // 查询数量
            int count = 0;
            count = orderLikeService.selectCountBySelectData(orderLike); // 查询数量

            // 返回数据
            if (count == 0) {
                returnData.setMsg("暂无数据！");
            } else {
                returnData.setCount(count);
                returnData.setMsg("查询成功！");
                List<OrderLike> orderLikeList = orderLikeService.selectBySelectData(orderLike); // 查询数据
                returnData.setData(orderLikeList);
            }
        } else {
            returnData.setMsg("传递的分页数据(页数)错误！");
        }

        return returnData;
    }
    /**
     * 根据OrderLike实体删除信息(假删，更改state状态)(0:删除、1：未删除)
     *
     * @param orderLike
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/updateByOrderLikeDeleteState")
    public LayuiDataTemplet<OrderLike> updateByOrderLikeDeleteState(@RequestBody OrderLike orderLike) {
        LayuiDataTemplet<OrderLike> returnData = new LayuiDataTemplet<OrderLike>();
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不能为空，验证版本号
        try {
            if (null != orderLike.getVersion() && !orderLike.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(orderLike.getVersion(), Config.VERSION);
                if (compare < 0) {
                    returnData.setMsg("版本较低，请更新版本！");
                    return returnData;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

            returnData.setMsg("版本比较发生异常！");
            return returnData;
        }

        // 删除
        int count = 0;
        List<String> uuid = new ArrayList<>();
        uuid.add("ME5d9e38fb-5bbb-4a3a-92ab-e4de20092110");
        uuid.add("ME45938d0b-8801-4002-a142-7d317420a611");
        orderLike.setUuidlist(uuid);
        count = orderLikeService.updateByOrderLikeDeleteState(orderLike.getUuidlist());

        // 返回数据
        if (count == 0) {
            returnData.setMsg("删除失败！");
        } else {
            returnData.setCount(count);
            returnData.setMsg("删除成功！");
        }

        return returnData;
    }



    /**
     * 根据idList删除信息
     *
     * @param orderLike
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/deleteByIdList")
    public LayuiDataTemplet<OrderLike> deleteByIdList(@RequestBody OrderLike orderLike) {
        LayuiDataTemplet<OrderLike> returnData = new LayuiDataTemplet<OrderLike>();
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不能为空，验证版本号
        try {
            if (null != orderLike.getVersion() && !orderLike.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(orderLike.getVersion(), Config.VERSION);
                if (compare < 0) {
                    returnData.setMsg("版本较低，请更新版本！");
                    return returnData;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

            returnData.setMsg("版本比较发生异常！");
            return returnData;
        }

        // 删除
        int count = 0;
        count = orderLikeService.deleteByIdList(orderLike.getUuidlist());

        // 返回数据
        if (count == 0) {
            returnData.setMsg("删除失败！");
        } else {
            returnData.setCount(count);
            returnData.setMsg("删除成功！");
        }

        return returnData;
    }

}


