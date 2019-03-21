package com.like.service;


import com.like.dao.OrderTodayeatDao;
import com.like.entity.OrderTodayeat;
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
 * on 2019-03-21 15:07
 */
@Service
public class OrderTodayeatService {

    @Autowired
    private OrderTodayeatDao orderTodayeatDao;

    private Logger logger = Logger.getLogger(OrderTodayeatService.class);

    /**
     * 根据OrderTodayeat实体添加
     *
     * @param orderTodayeat
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int insertByOrderTodayeat(OrderTodayeat orderTodayeat) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = orderTodayeatDao.insertByOrderTodayeat(session, orderTodayeat);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("OrderTodayeatService--insertByOrderTodayeat--error:" + e.getMessage());
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
    public int updateByOrderTodayeat(OrderTodayeat orderTodayeat) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = orderTodayeatDao.updateByOrderTodayeat(session, orderTodayeat);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("OrderTodayeatService--updateByOrderTodayeat--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据OrderTodayeat实体联表查询
     *
     * 查询数量
     *
     * @param orderTodayeat
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountByOrderTodayeat(OrderTodayeat orderTodayeat) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = orderTodayeatDao.selectCountByOrderTodayeat(session, orderTodayeat);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("OrderTodayeatService--selectCountByOrderTodayeat--error:" + e.getMessage());
        }

        return num;
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
    public List<OrderTodayeat> selectByOrderTodayeat(OrderTodayeat orderTodayeat) {
        List<OrderTodayeat> orderTodayeatList = new ArrayList<OrderTodayeat>();

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            orderTodayeatList = orderTodayeatDao.selectByOrderTodayeat(session, orderTodayeat);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("OrderTodayeatService--selectByOrderTodayeat--error:" + e.getMessage());
        }

        return orderTodayeatList;
    }

    /**
     * 根据OrderTodayeat实体联表模糊查询
     *
     * 查询数量
     *
     * @param orderTodayeat
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountBySelectData(OrderTodayeat orderTodayeat) {
        int num = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            num = orderTodayeatDao.selectCountBySelectData(session, orderTodayeat);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("OrderTodayeatService--selectCountBySelectData--error:" + e.getMessage());
        }

        return num;
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
    public List<OrderTodayeat> selectBySelectData(OrderTodayeat orderTodayeat) {
        List<OrderTodayeat> orderTodayeatList = new ArrayList<OrderTodayeat>();

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            orderTodayeatList = orderTodayeatDao.selectBySelectData(session, orderTodayeat);

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("OrderTodayeatService--selectBySelectData--error:" + e.getMessage());
        }

        return orderTodayeatList;
    }



    /**
     * 根据idList删除信息(假删、更改状态)
     *
     * @param list
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int updateByOrderTodayeatDeleteState(List<String> list) {
        int deleteNum = 0;

        try {
            SqlSession session = MyBatisUtil.getInstance().getSqlSession();

            for (int i = 0; i < list.size(); i++) {
                OrderTodayeat orderTodayeat = new OrderTodayeat();
                orderTodayeat.setEatId(list.get(i));
                orderTodayeat.setEatState(0);//删除
                orderTodayeat.setEatUpdatetime(new Date());//删除时间
                deleteNum = deleteNum + orderTodayeatDao.updateByOrderTodayeatDeleteState(session, orderTodayeat);
            }

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("OrderTodayeatService--updateByOrderTodayeatDeleteState--error:" + e.getMessage());
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
                deleteNum = deleteNum + orderTodayeatDao.deleteByPrimaryKey(session, list.get(i));
            }

            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("OrderTodayeatService--deleteByIdList--error:" + e.getMessage());
        }

        return deleteNum;
    }

}
