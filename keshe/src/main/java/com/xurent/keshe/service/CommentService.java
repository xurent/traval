package com.xurent.keshe.service;

import java.util.List;

import com.xurent.keshe.model.Comment;

public interface CommentService extends BaseServicel<Comment>{

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
