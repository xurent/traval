package com.xurent.keshe.dao;

import java.util.List;

import com.xurent.keshe.model.Content;


public interface ContentDao {

	/**
	 * ��ȡ������
	 * @param art
	 */
	public List<Content> getAll();
	
}
