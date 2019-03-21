package com.like.restful;


import com.like.entity.OrderTodayeat;
import com.like.service.OrderTodayeatService;
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
 * on 2019-03-21 15:13
 */
@Controller
@RequestMapping("/ordertodayeat")
public class F_OrderTodayeatRestful {

    @Autowired
    private OrderTodayeatService orderTodayeatService;

    /**
     * 根据OrderTodayeat实体添加
     *
     * @param  orderTodayeat
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/insertByOrderTodayeat")
    public LayuiDataTemplet<OrderTodayeat> insertByOrderTodayeat(@RequestBody OrderTodayeat orderTodayeat) {
        LayuiDataTemplet<OrderTodayeat> returnData = new LayuiDataTemplet<OrderTodayeat>();
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不能为空，验证版本号
        try {
            if (null != orderTodayeat.getVersion() && !orderTodayeat.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(orderTodayeat.getVersion(), Config.VERSION);
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
        //判复
        OrderTodayeat orderTodayeatData = new OrderTodayeat();
        orderTodayeatData.setPagenumber(-1);//不分页
        orderTodayeat.setEatMenuid("123");
        orderTodayeat.setEatUserid("123");
        orderTodayeatData.setEatMenuid(orderTodayeat.getEatMenuid());//菜品id
        orderTodayeatData.setEatUserid(orderTodayeat.getEatUserid());//点赞人id
        List<OrderTodayeat> orderTodayeatList = orderTodayeatService.selectByOrderTodayeat(orderTodayeatData); // 查询数据
        int count = 0;
        if (orderTodayeatList.size() > 0) {
            returnData.setMsg("数据已存在！");
            return returnData;
        }
            // 添加数据
            orderTodayeat.setEatId(Config.TODAY + UUID.randomUUID().toString()); // 用户ID(YH+UUID)
            orderTodayeat.setEatState(1);//删除状态（0：删除/1：未删除）
            orderTodayeat.setEatCreatetime(new Date()); // 用户创建时间
            orderTodayeat.setEatUpdatetime(new Date());//用户更新时间
            // 添加
            count = orderTodayeatService.insertByOrderTodayeat(orderTodayeat);
            // 返回数据
        if (count == 0) {
            returnData.setMsg("报菜单失败！");
        } else {
            returnData.setCount(count);
            returnData.setMsg("报菜单成功！");
        }

        return returnData;
    }

    /**
     * 根据OrderTodayeat实体更新
     *
     * @param orderTodayeat
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/updateByOrderTodayeat")
    public LayuiDataTemplet<OrderTodayeat> updateByOrderTodayeat(@RequestBody OrderTodayeat orderTodayeat) {
        LayuiDataTemplet<OrderTodayeat> returnData = new LayuiDataTemplet<OrderTodayeat>();
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不能为空，验证版本号
        try {
            if (null != orderTodayeat.getVersion() && !orderTodayeat.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(orderTodayeat.getVersion(), Config.VERSION);
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
        orderTodayeat.setEatId("ME45938d0b-8801-4002-a142-7d317420a611");
        if (orderTodayeat.getEatId() == null || orderTodayeat.getEatId() == "") {
            if (orderTodayeat.getEatId()   == null ||orderTodayeat.getEatId()  .isEmpty()) {
                returnData.setMsg("缺少更新条件，更新失败！");
                return returnData;
            }
        }

        // 更新数据
        orderTodayeat.setEatUpdatetime(new Date()); // 更新时间
        // 更新
        int count = 0;
        count = orderTodayeatService.updateByOrderTodayeat(orderTodayeat);

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
     * 根据OrderTodayeat实体联表查询
     *
     * 可以进行分页查询
     *
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     *
     * pageSize 每页的数据量
     *
     * @param orderTodayeat
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/selectByOrderTodayeat")
    public LayuiDataTemplet<OrderTodayeat> selectByOrderTodayeat(@RequestBody OrderTodayeat orderTodayeat) {
        LayuiDataTemplet<OrderTodayeat> returnData = new LayuiDataTemplet<OrderTodayeat>();
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不能为空，验证版本号
        try {
            if (null != orderTodayeat.getVersion() && !orderTodayeat.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(orderTodayeat.getVersion(), Config.VERSION);
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
        if (orderTodayeat.getPagenumber() != null) {
            // 计算偏移量
            if (orderTodayeat.getPagenumber() != -1) {
                if (orderTodayeat.getPagesize() == null) {
                    returnData.setMsg("传递的分页数据(每页数量)错误！");
                    return returnData;
                }

                // 获取传递过来的数据
                int pageNumber = orderTodayeat.getPagenumber();
                int pageSize = orderTodayeat.getPagesize();
                orderTodayeat.setPagenumber((pageNumber - 1) * pageSize); // 当前页数(如果不进行分页，该条数据默认为-1)
                orderTodayeat.setPagesize(pageSize); // 每页的数据量
            }

            // 查询数量
            int count = 0;
            count = orderTodayeatService.selectCountByOrderTodayeat(orderTodayeat);

            // 返回数据
            if (count == 0) {
                returnData.setMsg("暂无数据！");
            } else {
                returnData.setCount(count);
                returnData.setMsg("查询成功！");
                List<OrderTodayeat> orderTodayeatList = orderTodayeatService.selectByOrderTodayeat(orderTodayeat); // 查询数据
                returnData.setData(orderTodayeatList);
            }
        } else {
            returnData.setMsg("传递的分页数据(页数)错误！");
        }

        return returnData;
    }

    /**
     * 根据OrderTodayeat实体联表模糊查询
     *
     * 可以进行分页查询
     *
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     *
     * pageSize 每页的数据量
     *
     * @param orderTodayeat
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/selectBySelectData")
    public LayuiDataTemplet<OrderTodayeat> selectBySelectData(@RequestBody OrderTodayeat orderTodayeat) {
        LayuiDataTemplet<OrderTodayeat> returnData = new LayuiDataTemplet<OrderTodayeat>();
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不能为空，验证版本号
        try {
            if (null != orderTodayeat.getVersion() && !orderTodayeat.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(orderTodayeat.getVersion(), Config.VERSION);
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
        if (orderTodayeat.getPagenumber() != null) {
            // 计算偏移量
            if (orderTodayeat.getPagenumber() != -1) {
                if (orderTodayeat.getPagesize() == null) {
                    returnData.setMsg("传递的分页数据(每页数量)错误！");
                    return returnData;
                }

                // 获取传递过来的数据
                int pageNumber = orderTodayeat.getPagenumber();
                int pageSize = orderTodayeat.getPagesize();
                orderTodayeat.setPagenumber((pageNumber - 1) * pageSize); // 当前页数(如果不进行分页，该条数据默认为-1)
                orderTodayeat.setPagesize(pageSize); // 每页的数据量
            }

            // 查询数量
            int count = 0;
            count = orderTodayeatService.selectCountBySelectData(orderTodayeat); // 查询数量

            // 返回数据
            if (count == 0) {
                returnData.setMsg("暂无数据！");
            } else {
                returnData.setCount(count);
                returnData.setMsg("查询成功！");
                List<OrderTodayeat> orderTodayeatList = orderTodayeatService.selectBySelectData(orderTodayeat); // 查询数据
                returnData.setData(orderTodayeatList);
            }
        } else {
            returnData.setMsg("传递的分页数据(页数)错误！");
        }

        return returnData;
    }
    /**
     * 根据OrderTodayeat实体删除信息(假删，更改state状态)(0:删除、1：未删除)
     *
     * @param orderTodayeat
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/updateByOrderTodayeatDeleteState")
    public LayuiDataTemplet<OrderTodayeat> updateByOrderTodayeatDeleteState(@RequestBody OrderTodayeat orderTodayeat) {
        LayuiDataTemplet<OrderTodayeat> returnData = new LayuiDataTemplet<OrderTodayeat>();
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不能为空，验证版本号
        try {
            if (null != orderTodayeat.getVersion() && !orderTodayeat.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(orderTodayeat.getVersion(), Config.VERSION);
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
        orderTodayeat.setUuidlist(uuid);
        count = orderTodayeatService.updateByOrderTodayeatDeleteState(orderTodayeat.getUuidlist());

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
     * @param orderTodayeat
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/deleteByIdList")
    public LayuiDataTemplet<OrderTodayeat> deleteByIdList(@RequestBody OrderTodayeat orderTodayeat) {
        LayuiDataTemplet<OrderTodayeat> returnData = new LayuiDataTemplet<OrderTodayeat>();
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不能为空，验证版本号
        try {
            if (null != orderTodayeat.getVersion() && !orderTodayeat.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(orderTodayeat.getVersion(), Config.VERSION);
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
        count = orderTodayeatService.deleteByIdList(orderTodayeat.getUuidlist());

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

