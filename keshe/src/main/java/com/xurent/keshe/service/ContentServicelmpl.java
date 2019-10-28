package com.xurent.keshe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xurent.keshe.dao.ContentDao;
import com.xurent.keshe.model.Content;

@Service("contentService")
public class ContentServicelmpl extends BaseService<Content> implements ContentService{

	@Autowired
	private ContentDao content;
	@Override
	public List<Content> getAll() {
		// TODO Auto-generated method stub
		return content.getAll();
	}

}
