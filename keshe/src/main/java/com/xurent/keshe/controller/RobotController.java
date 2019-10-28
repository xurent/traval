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
		/*String data="{ code:0 ,msg:'',data:{mine:{username:'摇光', id:'1',status:'online',"
				+ "sigin:'在深邃的编码世界，做一枚轻盈的纸飞机' ,avatar :''  }}}";
		*/
		Mine mine=new Mine();
		mine.setId(10000);
		mine.setStatus("online");
		mine.setUsername("摇光");
		mine.setAvatar("../dist/images/1.png");
		mine.setSign("在深邃的编码世界，做一枚轻盈的纸飞机");
		
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
		String returnResult="暂时没有相关的回答,嘻嘻~~";
		if(data.isEmpty()) {
			data="你好!";
		}
		
		if(ConsultationUtils.getResult(data)==1) {
			Travel tr=travelService.getMax_byNum();
			returnResult="访问最多最热门景点:"+tr.getTitle()+", 价格:"+tr.getMoney()+"元, 地址:"+tr.getAddr()+"face[威武] face[威武] face[威武] face[威武]";
			
		}else if(ConsultationUtils.getResult(data)==2) {
			Travel tr=travelService.getMin_byMoney();
			returnResult="景点门票最便宜:"+tr.getTitle()+", 价格:"+tr.getMoney()+"元,地址:"+tr.getAddr()+" face[心] face[心] face[心]";
			
		}else if(ConsultationUtils.getResult(data)==3) {
			returnResult="最贵的就不要了,哈哈 face[微笑]";
			
		}else if(ConsultationUtils.getResult(data)==4) {
			returnResult="网站目前发布了"+travelService.getAll().size()+"个景点,该系统可以通过用户上传旅游景点等分享到该平台，并且通过数据分析，用户点击量等推荐出热门的旅游以及最受欢迎的景点。除此之外我们还赋予\r\n" + 
					"了该网站强大的智能问答系统，用户可以通过该系统得到相关旅游方面的咨询。";
			
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
		conn.addRequestProperty("Charset","UTF-8");//设置字符编码类型
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
			System.out.println("请求图灵API失败!");
		}
		
	}
		
		return returnResult;
	}
	
	
}
