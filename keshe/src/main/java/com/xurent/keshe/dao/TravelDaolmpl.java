package com.xurent.keshe.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.xurent.keshe.model.Travel;

@Repository("travelDao")
public class TravelDaolmpl extends BaseDao<Travel>  implements TravelDao{

	@Override
	public List<Travel> getAll() {
		String hql="from Travel";
		Session session=getSession();
		Query<Travel> query=session.createQuery(hql);
		return query.list();
	}

	@Override
	public List<Travel> getAlls(int offset,int len) {
		String hql="from Travel";
		Session session=getSession();
		Query<Travel> query=session.createQuery(hql);		
		int s=(offset-1)*4;
		if(s>0) {
		query.setFirstResult(s);
		}else {
			query.setFirstResult(0);
		}
		if(len-s>=4) {
			query.setMaxResults(4);
			
		}else if(len-s>0&&len-s<4) {
			query.setMaxResults(len-s);
		}else {
			query.setMaxResults(0);
		}
		
		return query.list();
	}
	
	public Travel getMax_byNum() {
		String hql="from Travel where num=(select max(num) from Travel)";
		Session session=getSession();
		Query<Travel> query=session.createQuery(hql);
		return query.list().get(0);
	}

	@Override
	public Travel getMin_byMoney() {
		String hql="from Travel where money=(select min(money) from Travel)";
		Session session=getSession();
		Query<Travel> query=session.createQuery(hql);
		return query.list().get(0);
	}
	

}
