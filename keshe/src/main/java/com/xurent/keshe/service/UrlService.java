package com.xurent.keshe.service;

import java.util.List;

import com.xurent.keshe.model.Url;

public interface UrlService extends BaseServicel<Url>{

	/**
	 * ��ȡ��������
	 * @return
	 */
	public List<Url> getAll();
	
}
