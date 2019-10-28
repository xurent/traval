package com.xurent.keshe.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.xurent.keshe.model.Image;

@Repository("imageDao")
public class ImageDaolmpl extends BaseDao<Image> implements ImageDao{

	@Override
	public List<Image> getAll() {
		String hql="from image";
		Session session=getSession();
		Query<Image> query=session.createQuery(hql);
		return query.list();
	}

}
