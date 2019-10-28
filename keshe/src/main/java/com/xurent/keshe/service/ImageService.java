package com.xurent.keshe.service;

import java.util.List;

import com.xurent.keshe.model.Image;

public interface ImageService extends BaseServicel<Image>{

	/**
	 * 获取所有旅游图文
	 * @param art
	 */
	public List<Image> getAll();
}
