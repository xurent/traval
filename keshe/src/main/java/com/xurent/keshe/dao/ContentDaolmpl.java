package com.xurent.keshe.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.xurent.keshe.model.Content;


@Repository("contentDao")
public class ContentDaolmpl extends BaseDao<Content> implements ContentDao {

	@Override
	public List<Content> getAll() {
		String hql="from CONTENT";
		Session session=getSession();
		Query<Content> query=session.createQuery(hql);
		return query.list();
	}

}
