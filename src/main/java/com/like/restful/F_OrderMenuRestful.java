package com.like.restful;

/**
 * Created by Lovelyz
 * on 2019-03-21 09:54
 */

import com.like.entity.OrderMenu;
import com.like.service.OrderMenuService;
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
 * 菜单表
 *
 * Restful
 *
 * @author Lovelyz on 2019/03/21
 */

@Controller
@RequestMapping("/ordermenu")
public class F_OrderMenuRestful {

    @Autowired
    private OrderMenuService orderMenuService;

    /**
     * 根据OrderMenu实体添加
     *
     * @param  orderMenu
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/insertByOrderMenu")
    public LayuiDataTemplet<OrderMenu> insertByOrderMenu(@RequestBody OrderMenu orderMenu) {
        LayuiDataTemplet<OrderMenu> returnData = new LayuiDataTemplet<OrderMenu>();
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不能为空，验证版本号
        try {
            if (null != orderMenu.getVersion() && !orderMenu.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(orderMenu.getVersion(), Config.VERSION);
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
        OrderMenu orderMenuData = new OrderMenu();
        orderMenuData.setPagenumber(-1);//不分页
        orderMenuData.setMenuName("宫保鸡丁");
        orderMenuData.setMenuName(orderMenuData.getMenuName());//菜品名

        List<OrderMenu> orderMenuList = orderMenuService.selectByOrderMenu(orderMenuData); // 查询数据
        if (orderMenuList.size() > 0) {
            returnData.setMsg("该菜品名已注册、请更换！");
            return returnData;
        }
        // 添加数据
        orderMenu.setMenuName(orderMenuData.getMenuName());
        orderMenu.setMenuId(Config.MENU + UUID.randomUUID().toString()); // 用户ID(YH+UUID)
        orderMenu.setMenuState(1);//删除状态（0：删除/1：未删除）
        orderMenu.setMenuCreatetime(new Date()); // 用户创建时间
        orderMenu.setMenuUpdatetime(new Date());//用户更新时间

        // 添加
        int count = 0;
        count = orderMenuService.insertByOrderMenu(orderMenu);

        // 返回数据
        if (count == 0) {
            returnData.setMsg("添加失败！");
        } else {
            returnData.setCount(count);
            returnData.setMsg("添加成功！");
        }

        return returnData;
    }

    /**
     * 根据OrderMenu实体更新
     *
     * @param orderMenu
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/updateByOrderMenu")
    public LayuiDataTemplet<OrderMenu> updateByOrderMenu(@RequestBody OrderMenu orderMenu) {
        LayuiDataTemplet<OrderMenu> returnData = new LayuiDataTemplet<OrderMenu>();
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不能为空，验证版本号
        try {
            if (null != orderMenu.getVersion() && !orderMenu.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(orderMenu.getVersion(), Config.VERSION);
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
        orderMenu.setMenuId("ME45938d0b-8801-4002-a142-7d317420a611");
        if (orderMenu.getMenuId() == null || orderMenu.getMenuId() == "") {
            if (orderMenu.getMenuId()  == null || orderMenu.getMenuId() .isEmpty()) {
                returnData.setMsg("缺少更新条件，更新失败！");
                return returnData;
            }
        }

        // 更新数据
        orderMenu.setMenuUpdatetime(new Date()); // 更新时间
     orderMenu.setMenuName("波波鱼");
        // 更新
        int count = 0;
        count = orderMenuService.updateByOrderMenu(orderMenu);

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
     * 根据OrderMenu实体联表查询
     *
     * 可以进行分页查询
     *
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     *
     * pageSize 每页的数据量
     *
     * @param orderMenu
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/selectByOrderMenu")
    public LayuiDataTemplet<OrderMenu> selectByOrderMenu(@RequestBody OrderMenu orderMenu) {
        LayuiDataTemplet<OrderMenu> returnData = new LayuiDataTemplet<OrderMenu>();
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不能为空，验证版本号
        try {
            if (null != orderMenu.getVersion() && !orderMenu.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(orderMenu.getVersion(), Config.VERSION);
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
        if (orderMenu.getPagenumber() != null) {
            // 计算偏移量
            if (orderMenu.getPagenumber() != -1) {
                if (orderMenu.getPagesize() == null) {
                    returnData.setMsg("传递的分页数据(每页数量)错误！");
                    return returnData;
                }

                // 获取传递过来的数据
                int pageNumber = orderMenu.getPagenumber();
                int pageSize = orderMenu.getPagesize();
                orderMenu.setPagenumber((pageNumber - 1) * pageSize); // 当前页数(如果不进行分页，该条数据默认为-1)
                orderMenu.setPagesize(pageSize); // 每页的数据量
            }

            // 查询数量
            int count = 0;
            count = orderMenuService.selectCountByOrderMenu(orderMenu);

            // 返回数据
            if (count == 0) {
                returnData.setMsg("暂无数据！");
            } else {
                returnData.setCount(count);
                returnData.setMsg("查询成功！");
                List<OrderMenu> orderMenuList = orderMenuService.selectByOrderMenu(orderMenu); // 查询数据
                returnData.setData(orderMenuList);
            }
        } else {
            returnData.setMsg("传递的分页数据(页数)错误！");
        }

        return returnData;
    }

    /**
     * 根据OrderMenu实体联表模糊查询
     *
     * 可以进行分页查询
     *
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     *
     * pageSize 每页的数据量
     *
     * @param orderMenu
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/selectBySelectData")
    public LayuiDataTemplet<OrderMenu> selectBySelectData(@RequestBody OrderMenu orderMenu) {
        LayuiDataTemplet<OrderMenu> returnData = new LayuiDataTemplet<OrderMenu>();
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不能为空，验证版本号
        try {
            if (null != orderMenu.getVersion() && !orderMenu.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(orderMenu.getVersion(), Config.VERSION);
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
        if (orderMenu.getPagenumber() != null) {
            // 计算偏移量
            if (orderMenu.getPagenumber() != -1) {
                if (orderMenu.getPagesize() == null) {
                    returnData.setMsg("传递的分页数据(每页数量)错误！");
                    return returnData;
                }

                // 获取传递过来的数据
                int pageNumber = orderMenu.getPagenumber();
                int pageSize = orderMenu.getPagesize();
                orderMenu.setPagenumber((pageNumber - 1) * pageSize); // 当前页数(如果不进行分页，该条数据默认为-1)
                orderMenu.setPagesize(pageSize); // 每页的数据量
            }

            // 查询数量
            int count = 0;
            count = orderMenuService.selectCountBySelectData(orderMenu); // 查询数量

            // 返回数据
            if (count == 0) {
                returnData.setMsg("暂无数据！");
            } else {
                returnData.setCount(count);
                returnData.setMsg("查询成功！");
                List<OrderMenu> orderMenuList = orderMenuService.selectBySelectData(orderMenu); // 查询数据
                returnData.setData(orderMenuList);
            }
        } else {
            returnData.setMsg("传递的分页数据(页数)错误！");
        }

        return returnData;
    }
    /**
     * 根据OrderMenu实体删除信息(假删，更改state状态)(0:删除、1：未删除)
     *
     * @param orderMenu
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/updateByOrderMenuDeleteState")
    public LayuiDataTemplet<OrderMenu> updateByOrderMenuDeleteState(@RequestBody OrderMenu orderMenu) {
        LayuiDataTemplet<OrderMenu> returnData = new LayuiDataTemplet<OrderMenu>();
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不能为空，验证版本号
        try {
            if (null != orderMenu.getVersion() && !orderMenu.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(orderMenu.getVersion(), Config.VERSION);
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
        orderMenu.setUuidlist(uuid);
        count = orderMenuService.updateByOrderMenuDeleteState(orderMenu.getUuidlist());

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
     * @param orderMenu
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    @ResponseBody
    @RequestMapping("/deleteByIdList")
    public LayuiDataTemplet<OrderMenu> deleteByIdList(@RequestBody OrderMenu orderMenu) {
        LayuiDataTemplet<OrderMenu> returnData = new LayuiDataTemplet<OrderMenu>();
        returnData.setCode(0); // 默认为0
        returnData.setCount(0); // 数据的数量，默认为0
        returnData.setData(null); // 数据List，默认为null

        // 版本号不能为空，验证版本号
        try {
            if (null != orderMenu.getVersion() && !orderMenu.getVersion().isEmpty()) {
                // 前者大则返回一个正数，后者大返回一个负数，相等则返回0
                int compare = VersionCompare.compare(orderMenu.getVersion(), Config.VERSION);
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
        count = orderMenuService.deleteByIdList(orderMenu.getUuidlist());

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

