package com.xurent.keshe.dao;

import java.util.List;

import com.xurent.keshe.model.Image;


public interface ImageDao {

	/**
	 * ��ȡ��������ͼ��
	 * @param art
	 */
	public List<Image> getAll();
	
}
