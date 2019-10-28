package com.xurent.keshe.dao;

import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("baseDao")
public class BaseDao<T> {
	
	@SuppressWarnings("unchecked")
	public Class<T> getTClass(){
		Class<T> tClass=(Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		return tClass;
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		
		return sessionFactory.getCurrentSession();
	}
	
	public void add(T t) {
		getSession().save(t);	
	}
	
	public void update(T t) {
		getSession().update(t);
	}
	
	public void delete(int id) {		
		 getSession().delete(getOne(id));
	}

	public T getOne(int id) {
		return getSession().load(getTClass(), id);
	}
	
}
