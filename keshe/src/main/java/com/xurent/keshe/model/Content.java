package com.xurent.keshe.model;

public class Content {
	
	private int id;
	
	private String content;
	
	private int a_id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	@Override
	public String toString() {
		return "Content [id=" + id + ", content=" + content + ", a_id=" + a_id + "]";
	}

	
	
	

}
