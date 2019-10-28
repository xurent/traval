package com.xurent.keshe.service;

public interface BaseServicel<T> {

	/**
	 * ���һ������
	 * @param user
	 */
	public void add(T t);
	
	/**
	 * ��������
	 * @param user
	 * @return
	 */
	public void update(T t);
	
	/**
	 * ɾ������
	 * @param id
	 * @return
	 */
	public void delete(int id);
	
	/**
	 * ��ȡһ������
	 * @param id
	 * @return
	 */
	public T  getOne(int id);
	
}
