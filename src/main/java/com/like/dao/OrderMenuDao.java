package com.like.dao;


import com.like.entity.OrderMenu;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class OrderMenuDao {

    private Logger logger = Logger.getLogger(OrderMenuDao.class);

    public int insert(SqlSession session, OrderMenu orderMenu) {
        int num = 0;

        try {
            logger.info("OrderMenuDao");

            num = session.insert("com.like.dao.mapper.OrderMenu.insert", orderMenu);
        } catch (Exception e) {
            logger.error("OrderMenuDao--insert--error:" + e.getMessage());
        }

        return num;
    }

    public int insertSelective(SqlSession session, OrderMenu orderMenu) {
        int num = 0;

        try {
            logger.info("OrderMenuDao");

            num = session.insert("com.like.dao.mapper.OrderMenu.insertSelective", orderMenu);
        } catch (Exception e) {
            logger.error("OrderMenuDao--insertSelective--error:" + e.getMessage());
        }

        return num;
    }

    public int updateByPrimaryKeySelective(SqlSession session, OrderMenu orderMenu) {
        int num = 0;

        try {
            logger.info("OrderMenuDao");

            num = session.update("com.like.dao.mapper.OrderMenu.updateByPrimaryKeySelective", orderMenu);
        } catch (Exception e) {
            logger.error("OrderMenuDao--updateByPrimaryKeySelective--error:" + e.getMessage());
        }

        return num;
    }

    public int updateByPrimaryKey(SqlSession session, OrderMenu orderMenu) {
        int num = 0;

        try {
            logger.info("OrderMenuDao");

            num = session.update("com.like.dao.mapper.OrderMenu.updateByPrimaryKey", orderMenu);
        } catch (Exception e) {
            logger.error("OrderMenuDao--updateByPrimaryKey--error:" + e.getMessage());
        }

        return num;
    }

    public int selectCountByPrimaryKey(SqlSession session, String id) {
        int num = 0;

        try {
            logger.info("OrderMenuDao");

            num = session.selectOne("com.like.dao.mapper.OrderMenu.selectCountByPrimaryKey", id);
        } catch (Exception e) {
            logger.error("OrderMenuDao--selectCountByPrimaryKey--error:" + e.getMessage());
        }

        return num;
    }

    public OrderMenu selectByPrimaryKey(SqlSession session, String id) {
        OrderMenu orderMenu = new OrderMenu();

        try {
            logger.info("OrderMenuDao");

            orderMenu = session.selectOne("com.like.dao.mapper.OrderMenu.selectByPrimaryKey", id);
        } catch (Exception e) {
            logger.error("OrderMenuDao--selectByPrimaryKey--error:" + e.getMessage());
        }

        return orderMenu;
    }

    public int deleteByPrimaryKey(SqlSession session, String id) {
        int num = 0;

        try {
            logger.info("OrderMenuDao");

            num = session.delete("com.like.dao.mapper.OrderMenu.deleteByPrimaryKey", id);
        } catch (Exception e) {
            logger.error("OrderMenuDao--deleteByPrimaryKey--error:" + e.getMessage());
        }

        return num;
    }




    /**
     * 根据OrderMenu实体添加
     *
     * @param orderMenu
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int insertByOrderMenu(SqlSession session, OrderMenu orderMenu) {
        int num = 0;

        try {
            logger.info("OrderMenuDao");

            num = session.insert("com.like.dao.mapper.OrderMenu.insertByOrderMenu", orderMenu);
        } catch (Exception e) {
            logger.error("OrderMenuDao--insertByOrderMenu--error:" + e.getMessage());
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
    public int updateByOrderMenu(SqlSession session, OrderMenu orderMenu) {
        int num = 0;

        try {
            logger.info("OrderMenuDao");

            num = session.update("com.like.dao.mapper.OrderMenu.updateByOrderMenu", orderMenu);
        } catch (Exception e) {
            logger.error("OrderMenuDao--updateByOrderMenu--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据OrderMenu实体查询
     *
     * 查询数量
     *
     * @param orderMenu
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountByOrderMenu(SqlSession session, OrderMenu orderMenu) {
        int num = 0;

        try {
            logger.info("OrderMenuDao");

            num = session.selectOne("com.like.dao.mapper.OrderMenu.selectCountByOrderMenu", orderMenu);
        } catch (Exception e) {
            logger.error("OrderMenuDao--selectCountByOrderMenu--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据OrderMenu实体查询
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
    public List<OrderMenu> selectByOrderMenu(SqlSession session, OrderMenu orderMenu) {
        List<OrderMenu> orderMenuList = new ArrayList<OrderMenu>();

        try {
            logger.info("OrderMenuDao");

            orderMenuList = session.selectList("com.like.dao.mapper.OrderMenu.selectByOrderMenu", orderMenu);
        } catch (Exception e) {
            logger.error("OrderMenuDao--selectByOrderMenu--error:" + e.getMessage());
        }

        return orderMenuList;
    }

    /**
     * 根据OrderMenu实体模糊查询
     *
     * 查询数量
     *
     * @param orderMenu
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountBySelectData(SqlSession session, OrderMenu orderMenu) {
        int num = 0;

        try {
            logger.info("OrderMenuDao");

            num = session.selectOne("com.like.dao.mapper.OrderMenu.selectCountBySelectData", orderMenu);
        } catch (Exception e) {
            logger.error("OrderMenuDao--selectCountBySelectData--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据OrderMenu实体模糊查询
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
    public List<OrderMenu> selectBySelectData(SqlSession session, OrderMenu orderMenu) {
        List<OrderMenu> orderMenuList = new ArrayList<OrderMenu>();

        try {
            logger.info("OrderMenuDao");

            orderMenuList = session.selectList("com.like.dao.mapper.OrderMenu.selectBySelectData", orderMenu);
        } catch (Exception e) {
            logger.error("OrderMenuDao--selectBySelectData--error:" + e.getMessage());
        }

        return orderMenuList;
    }

    /**
     * 根据Id实体删除(假删、更改删除状态)
     *
     * @param orderMenu
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int updateByOrderMenuDeleteState(SqlSession session, OrderMenu orderMenu) {
        int num = 0;

        try {
            logger.info("OrderMenuDao");

            num = session.update("com.like.dao.mapper.OrderMenu.updateByOrderMenuDeleteState", orderMenu);
        } catch (Exception e) {
            logger.error("OrderMenuDao--updateByOrderMenuDeleteState--error:" + e.getMessage());
        }

        return num;
    }



    /**
     * 根据OrderMenu实体删除
     *
     * @param orderMenu
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int deleteByOrderMenu(SqlSession session, OrderMenu orderMenu) {
        int num = 0;

        try {
            logger.info("OrderMenuDao");

            num = session.delete("com.like.dao.mapper.OrderMenu.deleteByOrderMenu", orderMenu);
        } catch (Exception e) {
            logger.error("OrderMenuDao--deleteByOrderMenu--error:" + e.getMessage());
        }

        return num;
    }
}