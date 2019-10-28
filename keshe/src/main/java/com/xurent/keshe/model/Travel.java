package com.xurent.keshe.model;

import java.util.Date;

public class Travel {

	private int id;
	
	private String title;
	
	private double money;
	
	private String img;
	
	private String content;
	
	private long num;//ทรฮสดฮสý
	
	private String addr;

	private Date date;
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

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Travel [id=" + id + ", title=" + title + ", money=" + money + ", img=" + img + ", content=" + content
				+ ", num=" + num + ", addr=" + addr + ", date=" + date + "]";
	}

	

	
	
	
	
}
