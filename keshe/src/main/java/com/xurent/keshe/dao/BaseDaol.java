package com.xurent.keshe.dao;


public interface BaseDaol<T> {

	/**
	 * 添加一条数据
	 * @param user
	 */
	public void add(T t);
	
	/**
	 * 更新数据
	 * @param user
	 * @return
	 */
	public void update(T t);
	
	/**
	 * 删除数据
	 * @param id
	 * @return
	 */
	public void delete(int id);
	
	/**
	 * 获取一条数据
	 * @param id
	 * @return
	 */
	public T  getOne(int id);
	
}
