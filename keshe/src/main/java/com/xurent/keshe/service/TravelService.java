package com.xurent.keshe.service;

import java.util.List;

import com.xurent.keshe.model.Travel;

public interface TravelService extends BaseServicel<Travel>{
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
	 * 获取价格最高的景点
	 * @return
	 */
	
	public Travel getMax_byNum();
	
	
	public Travel getMin_byMoney();
}
