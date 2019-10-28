package com.xurent.keshe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xurent.keshe.dao.UrlDao;
import com.xurent.keshe.model.Url;

@Service("urlService")
public class UrlServicelmpl extends BaseService<Url> implements UrlService{

	@Autowired
	private UrlDao urlDao;
	
	@Override
	public List<Url> getAll() {
		// TODO Auto-generated method stub
		return urlDao.getAll();
	}

}
