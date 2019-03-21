package com.like.dao;


import com.like.entity.OrderLike;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderLikeDao {

    private Logger logger = Logger.getLogger(OrderLikeDao.class);

    public int insert(SqlSession session, OrderLike orderLike) {
        int num = 0;

        try {
            logger.info("OrderLikeDao");

            num = session.insert("com.like.dao.mapper.OrderLike.insert", orderLike);
        } catch (Exception e) {
            logger.error("OrderLikeDao--insert--error:" + e.getMessage());
        }

        return num;
    }

    public int insertSelective(SqlSession session, OrderLike orderLike) {
        int num = 0;

        try {
            logger.info("OrderLikeDao");

            num = session.insert("com.like.dao.mapper.OrderLike.insertSelective", orderLike);
        } catch (Exception e) {
            logger.error("OrderLikeDao--insertSelective--error:" + e.getMessage());
        }

        return num;
    }

    public int updateByPrimaryKeySelective(SqlSession session, OrderLike orderLike) {
        int num = 0;

        try {
            logger.info("OrderLikeDao");

            num = session.update("com.like.dao.mapper.OrderLike.updateByPrimaryKeySelective", orderLike);
        } catch (Exception e) {
            logger.error("OrderLikeDao--updateByPrimaryKeySelective--error:" + e.getMessage());
        }

        return num;
    }

    public int updateByPrimaryKey(SqlSession session, OrderLike orderLike) {
        int num = 0;

        try {
            logger.info("OrderLikeDao");

            num = session.update("com.like.dao.mapper.OrderLike.updateByPrimaryKey", orderLike);
        } catch (Exception e) {
            logger.error("OrderLikeDao--updateByPrimaryKey--error:" + e.getMessage());
        }

        return num;
    }

    public int selectCountByPrimaryKey(SqlSession session, String id) {
        int num = 0;

        try {
            logger.info("OrderLikeDao");

            num = session.selectOne("com.like.dao.mapper.OrderLike.selectCountByPrimaryKey", id);
        } catch (Exception e) {
            logger.error("OrderLikeDao--selectCountByPrimaryKey--error:" + e.getMessage());
        }

        return num;
    }

    public OrderLike selectByPrimaryKey(SqlSession session, String id) {
        OrderLike orderLike = new OrderLike();

        try {
            logger.info("OrderLikeDao");

            orderLike = session.selectOne("com.like.dao.mapper.OrderLike.selectByPrimaryKey", id);
        } catch (Exception e) {
            logger.error("OrderLikeDao--selectByPrimaryKey--error:" + e.getMessage());
        }

        return orderLike;
    }

    public int deleteByPrimaryKey(SqlSession session, String id) {
        int num = 0;

        try {
            logger.info("OrderLikeDao");

            num = session.delete("com.like.dao.mapper.OrderLike.deleteByPrimaryKey", id);
        } catch (Exception e) {
            logger.error("OrderLikeDao--deleteByPrimaryKey--error:" + e.getMessage());
        }

        return num;
    }




    /**
     * 根据OrderLike实体添加
     *
     * @param orderLike
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int insertByOrderLike(SqlSession session, OrderLike orderLike) {
        int num = 0;

        try {
            logger.info("OrderLikeDao");

            num = session.insert("com.like.dao.mapper.OrderLike.insertByOrderLike", orderLike);
        } catch (Exception e) {
            logger.error("OrderLikeDao--insertByOrderLike--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据OrderLike实体更新
     *
     * @param orderLike
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int updateByOrderLike(SqlSession session, OrderLike orderLike) {
        int num = 0;

        try {
            logger.info("OrderLikeDao");

            num = session.update("com.like.dao.mapper.OrderLike.updateByOrderLike", orderLike);
        } catch (Exception e) {
            logger.error("OrderLikeDao--updateByOrderLike--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据OrderLike实体查询
     *
     * 查询数量
     *
     * @param orderLike
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountByOrderLike(SqlSession session, OrderLike orderLike) {
        int num = 0;

        try {
            logger.info("OrderLikeDao");

            num = session.selectOne("com.like.dao.mapper.OrderLike.selectCountByOrderLike", orderLike);
        } catch (Exception e) {
            logger.error("OrderLikeDao--selectCountByOrderLike--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据OrderLike实体查询
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
    public List<OrderLike> selectByOrderLike(SqlSession session, OrderLike orderLike) {
        List<OrderLike> orderLikeList = new ArrayList<OrderLike>();

        try {
            logger.info("OrderLikeDao");

            orderLikeList = session.selectList("com.like.dao.mapper.OrderLike.selectByOrderLike", orderLike);
        } catch (Exception e) {
            logger.error("OrderLikeDao--selectByOrderLike--error:" + e.getMessage());
        }

        return orderLikeList;
    }

    /**
     * 根据OrderLike实体模糊查询
     *
     * 查询数量
     *
     * @param orderLike
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountBySelectData(SqlSession session, OrderLike orderLike) {
        int num = 0;

        try {
            logger.info("OrderLikeDao");

            num = session.selectOne("com.like.dao.mapper.OrderLike.selectCountBySelectData", orderLike);
        } catch (Exception e) {
            logger.error("OrderLikeDao--selectCountBySelectData--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据OrderLike实体模糊查询
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
    public List<OrderLike> selectBySelectData(SqlSession session, OrderLike orderLike) {
        List<OrderLike> orderLikeList = new ArrayList<OrderLike>();

        try {
            logger.info("OrderLikeDao");

            orderLikeList = session.selectList("com.like.dao.mapper.OrderLike.selectBySelectData", orderLike);
        } catch (Exception e) {
            logger.error("OrderLikeDao--selectBySelectData--error:" + e.getMessage());
        }

        return orderLikeList;
    }

    /**
     * 根据Id实体删除(假删、更改删除状态)
     *
     * @param orderLike
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int updateByOrderLikeDeleteState(SqlSession session, OrderLike orderLike) {
        int num = 0;

        try {
            logger.info("OrderLikeDao");

            num = session.update("com.like.dao.mapper.OrderLike.updateByOrderLikeDeleteState", orderLike);
        } catch (Exception e) {
            logger.error("OrderLikeDao--updateByOrderLikeDeleteState--error:" + e.getMessage());
        }

        return num;
    }



    /**
     * 根据OrderLike实体删除
     *
     * @param orderLike
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int deleteByOrderLike(SqlSession session, OrderLike orderLike) {
        int num = 0;

        try {
            logger.info("OrderLikeDao");

            num = session.delete("com.like.dao.mapper.OrderLike.deleteByOrderLike", orderLike);
        } catch (Exception e) {
            logger.error("OrderLikeDao--deleteByOrderLike--error:" + e.getMessage());
        }

        return num;
    }
}