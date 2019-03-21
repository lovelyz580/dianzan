package com.like.service;

import com.like.dao.OrderMenuDao;
import com.like.entity.OrderMenu;
import com.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Lovelyz
 * on 2019-03-21 09:43
 */
@Service
public class OrderMenuService {

    @Autowired
    private OrderMenuDao orderMenuDao;

    private Logger logger = Logger.getLogger(OrderMenuService.class);

    /**
     * 根据OrderMenu实体添加
     *
     * @param orderMenu
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int insertByOrderMenu(OrderMenu orderMenu) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = orderMenuDao.insertByOrderMenu(session, orderMenu);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("OrderMenuService--insertByOrderMenu--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据OrderMenu实体更新
     *
     * @param orderMenu
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int updateByOrderMenu(OrderMenu orderMenu) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = orderMenuDao.updateByOrderMenu(session, orderMenu);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("OrderMenuService--updateByOrderMenu--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据OrderMenu实体联表查询
     *
     * 查询数量
     *
     * @param orderMenu
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountByOrderMenu(OrderMenu orderMenu) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = orderMenuDao.selectCountByOrderMenu(session, orderMenu);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("OrderMenuService--selectCountByOrderMenu--error:" + e.getMessage());
        }

        return num;
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
    public List<OrderMenu> selectByOrderMenu(OrderMenu orderMenu) {
        List<OrderMenu> orderMenuList = new ArrayList<OrderMenu>();

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            orderMenuList = orderMenuDao.selectByOrderMenu(session, orderMenu);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("OrderMenuService--selectByOrderMenu--error:" + e.getMessage());
        }

        return orderMenuList;
    }

    /**
     * 根据OrderMenu实体联表模糊查询
     *
     * 查询数量
     *
     * @param orderMenu
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountBySelectData(OrderMenu orderMenu) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = orderMenuDao.selectCountBySelectData(session, orderMenu);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("OrderMenuService--selectCountBySelectData--error:" + e.getMessage());
        }

        return num;
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
    public List<OrderMenu> selectBySelectData(OrderMenu orderMenu) {
        List<OrderMenu> orderMenuList = new ArrayList<OrderMenu>();

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            orderMenuList = orderMenuDao.selectBySelectData(session, orderMenu);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("UserService--selectBySelectData--error:" + e.getMessage());
        }

        return orderMenuList;
    }



    /**
     * 根据idList删除信息(假删、更改状态)
     *
     * @param list
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int updateByOrderMenuDeleteState(List<String> list) {
        int deleteNum = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            for (int i = 0; i < list.size(); i++) {
                OrderMenu orderMenu = new OrderMenu();
                orderMenu.setMenuId(list.get(i));
                orderMenu.setMenuState(0);//删除
                orderMenu.setMenuUpdatetime(new Date());//删除时间
                deleteNum = deleteNum + orderMenuDao.updateByOrderMenuDeleteState(session, orderMenu);
            }

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("OrderMenuService--updateByOrderMenuDeleteState--error:" + e.getMessage());
        }

        return deleteNum;
    }


    /**
     * 根据idList删除信息
     *
     * @param list
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int deleteByIdList(List<String> list) {
        int deleteNum = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            for (int i = 0; i < list.size(); i++) {
                deleteNum = deleteNum + orderMenuDao.deleteByPrimaryKey(session, list.get(i));
            }

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("OrderMenuService--deleteByIdList--error:" + e.getMessage());
        }

        return deleteNum;
    }

}
