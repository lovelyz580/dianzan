package com.like.restful;

import com.like.entity.User;
import com.like.service.UserService;
import com.util.Config;
import com.util.LayuiDataTemplet;
import com.util.MD5Util;
import com.util.VersionCompare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 用户表
 * 
 * Restful
 *
 * @author Lovelyz on 2019/03/21
 */

@Controller
@RequestMapping("/user")
public class F_UserRestful {

	@Autowired
	private UserService userService;

	/**
	 * 根据User实体添加
	 * 
	 * @param user
	 * @return
	 *
	 * @author Lovelyz on 2019/03/21
	 */
	@ResponseBody
	@RequestMapping("/insertByUser")
	public LayuiDataTemplet<User> insertByUser(@RequestBody User user) {
		LayuiDataTemplet<User> returnData = new LayuiDataTemplet<User>();
		returnData.setCode(0); // 默认为0
		returnData.setCount(0); // 数据的数量，默认为0
		returnData.setData(null); // 数据List，默认为null

		// 版本号不能为空，验证版本号
		try {
			if (null != user.getVersion() && !user.getVersion().isEmpty()) {
				// 前者大则返回一个正数，后者大返回一个负数，相等则返回0
				int compare = VersionCompare.compare(user.getVersion(), Config.VERSION);
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
		User userSelectData = new User();
		userSelectData.setPagenumber(-1);//不分页
		userSelectData.setUserloginname(user.getUserloginname());//登录名

		List<User> userList = userService.selectByUser(userSelectData); // 查询数据
		if (userList.size() > 0) {
			returnData.setMsg("该组织机构ID或打印员登录名已注册、请更换！");
			return returnData;
		}



		// 添加数据
		user.setUserpassword(MD5Util.encrypt(user.getUserpassword()));//MD5加密
		user.setUserid(Config.SIGN_USER + UUID.randomUUID().toString()); // 用户ID(YH+UUID)
		user.setUserstate("Y"); // 用户状态(Y:启用/N:停用)
		user.setUserdeletestate("N");//删除状态（Y：删除/N：未删除）
		user.setUserdelete("未删除");//删除状态（删除/未删除）
		user.setUsercreatetime(new Date()); // 用户创建时间
		user.setUserupdatetime(new Date());//用户更新时间

		// 添加
		int count = 0;
		count = userService.insertByUser(user);

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
	 * 根据User实体更新
	 * 
	 * @param user
	 * @return
	 *
	 * @author Lovelyz on 2019/03/21
	 */
	@ResponseBody
	@RequestMapping("/updateByUser")
	public LayuiDataTemplet<User> updateByUser(@RequestBody User user) {
		LayuiDataTemplet<User> returnData = new LayuiDataTemplet<User>(); // 返回数据
		returnData.setCode(0); // 默认为0
		returnData.setCount(0); // 数据的数量，默认为0
		returnData.setData(null); // 数据List，默认为null

		// 版本号不为空，则验证版本号
		try {
			if (user.getVersion() != null && !user.getVersion().isEmpty()) {
				// 前者大则返回一个正数，后者大返回一个负数，相等则返回0
				int compare = VersionCompare.compare(user.getVersion(), Config.VERSION);
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
		if (user.getId() == null || user.getId() == 0) {
			if (user.getUserid() == null || user.getUserid().isEmpty()) {
				returnData.setMsg("缺少更新条件，更新失败！");
				return returnData;
			}
		}

		// 更新数据
		//MD5加密
		if (null != user.getUserpassword() && !user.getUserpassword().equals("")){
			user.setUserpassword(MD5Util.encrypt(user.getUserpassword()));
		}
		user.setUserupdatetime(new Date()); // 更新时间

		// 更新
		int count = 0;
		count = userService.updateByUser(user);

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
	@ResponseBody
	@RequestMapping("/selectByUser")
	public LayuiDataTemplet<User> selectByUser(@RequestBody User user) {
		LayuiDataTemplet<User> returnData = new LayuiDataTemplet<User>(); // 返回数据
		returnData.setCode(0); // 默认为0
		returnData.setCount(0); // 数据的数量，默认为0
		returnData.setData(null); // 数据List，默认为null

		// 版本号不为空，则验证版本号
		try {
			if (user.getVersion() != null && !user.getVersion().isEmpty()) {
				// 前者大则返回一个正数，后者大返回一个负数，相等则返回0
				int compare = VersionCompare.compare(user.getVersion(), Config.VERSION);
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
		if (user.getPagenumber() != null) {
			// 计算偏移量
			if (user.getPagenumber() != -1) {
				if (user.getPagesize() == null) {
					returnData.setMsg("传递的分页数据(每页数量)错误！");
					return returnData;
				}

				// 获取传递过来的数据
				int pageNumber = user.getPagenumber();
				int pageSize = user.getPagesize();
				user.setPagenumber((pageNumber - 1) * pageSize); // 当前页数(如果不进行分页，该条数据默认为-1)
				user.setPagesize(pageSize); // 每页的数据量
			}

			// 查询数量
			int count = 0;
			count = userService.selectCountByUser(user);

			// 返回数据
			if (count == 0) {
				returnData.setMsg("暂无数据！");
			} else {
				returnData.setCount(count);
				returnData.setMsg("查询成功！");
				List<User> userList = userService.selectByUser(user); // 查询数据
				returnData.setData(userList);
			}
		} else {
			returnData.setMsg("传递的分页数据(页数)错误！");
		}

		return returnData;
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
	@ResponseBody
	@RequestMapping("/selectBySelectData")
	public LayuiDataTemplet<User> selectBySelectData(@RequestBody User user) {
		LayuiDataTemplet<User> returnData = new LayuiDataTemplet<User>(); // 返回数据
		returnData.setCode(0); // 默认为0
		returnData.setCount(0); // 数据的数量，默认为0
		returnData.setData(null); // 数据List，默认为null

		// 版本号不为空，则验证版本号
		try {
			if (user.getVersion() != null && !user.getVersion().isEmpty()) {
				// 前者大则返回一个正数，后者大返回一个负数，相等则返回0
				int compare = VersionCompare.compare(user.getVersion(), Config.VERSION);
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
		if (user.getPagenumber() != null) {
			// 计算偏移量
			if (user.getPagenumber() != -1) {
				if (user.getPagesize() == null) {
					returnData.setMsg("传递的分页数据(每页数量)错误！");
					return returnData;
				}

				// 获取传递过来的数据
				int pageNumber = user.getPagenumber();
				int pageSize = user.getPagesize();
				user.setPagenumber((pageNumber - 1) * pageSize); // 当前页数(如果不进行分页，该条数据默认为-1)
				user.setPagesize(pageSize); // 每页的数据量
			}

			// 查询数量
			int count = 0;
			count = userService.selectCountBySelectData(user); // 查询数量

			// 返回数据
			if (count == 0) {
				returnData.setMsg("暂无数据！");
			} else {
				returnData.setCount(count);
				returnData.setMsg("查询成功！");
				List<User> userList = userService.selectBySelectData(user); // 查询数据
				returnData.setData(userList);
			}
		} else {
			returnData.setMsg("传递的分页数据(页数)错误！");
		}

		return returnData;
	}



	/**
	 * 登录
	 *
	 *
	 *
	 * @param user
	 * @return
	 *
	 * @author Lovelyz on 2019/03/21
	 */
	@ResponseBody
	@RequestMapping("/login")
	public LayuiDataTemplet<User> login(@RequestBody User user) {
		LayuiDataTemplet<User> returnData = new LayuiDataTemplet<User>(); // 返回数据
		returnData.setCode(0); // 默认为0
		returnData.setCount(0); // 数据的数量，默认为0
		returnData.setData(null); // 数据List，默认为null

		// 版本号不为空，则验证版本号
		try {
			if (user.getVersion() != null && !user.getVersion().isEmpty()) {
				// 前者大则返回一个正数，后者大返回一个负数，相等则返回0
				int compare = VersionCompare.compare(user.getVersion(), Config.VERSION);
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

		// 查询用户数据，并判断用户名、密码是否正确
		if (user.getUserloginname() != null && !user.getUserloginname().isEmpty() &&
				user.getUserpassword() != null && !user.getUserpassword().isEmpty()) {
			// 根据手机号码查询数据
			User selectData = new User();
			selectData.setUserloginname(user.getUserloginname()); // 用户登录名
			selectData.setUserpassword(MD5Util.encrypt(user.getUserpassword()));//加密后的密码
            selectData.setUserstate("Y");//状态启用
			selectData.setPagenumber(-1); // 当前页数(如果不进行分页，该条数据默认为-1)

			// 查询数据
			List<User> userList = userService.selectByUser(selectData);

			// 判断用户名是否正确
			if (userList == null || userList.size() == 0) {
				// 没有该用户
				returnData.setMsg("没有该用户！");
			} else {
				// 判断密码是否正确
				if (!MD5Util.encrypt(user.getUserpassword()).equals(userList.get(0).getUserpassword())) {
					// 没有该用户
					returnData.setMsg("密码错误！");
				} else {
					returnData.setData(userList);
					returnData.setMsg("登录成功！");
				}
			}
		} else {
			// 传递的客户数据错误
			returnData.setMsg("传递的登录数据错误！");
		}

		return returnData;
	}



	/**
	 * 根据User实体删除信息(假删，更改UserDelete状态)(Y:删除、N：未删除)
	 *
	 * @param user
	 * @return
	 *
	 * @author Lovelyz on 2019/03/21
	 */
	@ResponseBody
	@RequestMapping("/updateByUserDeleteState")
	public LayuiDataTemplet<User> updateByUserDeleteState(@RequestBody User user) {
		LayuiDataTemplet<User> returnData = new LayuiDataTemplet<User>(); // 返回数据
		returnData.setCode(0); // 默认为0
		returnData.setCount(0); // 数据的数量，默认为0
		returnData.setData(null); // 数据List，默认为null

		// 版本号不为空，则验证版本号
		try {
			if (user.getVersion() != null && !user.getVersion().isEmpty()) {
				// 前者大则返回一个正数，后者大返回一个负数，相等则返回0
				int compare = VersionCompare.compare(user.getVersion(), Config.VERSION);
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
		count = userService.updateByUserDeleteState(user.getIdlist());

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
	 * @param user
	 * @return
	 *
	 * @author Lovelyz on 2019/03/21
	 */
	@ResponseBody
	@RequestMapping("/deleteByIdList")
	public LayuiDataTemplet<User> deleteByIdList(@RequestBody User user) {
		LayuiDataTemplet<User> returnData = new LayuiDataTemplet<User>(); // 返回数据
		returnData.setCode(0); // 默认为0
		returnData.setCount(0); // 数据的数量，默认为0
		returnData.setData(null); // 数据List，默认为null

		// 版本号不为空，则验证版本号
		try {
			if (user.getVersion() != null && !user.getVersion().isEmpty()) {
				// 前者大则返回一个正数，后者大返回一个负数，相等则返回0
				int compare = VersionCompare.compare(user.getVersion(), Config.VERSION);
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
		count = userService.deleteByIdList(user.getIdlist());

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
