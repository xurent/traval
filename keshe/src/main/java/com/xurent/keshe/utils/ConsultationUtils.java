package com.xurent.keshe.utils;

public class ConsultationUtils {

	
	public static int getResult(String data) {
		
		if(data.isEmpty()) {
			return 0;
		}else if(data.contains("�����ŵľ���")||data.contains("�����ž���")||data.contains("���ܻ�ӭ�ľ���")||data.contains("������")) {
			
			return 1;
			
		}else if(data.contains("����˵ľ���")||data.contains("�۸���˵ľ���")||data.contains("�۸������")) {			
			return 2;
			
		}else if(data.contains("���ľ���")||data.contains("�۸����")||data.contains("��Ʊ���")) {			
			return 3;
			
		}else if(data.contains("�������")||data.contains("��վ����")) {			
			return 4;
			
		}
											
		return 0;
	}
	
	
}
