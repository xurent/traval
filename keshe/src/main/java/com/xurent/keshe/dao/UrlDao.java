package com.xurent.keshe.dao;

import java.util.List;

import com.xurent.keshe.model.Url;



public interface UrlDao {

	/**
	 * 获取所有数据
	 * @return
	 */
	public List<Url> getAll();
}
