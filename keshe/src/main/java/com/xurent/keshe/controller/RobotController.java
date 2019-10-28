package com.xurent.keshe.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.xurent.keshe.model.Chat;
import com.xurent.keshe.model.Message;
import com.xurent.keshe.model.Mine;
import com.xurent.keshe.model.Travel;
import com.xurent.keshe.model.robot.InputText;
import com.xurent.keshe.model.robot.Perception;
import com.xurent.keshe.model.robot.TulinRobot;
import com.xurent.keshe.model.robot.UserInfo;
import com.xurent.keshe.service.TravelService;
import com.xurent.keshe.utils.ConsultationUtils;
import com.xurent.keshe.utils.StreamTool;

import net.sf.json.JSONObject;

@Controller
public class RobotController {

	private  final String apikey="0a063b64a78147f8b0ba79c7489021c4";
	private  final String key="6248d8b38fc76864";
	private final String url_Api="http://openapi.tuling123.com/openapi/api/v2";
	
	@Autowired
	private TravelService travelService;
	
	@ResponseBody
	@RequestMapping(value="/admin/chat",method=RequestMethod.GET)
	public Chat chart() throws Exception{
		
		/*URL url =new URL("https://www.layui.com/layim/json/getList.json");
		HttpURLConnection conn=(HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		int code=conn.getResponseCode();
		System.out.println("cdoe==="+code);
		if(code==200) {
			InputStream is=conn.getInputStream();
			String result=StreamTool.Read(is);
			System.out.println(result);
			return result;
		}*/
		/*String data="{ code:0 ,msg:'',data:{mine:{username:'ҡ��', id:'1',status:'online',"
				+ "sigin:'������ı������磬��һö��ӯ��ֽ�ɻ�' ,avatar :''  }}}";
		*/
		Mine mine=new Mine();
		mine.setId(10000);
		mine.setStatus("online");
		mine.setUsername("ҡ��");
		mine.setAvatar("../dist/images/1.png");
		mine.setSign("������ı������磬��һö��ӯ��ֽ�ɻ�");
		
		Message msg=new Message();
		msg.setMine(mine);
		Chat data=new Chat();
		data.setCode(0);
		data.setData(msg);
		
		return data;
	}
	
	
	@ResponseBody
	@RequestMapping(value= {"/chat/json","/admin/chat/json"},produces={"text/html;charset=UTF-8;","application/json;"},method=RequestMethod.POST)
	public String Robot(@RequestParam("data") String data) throws Exception {
		
		System.out.println("data=="+data);
		String returnResult="��ʱû����صĻش�,����~~";
		if(data.isEmpty()) {
			data="���!";
		}
		
		if(ConsultationUtils.getResult(data)==1) {
			Travel tr=travelService.getMax_byNum();
			returnResult="������������ž���:"+tr.getTitle()+", �۸�:"+tr.getMoney()+"Ԫ, ��ַ:"+tr.getAddr()+"face[����] face[����] face[����] face[����]";
			
		}else if(ConsultationUtils.getResult(data)==2) {
			Travel tr=travelService.getMin_byMoney();
			returnResult="������Ʊ�����:"+tr.getTitle()+", �۸�:"+tr.getMoney()+"Ԫ,��ַ:"+tr.getAddr()+" face[��] face[��] face[��]";
			
		}else if(ConsultationUtils.getResult(data)==3) {
			returnResult="���ľͲ�Ҫ��,���� face[΢Ц]";
			
		}else if(ConsultationUtils.getResult(data)==4) {
			returnResult="��վĿǰ������"+travelService.getAll().size()+"������,��ϵͳ����ͨ���û��ϴ����ξ���ȷ�����ƽ̨������ͨ�����ݷ������û���������Ƽ������ŵ������Լ����ܻ�ӭ�ľ��㡣����֮�����ǻ�����\r\n" + 
					"�˸���վǿ��������ʴ�ϵͳ���û�����ͨ����ϵͳ�õ�������η������ѯ��";
			
		}else {
		
		Perception perception=new Perception(new InputText(data));		
		TulinRobot robot =new TulinRobot();
		UserInfo userinfo=new UserInfo();
		userinfo.setApiKey(apikey);
		userinfo.setUserId(key);
		robot.setUserInfo(userinfo);
		robot.setPerception(perception);
		robot.setReqType(0);		
		URL url=new URL(url_Api);
		HttpURLConnection conn=(HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("GET");
		conn.addRequestProperty("Charset","UTF-8");//�����ַ���������
		OutputStream os=conn.getOutputStream();		
		Gson gson=new Gson();
		String jsonData=gson.toJson(robot);
		System.out.println(jsonData);
		os.write(jsonData.getBytes("utf-8"));
		os.flush();
		int Code=conn.getResponseCode();
		System.out.println("Code==="+Code);
		if(Code==200) {
			InputStream is=conn.getInputStream();
			returnResult=StreamTool.Read(is);
			System.out.println("resulet:"+returnResult);
			JSONObject JSON=JSONObject.fromObject(returnResult);			
			returnResult=JSON.getJSONArray("results").getJSONObject(0).getJSONObject("values").getString("text");
			System.out.println(returnResult);			
		}else {			
			System.out.println("����ͼ��APIʧ��!");
		}
		
	}
		
		return returnResult;
	}
	
	
}
