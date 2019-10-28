package com.xurent.keshe.model;

import java.util.List;

public class Data<T> {

	private int code;
	
	private List<T> data;
	
	private  T res;
	
	
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public T getRes() {
		return res;
	}

	public void setRes(T res) {
		this.res = res;
	}

	@Override
	public String toString() {
		return "Data [code=" + code + ", data=" + data + ", res=" + res + "]";
	}

	

	
	
	
	
}
