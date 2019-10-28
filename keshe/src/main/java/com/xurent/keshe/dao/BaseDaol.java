package com.xurent.keshe.dao;


public interface BaseDaol<T> {

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
