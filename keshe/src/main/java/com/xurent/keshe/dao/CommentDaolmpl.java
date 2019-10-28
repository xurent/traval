package com.xurent.keshe.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.xurent.keshe.model.Comment;

@Repository("commentDao")
public class CommentDaolmpl extends BaseDao<Comment>  implements CommentDao{

	@Override
	public List<Comment> getAll() {
		String hql="from Comment";
		Session session=getSession();
		Query<Comment> query=session.createQuery(hql);
		return query.list();
	}

	@Override
	public List<Comment> getAllby_tid(int t_id) {
		String hql="from Comment where t_id=?1";
		Session session=getSession();
		Query<Comment> query=session.createQuery(hql);
		query.setParameter(1, t_id);
		return query.list();
	}

}
