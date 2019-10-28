package com.xurent.keshe.model;

public class Message {

	private Mine mine;
	private String friend;
	private String group;
	public Mine getMine() {
		return mine;
	}
	public void setMine(Mine mine) {
		this.mine = mine;
	}
	public String getFriend() {
		return friend;
	}
	public void setFriend(String friend) {
		this.friend = friend;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	@Override
	public String toString() {
		return "Message [mine=" + mine + ", friend=" + friend + ", group=" + group + "]";
	}
	
	
	
}
