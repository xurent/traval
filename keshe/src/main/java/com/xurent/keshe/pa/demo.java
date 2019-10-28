package com.xurent.keshe.pa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xurent.keshe.service.ArticleService;

public class demo {


	
	public static void main(String []args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("application.xml");
		ArticleService articleService=(ArticleService) ctx.getBean("articleService");
		System.out.println(articleService.getOneby_fid(111));
	}
	
}
