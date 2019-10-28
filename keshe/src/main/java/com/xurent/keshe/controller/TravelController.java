package com.xurent.keshe.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xurent.keshe.model.Comment;
import com.xurent.keshe.model.Data;
import com.xurent.keshe.model.Travel;
import com.xurent.keshe.model.User;
import com.xurent.keshe.service.CommentService;
import com.xurent.keshe.service.TravelService;
import com.xurent.keshe.service.UserService;

@Controller
public class TravelController {

	@Autowired
	private TravelService travelService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private UserService userService;
	private int len=1;
	private String fileName=null;
	
	@RequestMapping(value= {"/index/{id}" ,"/{id}","/bootstrap/index/{id}","/bootstrap/index.*/{id}"},method=RequestMethod.GET)
	public String load(@PathVariable("id")  Integer id,Model model) {
		if(id==null||id<=1) {
			id=1;
		}
		System.out.println("id==="+id);	
		 len=travelService.getAll().size();
		model.addAttribute("travels", travelService.getAlls(id,len));				
		return "bootstrap/index";
	}
	
	@RequestMapping(value={"/bootstrap/index","/bootstrap/index.jsp"},method=RequestMethod.GET)
	public String  init(@RequestParam(value="id",required=false)Integer id,Model model) {		
		
		int len=travelService.getAll().size();
		System.out.println("初始化~"+len);
		model.addAttribute("travels", travelService.getAlls(0,len));
		return "bootstrap/index";
	}
	
	
	
	
	@RequestMapping(value="/see/{id}",method=RequestMethod.GET)
	public String details(@PathVariable("id")  Integer id,Model model) {
		
		if(id==null||id<=1) {
			id=1;
		}else if(id>travelService.getAll().size()) {
			id=len;
		}
		Travel tr=travelService.getOne(id);
		if(tr!=null) {
			long num=tr.getNum();//浏览次数
			num++;
			tr.setNum(num);
		}
		travelService.update(tr);
		model.addAttribute("travel", tr);
		/*if(demo!=null||file!=null) {//评论不为空
			System.out.println("demo:"+demo);
			System.out.println("file:"+file);
			//判断用户是否登录
			User user=(User) session.getAttribute("user");
			if(user!= null) {
				Comment cot=new Comment();
				cot.setU_id(user.getId());
				cot.setName(user.getName());
				cot.setT_id(id);
				cot.setContent(demo+" "+file);
				cot.setDate(new Date());
				commentService.add(cot);
			}else {
				model.addAttribute("info", "404");
			}
		}*/
		List<Comment> cots=commentService.getAllby_tid(id);
		System.out.println(cots.toString());
		model.addAttribute("cots", cots);
		
		return "bootstrap/travel";
	}
	
	@RequestMapping(value="/see/{id}",method=RequestMethod.POST)
	public String PingLun(@PathVariable("id")  Integer id,Model model,@RequestParam(value="demo",required=false)
	String demo,@RequestParam(value="file",required=false) String file,HttpSession session) {
		Travel tr=travelService.getOne(id);
		model.addAttribute("travel", tr);
		if(demo!=null||file!=null) {//评论不为空
			System.out.println("demo:"+demo);
			System.out.println("file:"+file);
			//判断用户是否登录
			User user=(User) session.getAttribute("user");
			if(user!= null) {
				Comment cot=new Comment();
				cot.setU_id(user.getId());
				cot.setName(user.getName());
				cot.setT_id(id);
				cot.setContent(demo+" "+file);
				cot.setDate(new Date());
				commentService.add(cot);
			}else {
				model.addAttribute("info", "404");
			}
		}
		
		List<Comment> cots=commentService.getAllby_tid(id);
		System.out.println(cots.toString());
		model.addAttribute("cots", cots);
		return "bootstrap/travel";
	}
	
	
	
	@ResponseBody
	@RequestMapping(value= {"/coment/json","/admin/coment/json"},method=RequestMethod.GET)
	public Data<Comment> UserJson(@RequestParam("page") int pid,@RequestParam("limit") int limit) {
		System.out.println("page:"+pid+"limit=="+limit);
		System.out.println("返回json数据~");
		List<Comment> cot=commentService.getAll();
		Data<Comment> data=new Data<Comment>();
		data.setCode(200);
		data.setData(cot);
		return data;
	}
	
	@ResponseBody
	@RequestMapping(value= {"/admin/travel/json"},method=RequestMethod.GET)
	public Data<Travel> TravelJson(@RequestParam("page") int pid,@RequestParam("limit") int limit) {		
		List<Travel> cot=travelService.getAll();
		Data<Travel> data=new Data<Travel>();
		data.setCode(200);
		data.setData(cot);
		return data;
	}
	
	@ResponseBody
	@RequestMapping(value="/admin/img",method=RequestMethod.POST)
	public Data<String> Submit(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IOException {
			Data<String> data=new Data<>();
		if(!file.isEmpty()) {
			//上传文件路径
			String path=request.getServletContext().getRealPath("/resources/uploadfiles");
			//被传上来的源文件名
			System.out.println(path);
			String file_Name=file.getOriginalFilename();
			System.out.println(file_Name);
			int pointIndex = file_Name.indexOf(".");                        //点号的位置	    
	 		String fileSuffix = file_Name.substring(pointIndex);             //截取文件后缀
			UUID FileId = UUID.randomUUID();                        //生成文件的前缀包含连字符
			String savedFileName = FileId.toString().replace("-","").concat(fileSuffix);       //文件存取名			
			fileName="../resources/uploadfiles/"+savedFileName;//虚拟路径
			System.out.println(fileName);
			File filepath=new File(path,savedFileName);
			//判断路径是否存在，不存在则创建一个
			if(!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();//创建
			}
			file.transferTo(filepath);//写进硬盘			
			data.setCode(200);			
		}
		
		return data;		
	}
	
	
	@RequestMapping(value="/admin/submit",method=RequestMethod.POST)
	public void Submit(Travel travel,HttpServletResponse resp) throws IOException {
				
		System.out.println(travel);
		if(fileName!=null&&travel!=null) {		
			travel.setDate(new Date());			
			travel.setNum(0);
			travel.setImg(fileName);
		travelService.add(travel);
		fileName=null;
		resp.getWriter().println("<div> <h2>上传成功!</h2>  <div>");
		}else {			
			resp.getWriter().println("<div> <h3>上传失败!所有内容不能为空</h3>  <div>");
		}
		
	}
	@ResponseBody
	@RequestMapping(value="admin/del/json",method=RequestMethod.GET)
	public Data<String> del(@RequestParam("id") Integer id,@RequestParam("type")String type) {
		System.out.println(id+"===type:"+type);
		Data<String> data=new Data<>();	
		if(id!=null&&type!=null) {
			switch(type) {
			case "1":
				userService.delete(id);
				break;
			case "2":
				commentService.delete(id);
				break;
			case "3":
				travelService.delete(id);
				break;
			}
			data.setCode(200);
			data.setRes("ok");
		}else {
			data.setCode(0);
			data.setRes("fail");
		}
		return data;
	}
	
	@RequestMapping(value= {"/chat","bootstrap/chat"},method=RequestMethod.GET)
	public String Chat() {
		System.out.println("跳转智能问答页面");
		
		return "redirect:/admin/layui/chart.html";
	}
}
