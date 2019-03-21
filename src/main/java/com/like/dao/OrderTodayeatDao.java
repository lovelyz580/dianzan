package com.like.dao;

import com.like.entity.OrderTodayeat;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderTodayeatDao {

    private Logger logger = Logger.getLogger(OrderTodayeatDao.class);

    public int insert(SqlSession session, OrderTodayeat orderTodayeat) {
        int num = 0;

        try {
            logger.info("OrderTodayeatDao");

            num = session.insert("com.like.dao.mapper.OrderTodayeat.insert", orderTodayeat);
        } catch (Exception e) {
            logger.error("OrderTodayeatDao--insert--error:" + e.getMessage());
        }

        return num;
    }

    public int insertSelective(SqlSession session, OrderTodayeat orderTodayeat) {
        int num = 0;

        try {
            logger.info("OrderTodayeatDao");

            num = session.insert("com.like.dao.mapper.OrderTodayeat.insertSelective", orderTodayeat);
        } catch (Exception e) {
            logger.error("OrderTodayeatDao--insertSelective--error:" + e.getMessage());
        }

        return num;
    }

    public int updateByPrimaryKeySelective(SqlSession session, OrderTodayeat orderTodayeat) {
        int num = 0;

        try {
            logger.info("OrderTodayeatDao");

            num = session.update("com.like.dao.mapper.OrderTodayeat.updateByPrimaryKeySelective", orderTodayeat);
        } catch (Exception e) {
            logger.error("OrderTodayeatDao--updateByPrimaryKeySelective--error:" + e.getMessage());
        }

        return num;
    }

    public int updateByPrimaryKey(SqlSession session, OrderTodayeat orderTodayeat) {
        int num = 0;

        try {
            logger.info("OrderTodayeatDao");

            num = session.update("com.like.dao.mapper.OrderTodayeat.updateByPrimaryKey", orderTodayeat);
        } catch (Exception e) {
            logger.error("OrderTodayeatDao--updateByPrimaryKey--error:" + e.getMessage());
        }

        return num;
    }

    public int selectCountByPrimaryKey(SqlSession session, String id) {
        int num = 0;

        try {
            logger.info("OrderTodayeatDao");

            num = session.selectOne("com.like.dao.mapper.OrderTodayeat.selectCountByPrimaryKey", id);
        } catch (Exception e) {
            logger.error("OrderTodayeatDao--selectCountByPrimaryKey--error:" + e.getMessage());
        }

        return num;
    }

    public OrderTodayeat selectByPrimaryKey(SqlSession session, String id) {
        OrderTodayeat orderTodayeat = new OrderTodayeat();

        try {
            logger.info("OrderTodayeatDao");

            orderTodayeat = session.selectOne("com.like.dao.mapper.OrderTodayeat.selectByPrimaryKey", id);
        } catch (Exception e) {
            logger.error("OrderTodayeatDao--selectByPrimaryKey--error:" + e.getMessage());
        }

        return orderTodayeat;
    }

    public int deleteByPrimaryKey(SqlSession session, String id) {
        int num = 0;

        try {
            logger.info("OrderTodayeatDao");

            num = session.delete("com.like.dao.mapper.OrderTodayeat.deleteByPrimaryKey", id);
        } catch (Exception e) {
            logger.error("OrderTodayeatDao--deleteByPrimaryKey--error:" + e.getMessage());
        }

        return num;
    }




    /**
     * 根据OrderTodayeat实体添加
     *
     * @param orderTodayeat
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int insertByOrderTodayeat(SqlSession session, OrderTodayeat orderTodayeat) {
        int num = 0;

        try {
            logger.info("OrderTodayeatDao");

            num = session.insert("com.like.dao.mapper.OrderTodayeat.insertByOrderTodayeat", orderTodayeat);
        } catch (Exception e) {
            logger.error("OrderTodayeatDao--insertByOrderTodayeat--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据OrderTodayeat实体更新
     *
     * @param orderTodayeat
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int updateByOrderTodayeat(SqlSession session, OrderTodayeat orderTodayeat) {
        int num = 0;

        try {
            logger.info("OrderTodayeatDao");

            num = session.update("com.like.dao.mapper.OrderTodayeat.updateByOrderTodayeat", orderTodayeat);
        } catch (Exception e) {
            logger.error("OrderTodayeatDao--updateByOrderTodayeat--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据OrderTodayeat实体查询
     *
     * 查询数量
     *
     * @param orderTodayeat
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountByOrderTodayeat(SqlSession session, OrderTodayeat orderTodayeat) {
        int num = 0;

        try {
            logger.info("OrderTodayeatDao");

            num = session.selectOne("com.like.dao.mapper.OrderTodayeat.selectCountByOrderTodayeat", orderTodayeat);
        } catch (Exception e) {
            logger.error("OrderTodayeatDao--selectCountByOrderTodayeat--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据OrderTodayeat实体查询
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
    public List<OrderTodayeat> selectByOrderTodayeat(SqlSession session, OrderTodayeat orderTodayeat) {
        List<OrderTodayeat> orderTodayeatList = new ArrayList<OrderTodayeat>();

        try {
            logger.info("OrderTodayeatDao");

            orderTodayeatList = session.selectList("com.like.dao.mapper.OrderTodayeat.selectByOrderTodayeat", orderTodayeat);
        } catch (Exception e) {
            logger.error("OrderTodayeatDao--selectByOrderTodayeat--error:" + e.getMessage());
        }

        return orderTodayeatList;
    }

    /**
     * 根据OrderTodayeat实体模糊查询
     *
     * 查询数量
     *
     * @param orderTodayeat
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountBySelectData(SqlSession session, OrderTodayeat orderTodayeat) {
        int num = 0;

        try {
            logger.info("OrderTodayeatDao");

            num = session.selectOne("com.like.dao.mapper.OrderTodayeat.selectCountBySelectData", orderTodayeat);
        } catch (Exception e) {
            logger.error("OrderTodayeatDao--selectCountBySelectData--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据OrderTodayeat实体模糊查询
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
    public List<OrderTodayeat> selectBySelectData(SqlSession session, OrderTodayeat orderTodayeat) {
        List<OrderTodayeat> orderTodayeatList = new ArrayList<OrderTodayeat>();

        try {
            logger.info("OrderTodayeatDao");

            orderTodayeatList = session.selectList("com.like.dao.mapper.OrderTodayeat.selectBySelectData", orderTodayeat);
        } catch (Exception e) {
            logger.error("OrderTodayeatDao--selectBySelectData--error:" + e.getMessage());
        }

        return orderTodayeatList;
    }

    /**
     * 根据Id实体删除(假删、更改删除状态)
     *
     * @param orderTodayeat
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int updateByOrderTodayeatDeleteState(SqlSession session, OrderTodayeat orderTodayeat) {
        int num = 0;

        try {
            logger.info("OrderTodayeatDao");

            num = session.update("com.like.dao.mapper.OrderTodayeat.updateByOrderTodayeatDeleteState", orderTodayeat);
        } catch (Exception e) {
            logger.error("OrderTodayeatDao--updateByOrderTodayeatDeleteState--error:" + e.getMessage());
        }

        return num;
    }



    /**
     * 根据OrderTodayeat实体删除
     *
     * @param orderTodayeat
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int deleteByOrderTodayeat(SqlSession session, OrderTodayeat orderTodayeat) {
        int num = 0;

        try {
            logger.info("OrderTodayeatDao");

            num = session.delete("com.like.dao.mapper.OrderTodayeat.deleteByOrderTodayeat", orderTodayeat);
        } catch (Exception e) {
            logger.error("OrderTodayeatDao--deleteByOrderTodayeat--error:" + e.getMessage());
        }

        return num;
    }
}