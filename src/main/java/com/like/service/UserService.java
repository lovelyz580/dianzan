package com.like.service;

import com.like.dao.UserDao;
import com.like.entity.User;
import com.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户表
 *
 * Service
 *
 * @author Lovelyz on 2019/03/21
 */

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	private Logger logger = Logger.getLogger(UserService.class);

	/**
	 * 根据User实体添加
	 * 
	 * @param user
	 * @return
	 *
	 * @author Lovelyz on 2019/03/21
	 */
	public int insertByUser(User user) {
		int num = 0;

		try {
			SqlSession session = MyBatisUtil.getInstance().getSqlSession();

			num = userDao.insertByUser(session, user);

			session.commit();
			session.close();
		} catch (Exception e) {
			logger.error("UserService--insertByUser--error:" + e.getMessage());
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
	public int updateByUser(User user) {
		int num = 0;

		try {
			SqlSession session = MyBatisUtil.getInstance().getSqlSession();

			num = userDao.updateByUser(session, user);

			session.commit();
			session.close();
		} catch (Exception e) {
			logger.error("UserService--updateByUser--error:" + e.getMessage());
		}

		return num;
	}

	/**
	 * 根据User实体联表查询
	 * 
	 * 查询数量
	 * 
	 * @param user
	 * @return
	 *
	 * @author Lovelyz on 2019/03/21
	 */
	public int selectCountByUser(User user) {
		int num = 0;

		try {
			SqlSession session = MyBatisUtil.getInstance().getSqlSession();

			num = userDao.selectCountByUser(session, user);

			session.commit();
			session.close();
		} catch (Exception e) {
			logger.error("UserService--selectCountByUser--error:" + e.getMessage());
		}

		return num;
	}

	/**
	 * 根据User实体联表查询
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
	public List<User> selectByUser(User user) {
		List<User> userList = new ArrayList<User>();

		try {
			SqlSession session = MyBatisUtil.getInstance().getSqlSession();

			userList = userDao.selectByUser(session, user);

			session.commit();
			session.close();
		} catch (Exception e) {
			logger.error("UserService--selectByUser--error:" + e.getMessage());
		}

		return userList;
	}

	/**
	 * 根据User实体联表模糊查询
	 * 
	 * 查询数量
	 * 
	 * @param user
	 * @return
	 *
	 * @author Lovelyz on 2019/03/21
	 */
	public int selectCountBySelectData(User user) {
		int num = 0;

		try {
			SqlSession session = MyBatisUtil.getInstance().getSqlSession();

			num = userDao.selectCountBySelectData(session, user);

			session.commit();
			session.close();
		} catch (Exception e) {
			logger.error("UserService--selectCountBySelectData--error:" + e.getMessage());
		}

		return num;
	}

	/**
	 * 根据User实体联表模糊查询
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
	public List<User> selectBySelectData(User user) {
		List<User> userList = new ArrayList<User>();

		try {
			SqlSession session = MyBatisUtil.getInstance().getSqlSession();

			userList = userDao.selectBySelectData(session, user);

			session.commit();
			session.close();
		} catch (Exception e) {
			logger.error("UserService--selectBySelectData--error:" + e.getMessage());
		}

		return userList;
	}



	/**
	 * 根据idList删除信息(假删、更改状态)
	 *
	 * @param list
	 * @return
	 *
	 * @author Lovelyz on 2019/03/21
	 */
	public int updateByUserDeleteState(List<Integer> list) {
		int deleteNum = 0;

		try {
			SqlSession session = MyBatisUtil.getInstance().getSqlSession();

			for (int i = 0; i < list.size(); i++) {
				User user = new User();
				user.setId(list.get(i));
				user.setUserdeletestate("Y");//删除
				user.setUserdelete("删除");
				user.setUserupdatetime(new Date());//删除时间
				deleteNum = deleteNum + userDao.updateByUserDeleteState(session, user);
			}

			session.commit();
			session.close();
		} catch (Exception e) {
			logger.error("UserService--updateByUserDeleteState--error:" + e.getMessage());
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
	public int deleteByIdList(List<Integer> list) {
		int deleteNum = 0;

		try {
			SqlSession session = MyBatisUtil.getInstance().getSqlSession();

			for (int i = 0; i < list.size(); i++) {
				deleteNum = deleteNum + userDao.deleteByPrimaryKey(session, list.get(i));
			}

			session.commit();
			session.close();
		} catch (Exception e) {
			logger.error("UserService--deleteByIdList--error:" + e.getMessage());
		}

		return deleteNum;
	}

}
