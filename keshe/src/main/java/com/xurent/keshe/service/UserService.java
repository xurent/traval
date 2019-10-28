package com.xurent.keshe.service;

import java.util.List;

import com.xurent.keshe.model.User;


public interface UserService extends BaseServicel<User>{

	public List<User> getAllUsers();
	
	
	/**
	 * ÅĞ¶ÏÕËºÅÊÇ·ñ´æÔÚ
	 * @return
	 */
	
	public boolean isUserExit(String username);
	
	/**
	 * ÑéÖ¤ÕËºÅÃÜÂë
	 * @param user
	 * @param password
	 * @return
	 */
	public User Check_pwd(String user,String password);
}
