package com.xurent.keshe.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.xurent.keshe.dao.BaseDao;


public class BaseService<T> implements BaseServicel<T> {

	@Autowired
	public BaseDao<T> baseDao;
	
	@Override
	public void add(T t) {
		baseDao.add(t);
		
	}

	@Override
	public void update(T t) {
		baseDao.update(t);
	}

	@Override
	public void delete(int id) {
		baseDao.delete(id);	
	}

	@Override
	public T getOne(int id) {
		return baseDao.getOne(id);
	}

}
