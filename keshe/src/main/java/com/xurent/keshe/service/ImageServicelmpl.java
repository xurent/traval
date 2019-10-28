package com.xurent.keshe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xurent.keshe.dao.ImageDao;
import com.xurent.keshe.model.Image;

@Service("imageService")
public class ImageServicelmpl extends BaseService<Image> implements ImageService{

	@Autowired
	private ImageDao imageDao;
	@Override
	public List<Image> getAll() {
		// TODO Auto-generated method stub
		return imageDao.getAll();
	}

}
