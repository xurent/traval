package com.xurent.keshe.utils;

public class ConsultationUtils {

	
	public static int getResult(String data) {
		
		if(data.isEmpty()) {
			return 0;
		}else if(data.contains("最热门的景点")||data.contains("最热门景点")||data.contains("最受欢迎的景点")||data.contains("浏览最多")) {
			
			return 1;
			
		}else if(data.contains("最便宜的景点")||data.contains("价格便宜的景点")||data.contains("价格最便宜")) {			
			return 2;
			
		}else if(data.contains("最贵的景点")||data.contains("价格最高")||data.contains("门票最贵")) {			
			return 3;
			
		}else if(data.contains("景点个数")||data.contains("网站介绍")) {			
			return 4;
			
		}
											
		return 0;
	}
	
	
}
