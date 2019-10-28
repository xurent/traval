package com.xurent.keshe.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xurent.keshe.model.Data;
import com.xurent.keshe.model.User;
import com.xurent.keshe.service.ArticleService;
import com.xurent.keshe.service.UserService;


@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView Register(@Valid User user,Errors err,HttpServletRequest req)  {
		
		ModelAndView ma=new ModelAndView();
		if(err.getErrorCount()>0) {
			
			System.out.println("某些数据不符合数据有效性检验");
			for(FieldError fe:err.getFieldErrors()) {
				System.out.println("==="+fe.getField()+":"+fe.getDefaultMessage());
			}			
			ma.setViewName("bootstrap/register");
			return ma;
		}
		if(userService.isUserExit(user.getUsername())) {
			System.out.println(user.toString()+"-------------");
			ma.addObject("note","该账号已经存在!");
			ma.setViewName("bootstrap/register");
			return ma;
		}
		System.out.println(user.toString());
		user.setDate(new Date());
		user.setIp(req.getRemoteAddr());
		userService.add(user);
		//ma.addObject("note", "");
		ma.setViewName("bootstrap/login");
		return ma;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(HttpServletRequest req) throws ServletException, IOException {
		
		String name=req.getParameter("username");
		String password=req.getParameter("password");
		
		if(name==""||name==null||password==""||password==null) {			
			return "bootstrap/login";
		}
		User yes=userService.Check_pwd(name, password);
		if(yes!=null) {
			System.out.println("登录成功:"+yes.toString());
			req.getSession().setAttribute("user",yes);		
			return "redirect:bootstrap/index";
		}else {
			req.setAttribute("note", "账号密码错误");
			return "bootstrap/login";
		}
		
	}
	
	@RequestMapping(value="exit",method=RequestMethod.GET)
	public String Exit(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:bootstrap/index";
	}
	
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String addUserView(Model model) {
			   	
		return "bootstrap/register";
	}
	
	
	@ResponseBody
	@RequestMapping(value= {"/user/json","/admin/user/json"},method=RequestMethod.GET)
	public Data<User> UserJson(@RequestParam("page") int pid,@RequestParam("limit") int limit) {
		System.out.println("page:"+pid+"limit=="+limit);
		System.out.println("返回json数据~");
		List<User> user=userService.getAllUsers();
		Data<User> data=new Data<User>();
		data.setCode(200);
		data.setData(user);
		return data;
	}
	
	
}
