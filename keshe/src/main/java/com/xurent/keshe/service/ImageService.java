package com.xurent.keshe.service;

import java.util.List;

import com.xurent.keshe.model.Image;

public interface ImageService extends BaseServicel<Image>{

	/**
	 * ��ȡ��������ͼ��
	 * @param art
	 */
	public List<Image> getAll();
}
