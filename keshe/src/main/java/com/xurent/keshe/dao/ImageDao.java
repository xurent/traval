package com.xurent.keshe.dao;

import java.util.List;

import com.xurent.keshe.model.Image;


public interface ImageDao {

	/**
	 * 获取所有旅游图文
	 * @param art
	 */
	public List<Image> getAll();
	
}
