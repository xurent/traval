package com.xurent.keshe.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.xurent.keshe.model.Article;


@Repository("articleDao")
public class ArticleDaolmpl extends BaseDao<Article> implements ArticleDao{

	@Override
	public List<Article> getAll() {
		String hql="from Article";
		Session session=getSession();
		Query<Article> query=session.createQuery(hql);
		return query.list();
	}

	@Override
	public boolean getOneby_fid(int fid) {
		String hql="from Article where f_id=?1";
		Session session=getSession();
		Query<Article> query=session.createQuery(hql);
		query.setParameter(1, fid);	
		if(!query.list().isEmpty()) {
			return true;
		}
		return false;
	}

}
