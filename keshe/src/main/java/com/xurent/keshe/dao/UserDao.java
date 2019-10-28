package com.xurent.keshe.dao;

import java.util.List;

import com.xurent.keshe.model.User;

public interface UserDao {

	/**
	 * 获取所有数据
	 * @return
	 */
	public List<User> getAll();
	
	
	/**
	 * 判断账号是否存在
	 * @return
	 */
	
	public boolean isUserExit(String username);
	/**
	 * 验证账号密码
	 * @param user
	 * @param password
	 * @return
	 */
	public User Check_pwd(String user,String password);
	
}
