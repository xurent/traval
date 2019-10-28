package com.xurent.keshe.model;

import java.util.List;

public class Article {

	private int id;
	
	private String title;
	
	private int f_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getF_id() {
		return f_id;
	}

	public void setF_id(int f_id) {
		this.f_id = f_id;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", f_id=" + f_id + "]";
	}
	
	

	
	
	
	
}
