package com.xurent.keshe.model;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

public class User {

	private int id;
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	@NotEmpty
	private String name;
	@NotEmpty
	private String phone;
	@NotEmpty
	private String city;
	
	private String ip;
	
	private Date date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", phone="
				+ phone + ", city=" + city + ", ip=" + ip + ", date=" + date + "]";
	}

	
	
	
}
