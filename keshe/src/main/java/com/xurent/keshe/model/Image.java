package com.xurent.keshe.model;

public class Image {
	
	private int id;
	
	private String url;
	
	private int a_id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", url=" + url + ", a_id=" + a_id + "]";
	}

	

}
