package com.xurent.keshe.pa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xurent.keshe.model.Article;
import com.xurent.keshe.model.Content;
import com.xurent.keshe.model.Image;
import com.xurent.keshe.model.Url;
import com.xurent.keshe.service.ArticleService;
import com.xurent.keshe.service.ContentService;
import com.xurent.keshe.service.ImageService;
import com.xurent.keshe.service.UrlService;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;


public class DemoAutoNewsCrawler extends BreadthCrawler{


	private ArticleService articleService;
	private ContentService contentService;
	private ImageService imageService;
	private UrlService urlService;
	public DemoAutoNewsCrawler(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		/**������ȡ����վ��ַ
         * addSeed ��ʾ�������
         * �������ӻ�����������֮ǰ���뵽ץȡ��Ϣ�в����Ϊδץȡ״̬.������̳�Ϊע��*/
       /* this.addSeed("http://www.mafengwo.cn/i/11390550.html");
        this.addSeed("http://www.mafengwo.cn/i/11436254.html");
        this.addSeed("http://www.mafengwo.cn/i/11404046.html");
        this.addSeed("http://www.mafengwo.cn/i/11433318.html");
		this.addSeed("http://www.mafengwo.cn/i/11390550.html");
		this.addSeed("http://www.mafengwo.cn/i/11416598.html");		 
		this.addSeed("http://www.mafengwo.cn/i/11435214.html");
		this.addSeed("http://www.mafengwo.cn/i/11407546.html");
		this.addSeed("http://www.mafengwo.cn/i/11418814.html");
		this.addSeed("http://www.mafengwo.cn/i/10390798.html");
		this.addSeed("http://www.mafengwo.cn/i/11403170.html"); */
		
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("application.xml");
		 articleService=(ArticleService) ctx.getBean("articleService");
		 contentService=(ContentService) ctx.getBean("contentService");
		 imageService=(ImageService) ctx.getBean("imageService");
		 urlService=(UrlService) ctx.getBean("urlService");
		 
		 List<Url> u=urlService.getAll();
		 for(Url url:u) {
			 System.out.println(url.toString());
			 this.addSeed(url.getUrl());
		 }
		
        /**
         * ѭ�������4�����ӣ���ʵ���Ƿ�ҳ��������ƣ�
         * https://blog.github.com/page/2/
         * https://blog.github.com/page/3/
         * https://blog.github.com/page/4/
         * https://blog.github.com/page/5/
         */
		
      /*  for (int pageIndex =11190550 ; pageIndex <= 13430662; pageIndex++) {
            String seedUrl = String.format("http://www.mafengwo.cn/i/%d.html", pageIndex);
            System.out.println(seedUrl);
            this.addSeed(seedUrl);
        }*/
 
        /** addRegex ����Ϊһ�� url ������ʽ, �������ڹ��˲���ץȡ�����ӣ��� .js .jpg .css ... ��
         * Ҳ����ָ��ץȡĳЩ��������ӣ����� addRegex �л�ץȡ �����ַ��
         * https://blog.github.com/2018-07-13-graphql-for-octokit/
         * */
//        this.addRegex("http://www.mafengwo.cn/[0-9]{4}-[0-9]{2}-[0-9]{2}-[^/]+/");
        /**
         * ���� jpg|png|gif ��ͼƬ��ַ ʱ��
         * this.addRegex("-.*\\.(jpg|png|gif).*");
         * ���� ����ֵΪ "#" �ĵ�ַʱ��
         * this.addRegex("-.*#.*");
         */
 
        /**�����߳���*/
        setThreads(10);
        getConf().setTopN(30);
 
        /**
         * �Ƿ���жϵ���ȡ��Ĭ��Ϊ false
         * setResumable(true);
         */

	}

	@Override
	public void visit(Page page, CrawlDatums next) {
        String url = page.url();
        System.out.println(url); 
        int fid=Integer.parseInt(url.substring(url.indexOf("i/")+2, url.indexOf(".html")));
        
        System.out.println("id=="+fid);
        System.out.println(articleService.getOneby_fid(fid));
        if(articleService.getOneby_fid(fid)==true) {
        	System.out.println(articleService.getOneby_fid(fid));
        	System.out.println("�����ظ��������!");
        	return;
        }
        
        Article art=new Article();
        art.setF_id(fid);
		/**�����ҳ���ַ ȷʵ��Ҫ����ȡ��ַ�������ȡֵ
         */
        if (page.matchUrl("http://www.mafengwo.cn/i/[0-9]*.html")) {
 	
        	System.out.println("******==="+url);
            /**
             * ͨ�� ѡ���� ��ȡҳ�� �����Լ� ��������
             * */
            String title = page.select("title").first().text().trim();
            art.setTitle(title); 
            articleService.add(art);
            int c_size = page.select("div[class=vc_article]").select("p[class=_j_note_content _j_seqitem]").size();
            for(int i=0;i<c_size;i++) {
            	String  content=page.select("div[class=vc_article]").select("p[class=_j_note_content _j_seqitem]")
            			.get(i).text();
            	System.out.println("content:\n" + content);
            	Content ctx=new Content();           
            	ctx.setContent(content);
            	ctx.setA_id(fid);
            	contentService.add(ctx);
            }            
        	
            int c=page.select("div[class=vc_article]").select("div[class=add_pic _j_anchorcnt _j_seqitem]")
            		.size();            
            for(int i=0;i<c;i++) {
            	String urls=page.select("div[class=vc_article]").select("div[class=add_pic _j_anchorcnt _j_seqitem]")
                		.get(i).select("img").attr("data-rt-src").toString();
            	System.out.println("img_:"+urls);
            	Image img=new Image();
            	//img.setId(0);
            	img.setUrl(urls);
            	img.setA_id(fid);;
            	imageService.add(img);
            	            	
            }
               
            System.out.println("URL:\n" + url);
            System.out.println("title:\n" + title);
            
           // System.out.println("img:\n" + imgs.toString());
        }else {
        	
        	}
        	
        }

		
	

	
	
	
}
