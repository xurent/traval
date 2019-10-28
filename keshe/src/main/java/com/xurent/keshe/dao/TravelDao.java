package com.xurent.keshe.dao;

import java.util.List;

import com.xurent.keshe.model.Travel;


public interface TravelDao {

	/**
	 * 获取所有数据
	 * @return
	 */
	public List<Travel> getAll();
	
	/**
	 * 分页查询
	 */
	
	public List<Travel>getAlls(int offset,int len);
	/**
	 * 获取热门的景点
	 * @return
	 */
	
	public Travel getMax_byNum();
	
	/**
	 * 价格最便宜
	 * @return
	 */
	
	public Travel getMin_byMoney();
	
}
