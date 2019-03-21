package com.like.dao;

import com.like.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;


/**
 * 用户表
 *
 * Dao
 *
 * @author Lovelyz on 2019/03/21
 */

@Repository
public class UserDao {

    private Logger logger = Logger.getLogger(UserDao.class);

    public int insert(SqlSession session, User user) {
        int num = 0;

        try {
            logger.info("UserDao");

            num = session.insert("sun.bz1.dao.mapper.User.insert", user);
        } catch (Exception e) {
            logger.error("UserDao--insert--error:" + e.getMessage());
        }

        return num;
    }

    public int insertSelective(SqlSession session, User user) {
        int num = 0;

        try {
            logger.info("UserDao");

            num = session.insert("sun.bz1.dao.mapper.User.insertSelective", user);
        } catch (Exception e) {
            logger.error("UserDao--insertSelective--error:" + e.getMessage());
        }

        return num;
    }

    public int updateByPrimaryKeySelective(SqlSession session, User user) {
        int num = 0;

        try {
            logger.info("UserDao");

            num = session.update("sun.bz1.dao.mapper.User.updateByPrimaryKeySelective", user);
        } catch (Exception e) {
            logger.error("UserDao--updateByPrimaryKeySelective--error:" + e.getMessage());
        }

        return num;
    }

    public int updateByPrimaryKey(SqlSession session, User user) {
        int num = 0;

        try {
            logger.info("UserDao");

            num = session.update("sun.bz1.dao.mapper.User.updateByPrimaryKey", user);
        } catch (Exception e) {
            logger.error("UserDao--updateByPrimaryKey--error:" + e.getMessage());
        }

        return num;
    }

    public int selectCountByPrimaryKey(SqlSession session, Integer id) {
        int num = 0;

        try {
            logger.info("UserDao");

            num = session.selectOne("sun.bz1.dao.mapper.User.selectCountByPrimaryKey", id);
        } catch (Exception e) {
            logger.error("UserDao--selectCountByPrimaryKey--error:" + e.getMessage());
        }

        return num;
    }

    public User selectByPrimaryKey(SqlSession session, Integer id) {
        User user = new User();

        try {
            logger.info("UserDao");

            user = session.selectOne("sun.bz1.dao.mapper.User.selectByPrimaryKey", id);
        } catch (Exception e) {
            logger.error("UserDao--selectByPrimaryKey--error:" + e.getMessage());
        }

        return user;
    }

    public int deleteByPrimaryKey(SqlSession session, Integer id) {
        int num = 0;

        try {
            logger.info("UserDao");

            num = session.delete("sun.bz1.dao.mapper.User.deleteByPrimaryKey", id);
        } catch (Exception e) {
            logger.error("UserDao--deleteByPrimaryKey--error:" + e.getMessage());
        }

        return num;
    }




    /**
     * 根据User实体添加
     *
     * @param user
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int insertByUser(SqlSession session, User user) {
        int num = 0;

        try {
            logger.info("UserDao");

            num = session.insert("sun.bz1.dao.mapper.User.insertByUser", user);
        } catch (Exception e) {
            logger.error("UserDao--insertByUser--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据User实体更新
     *
     * @param user
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int updateByUser(SqlSession session, User user) {
        int num = 0;

        try {
            logger.info("UserDao");

            num = session.update("sun.bz1.dao.mapper.User.updateByUser", user);
        } catch (Exception e) {
            logger.error("UserDao--updateByUser--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据User实体查询
     *
     * 查询数量
     *
     * @param user
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountByUser(SqlSession session, User user) {
        int num = 0;

        try {
            logger.info("UserDao");

            num = session.selectOne("sun.bz1.dao.mapper.User.selectCountByUser", user);
        } catch (Exception e) {
            logger.error("UserDao--selectCountByUser--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据User实体查询
     *
     * 可以进行分页查询
     *
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     *
     * pageSize 每页的数据量
     *
     * @param user
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public List<User> selectByUser(SqlSession session, User user) {
        List<User> userList = new ArrayList<User>();

        try {
            logger.info("UserDao");

            userList = session.selectList("sun.bz1.dao.mapper.User.selectByUser", user);
        } catch (Exception e) {
            logger.error("UserDao--selectByUser--error:" + e.getMessage());
        }

        return userList;
    }

    /**
     * 根据User实体模糊查询
     *
     * 查询数量
     *
     * @param user
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int selectCountBySelectData(SqlSession session, User user) {
        int num = 0;

        try {
            logger.info("UserDao");

            num = session.selectOne("sun.bz1.dao.mapper.User.selectCountBySelectData", user);
        } catch (Exception e) {
            logger.error("UserDao--selectCountBySelectData--error:" + e.getMessage());
        }

        return num;
    }

    /**
     * 根据User实体模糊查询
     *
     * 可以进行分页查询
     *
     * pageNumber 当前页数(如果不进行分页，该条数据默认为-1)
     *
     * pageSize 每页的数据量
     *
     * @param user
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public List<User> selectBySelectData(SqlSession session, User user) {
        List<User> userList = new ArrayList<User>();

        try {
            logger.info("UserDao");

            userList = session.selectList("sun.bz1.dao.mapper.User.selectBySelectData", user);
        } catch (Exception e) {
            logger.error("UserDao--selectBySelectData--error:" + e.getMessage());
        }

        return userList;
    }

    /**
     * 根据Id实体删除(假删、更改删除状态)
     *
     * @param user
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int updateByUserDeleteState(SqlSession session, User user) {
        int num = 0;

        try {
            logger.info("UserDao");

            num = session.update("sun.bz1.dao.mapper.User.updateByUserDeleteState", user);
        } catch (Exception e) {
            logger.error("UserDao--updateByUserDeleteState--error:" + e.getMessage());
        }

        return num;
    }



    /**
     * 根据User实体删除
     *
     * @param user
     * @return
     *
     * @author Lovelyz on 2019/03/21
     */
    public int deleteByUser(SqlSession session, User user) {
        int num = 0;

        try {
            logger.info("UserDao");

            num = session.delete("sun.bz1.dao.mapper.User.deleteByUser", user);
        } catch (Exception e) {
            logger.error("UserDao--deleteByUser--error:" + e.getMessage());
        }

        return num;
    }
}