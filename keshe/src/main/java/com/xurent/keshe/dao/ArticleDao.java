package com.xurent.keshe.dao;

import java.util.List;

import com.xurent.keshe.model.Article;

public interface ArticleDao {
	
	/**
	 * 获取所有旅游图文
	 * @param art
	 */
	public List<Article> getAll();
	
	/**
	 * 通过f_id获取
	 * @return
	 */
	public boolean getOneby_fid(int fid);

}
