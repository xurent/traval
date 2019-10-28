package com.xurent.keshe.dao;

import java.util.List;

import com.xurent.keshe.model.Travel;


public interface TravelDao {

	/**
	 * ��ȡ��������
	 * @return
	 */
	public List<Travel> getAll();
	
	/**
	 * ��ҳ��ѯ
	 */
	
	public List<Travel>getAlls(int offset,int len);
	/**
	 * ��ȡ���ŵľ���
	 * @return
	 */
	
	public Travel getMax_byNum();
	
	/**
	 * �۸������
	 * @return
	 */
	
	public Travel getMin_byMoney();
	
}
