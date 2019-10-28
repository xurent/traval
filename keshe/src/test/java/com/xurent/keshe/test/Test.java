package com.xurent.keshe.test;

import org.springframework.beans.factory.annotation.Autowired;

import com.xurent.keshe.service.ArticleService;

public class Test {
	
	@Autowired
	private ArticleService articleService;
	@org.junit.Test
	public void Test() {
		System.out.println(articleService);
	}
}
