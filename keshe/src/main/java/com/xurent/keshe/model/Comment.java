package com.xurent.keshe.model;

import java.util.Date;

public class Comment {
	
	private int id;
	
	private int u_id;//用户id
	
	private String name;//用户名
	
	private int t_id; //景点id
	
	private String content;
	
	private Date date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", u_id=" + u_id + ", name=" + name + ", t_id=" + t_id + ", content=" + content
				+ ", date=" + date + "]";
	}

	
	

}
