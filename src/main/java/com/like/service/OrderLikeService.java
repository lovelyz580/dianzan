package com.like.service;

import com.like.dao.OrderLikeDao;
import com.like.entity.OrderLike;
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
 * on 2019-03-21 13:52
 */
@Service
public class OrderLikeService {

    @Autowired
    private OrderLikeDao orderLikeDao;

    private Logger logger = Logger.getLogger(OrderLikeService.class);

    /**
     * 根据OrderLike实体添加
     *
     * @param orderLike
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int insertByOrderLike(OrderLike orderLike) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = orderLikeDao.insertByOrderLike(session, orderLike);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("OrderLikeService--insertByOrderLike--error:" + e.getMessage());
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
    public int updateByOrderLike(OrderLike orderLike) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = orderLikeDao.updateByOrderLike(session, orderLike);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("OrderLikeService--updateByOrderLike--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据OrderLike实体联表查询
     *
     * 查询数量
     *
     * @param orderLike
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountByOrderLike(OrderLike orderLike) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = orderLikeDao.selectCountByOrderLike(session, orderLike);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("OrderLikeService--selectCountByOrderLike--error:" + e.getMessage());
        }

        return num;
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
    public List<OrderLike> selectByOrderLike(OrderLike orderLike) {
        List<OrderLike> orderLikeList = new ArrayList<OrderLike>();

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            orderLikeList = orderLikeDao.selectByOrderLike(session, orderLike);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("OrderLikeService--selectByOrderLike--error:" + e.getMessage());
        }

        return orderLikeList;
    }

    /**
     * 根据OrderLike实体联表模糊查询
     *
     * 查询数量
     *
     * @param orderLike
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountBySelectData(OrderLike orderLike) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = orderLikeDao.selectCountBySelectData(session, orderLike);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("OrderLikeService--selectCountBySelectData--error:" + e.getMessage());
        }

        return num;
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
    public List<OrderLike> selectBySelectData(OrderLike orderLike) {
        List<OrderLike> orderLikeList = new ArrayList<OrderLike>();

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            orderLikeList = orderLikeDao.selectBySelectData(session, orderLike);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("OrderLikeService--selectBySelectData--error:" + e.getMessage());
        }

        return orderLikeList;
    }



    /**
     * 根据idList删除信息(假删、更改状态)
     *
     * @param list
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int updateByOrderLikeDeleteState(List<String> list) {
        int deleteNum = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            for (int i = 0; i < list.size(); i++) {
                OrderLike orderLike = new OrderLike();
               orderLike.setLikeId(list.get(i));
                orderLike.setLikeState(0);//删除
                orderLike.setLikeUpdatetime(new Date());//删除时间
                deleteNum = deleteNum + orderLikeDao.updateByOrderLikeDeleteState(session, orderLike);
            }

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("OrderLikeService--updateByOrderLikeDeleteState--error:" + e.getMessage());
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
                deleteNum = deleteNum + orderLikeDao.deleteByPrimaryKey(session, list.get(i));
            }

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("OrderLikeService--deleteByIdList--error:" + e.getMessage());
        }

        return deleteNum;
    }

}
