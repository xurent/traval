package com.xurent.keshe.dao;

import java.util.List;

import com.xurent.keshe.model.Article;

public interface ArticleDao {
	
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
