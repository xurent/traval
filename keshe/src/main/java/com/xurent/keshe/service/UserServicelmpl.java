package com.xurent.keshe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xurent.keshe.dao.UserDao;
import com.xurent.keshe.model.User;


@Service("userService")
public class UserServicelmpl extends BaseService<User> implements UserService{

	@Autowired
	private UserDao userDao;
	@Override
	public List<User> getAllUsers() {
		
		return userDao.getAll();
	}
	
	@Override
	public boolean isUserExit(String username) {
		// TODO Auto-generated method stub
		return userDao.isUserExit(username);
	}

	@Override
	public User Check_pwd(String user, String password) {
		// TODO Auto-generated method stub
		return userDao.Check_pwd(user, password);
	}

}
