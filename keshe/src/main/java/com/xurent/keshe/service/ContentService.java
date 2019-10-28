package com.xurent.keshe.service;

import java.util.List;

import com.xurent.keshe.model.Content;

public interface ContentService extends BaseServicel<Content>{

	/**
	 * 获取所有文
	 * @param art
	 */
	public List<Content> getAll();
	
}
