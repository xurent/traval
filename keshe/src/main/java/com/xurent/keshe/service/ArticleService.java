package com.xurent.keshe.service;

import java.util.List;

import com.xurent.keshe.model.Article;
public interface ArticleService extends BaseServicel<Article>{
	/**
	 * ��ȡ��������ͼ��
	 * @param art
	 */
	public List<Article> getAll();
	
	/**
	 * ͨ��f_id��ȡ
	 * @return
	 */
	public boolean getOneby_fid(int fid);
}
