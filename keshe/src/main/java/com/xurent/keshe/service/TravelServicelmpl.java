package com.xurent.keshe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xurent.keshe.dao.TravelDao;
import com.xurent.keshe.model.Travel;

@Service("travelService")
public class TravelServicelmpl extends BaseService<Travel>  implements TravelService{

	@Autowired
	private TravelDao travelDao;
	@Override
	public List<Travel> getAll() {
		// TODO Auto-generated method stub
		return travelDao.getAll();
	}
	@Override
	public List<Travel> getAlls(int offset,int len) {
		// TODO Auto-generated method stub
		return travelDao.getAlls(offset, len);
	}
	@Override
	public Travel getMax_byNum() {
		// TODO Auto-generated method stub
		return travelDao.getMax_byNum();
	}
	@Override
	public Travel getMin_byMoney() {
		// TODO Auto-generated method stub
		return travelDao.getMin_byMoney();
	}

}
