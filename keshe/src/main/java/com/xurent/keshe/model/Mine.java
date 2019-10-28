package com.xurent.keshe.model;

public class Mine {

	private String username;
	private int id;
	private String status;
	private String sign;
	private String avatar;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	@Override
	public String toString() {
		return "Mine [username=" + username + ", id=" + id + ", status=" + status + ", sign=" + sign + ", avatar="
				+ avatar + "]";
	}
	
	
	
}
