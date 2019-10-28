package com.xurent.keshe.service;

import java.util.List;

import com.xurent.keshe.model.User;


public interface UserService extends BaseServicel<User>{

	public List<User> getAllUsers();
	
	
	/**
	 * �ж��˺��Ƿ����
	 * @return
	 */
	
	public boolean isUserExit(String username);
	
	/**
	 * ��֤�˺�����
	 * @param user
	 * @param password
	 * @return
	 */
	public User Check_pwd(String user,String password);
}
