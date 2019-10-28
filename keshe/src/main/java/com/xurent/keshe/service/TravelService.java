package com.xurent.keshe.service;

import java.util.List;

import com.xurent.keshe.model.Travel;

public interface TravelService extends BaseServicel<Travel>{
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
	 * ��ȡ�۸���ߵľ���
	 * @return
	 */
	
	public Travel getMax_byNum();
	
	
	public Travel getMin_byMoney();
}
