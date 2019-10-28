package com.xurent.keshe.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.xurent.keshe.model.User;

@Repository("userDao")
public class UserDaolpml extends BaseDao<User> implements UserDao {

	@Override
	public List<User> getAll() {
		String hql="from User";
		Session session=getSession();
		Query<User> query=session.createQuery(hql);
		return query.list();
	}

	@Override
	public boolean isUserExit(String username) {
		String hql="from User where username=?1";
		Session session=getSession();
		Query<User> query=session.createQuery(hql);
		query.setParameter(1, username);
		if(!query.list().isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public User Check_pwd(String user, String password) {
		String hql="from User where username=?1 and password=?2";
		Session session=getSession();
		Query<User> query=session.createQuery(hql);
		query.setParameter(1, user);
		query.setParameter(2, password);
		if(!query.list().isEmpty()) {
			return query.list().get(0);
		}
		return null;
	}
	
	
}
