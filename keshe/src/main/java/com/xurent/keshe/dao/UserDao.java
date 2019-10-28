package com.xurent.keshe.dao;

import java.util.List;

import com.xurent.keshe.model.User;

public interface UserDao {

	/**
	 * ��ȡ��������
	 * @return
	 */
	public List<User> getAll();
	
	
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
