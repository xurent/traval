package com.xurent.keshe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xurent.keshe.dao.CommentDao;
import com.xurent.keshe.model.Comment;

@Service("commentService")
public class CommentServicelmpl extends BaseService<Comment> implements CommentService{

	@Autowired
	private CommentDao commentDao;
	@Override
	public List<Comment> getAll() {
		// TODO Auto-generated method stub
		return commentDao.getAll();
	}

	@Override
	public List<Comment> getAllby_tid(int t_id) {
		// TODO Auto-generated method stub
		return commentDao.getAllby_tid(t_id);
	}

}
