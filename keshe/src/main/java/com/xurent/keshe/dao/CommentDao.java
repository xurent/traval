package com.xurent.keshe.dao;

import java.util.List;

import com.xurent.keshe.model.Comment;

public interface CommentDao {

	/**
	 * ��ȡ�����û�����
	 * @return
	 */
	public List<Comment> getAll();
	
	/**
	 * ͨ������id��ȡ�����û�����
	 * @return
	 */
	
	public List<Comment> getAllby_tid(int t_id);
}
