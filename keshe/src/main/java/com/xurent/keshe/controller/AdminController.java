package com.xurent.keshe.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xurent.keshe.model.Chat;
import com.xurent.keshe.model.Data;
import com.xurent.keshe.model.Message;
import com.xurent.keshe.model.Mine;
@Controller
public class AdminController {

	private String Code="";
	@ResponseBody
	@RequestMapping(value= {"/admin/login"},method=RequestMethod.POST)
	public Data<String> Admin(@RequestParam("login") String login,@RequestParam("pwd") 
	String pwd,@RequestParam("code") String code,HttpSession session)
	{
		Data<String> data=new Data<>();
		System.out.println("code==="+code);			
		if(login==null||pwd==null) {			
			data.setCode(0);
			return data;
		}else {
			System.out.println("==="+login+pwd);
			if(login.equals("123456")&&pwd.equals("123456")||
					login.equals("admin")&&pwd.equals("123456")) {
				System.out.println("cao");
				if(code.equals(Code)) {
					data.setCode(200);
					session.setAttribute("admin", "ok");
					return data;
				}else {
					data.setCode(-1);
					return data;
				}				
			}else {
				data.setCode(0);
				System.out.println("cri");
			}
		}
		
		return data;
	}
	
	@RequestMapping(value= {"/admin/code"},method=RequestMethod.POST)
	public void Code(@RequestParam("code") String code) {
		Code=code;
		System.out.println("获取验证码:"+Code);
	}
	
	
	
	
	
}
