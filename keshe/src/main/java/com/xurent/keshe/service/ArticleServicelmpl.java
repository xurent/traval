package com.xurent.keshe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xurent.keshe.dao.ArticleDao;
import com.xurent.keshe.model.Article;

@Service("articleService")
public class ArticleServicelmpl extends BaseService<Article> implements ArticleService{

	@Autowired
	private ArticleDao articleDao;
	
	@Override
	public List<Article> getAll() {
		
		return articleDao.getAll();
	}

	@Override
	public boolean getOneby_fid(int fid) {
		// TODO Auto-generated method stub
		return articleDao.getOneby_fid(fid);
	}

}
