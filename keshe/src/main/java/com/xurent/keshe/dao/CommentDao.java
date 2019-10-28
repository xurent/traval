package com.xurent.keshe.dao;

import java.util.List;

import com.xurent.keshe.model.Comment;

public interface CommentDao {

	/**
	 * 获取所有用户评论
	 * @return
	 */
	public List<Comment> getAll();
	
	/**
	 * 通过景点id获取所有用户评论
	 * @return
	 */
	
	public List<Comment> getAllby_tid(int t_id);
}
