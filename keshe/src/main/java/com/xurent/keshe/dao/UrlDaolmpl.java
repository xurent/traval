package com.xurent.keshe.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.xurent.keshe.model.Url;

@Repository("urlDao")
public class UrlDaolmpl extends BaseDao<Url> implements UrlDao{

	@Override
	public List<Url> getAll() {
		String hql="from Url";
		Session session=getSession();
		Query<Url> query=session.createQuery(hql);
		return query.list();
	}

}
