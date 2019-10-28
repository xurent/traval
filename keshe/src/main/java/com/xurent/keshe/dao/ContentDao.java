package com.xurent.keshe.dao;

import java.util.List;

import com.xurent.keshe.model.Content;


public interface ContentDao {

	/**
	 * 获取所有文
	 * @param art
	 */
	public List<Content> getAll();
	
}
