package com.xurent.keshe.model;

public class Chat {

	private int code;
	
	private Message data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Message getData() {
		return data;
	}

	public void setData(Message data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Chat [code=" + code + ", data=" + data + "]";
	}
	
	
	
}
