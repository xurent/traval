package com.xurent.keshe.service;

import java.util.List;

import com.xurent.keshe.model.Url;

public interface UrlService extends BaseServicel<Url>{

	/**
	 * 获取所有数据
	 * @return
	 */
	public List<Url> getAll();
	
}
