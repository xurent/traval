package com.xurent.keshe.model.robot;

public class UserInfo {

	private String apiKey;
	
	private String userId;

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserInfo [apiKey=" + apiKey + ", userId=" + userId + "]";
	}
	
	
	
	
}
