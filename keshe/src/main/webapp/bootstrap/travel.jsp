<%@page import="com.xurent.keshe.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests" /> -->
<title>Xurent-旅游首页</title>
<script src="${pageContext.request.contextPath}/bootstrap/lib/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/lib/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/lib/bootstrap/css/style.css">
    <script  src="${pageContext.request.contextPath}/bootstrap/lib/bootstrap/js/bootstrap.min.js" ></script>
    
</head>
<link rel="stylesheet" href="../admin/src/css/layui.css">
<style>
body{padding: 10px;}
</style>
<body>
<% User name=(User) session.getAttribute("user");%>

 <c:if test="${(info eq  404)}">
 	<script type="text/javascript">
 			alert("请先登录才能评论!");
 	</script>
 </c:if>
 <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <a href="#" class="navbar-brand"><strong>Xurent.cn</strong></a>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="${pageContext.request.contextPath}/index/0">首页</a></li>
                    <li><a href="#">旅游攻略</a></li>
                    <li><a href="${pageContext.request.contextPath}/chat">在线智能问答</a></li>
                </ul>

                <form action="" class="navbar-form navbar-left ">
                    <input type="text"  placeholder="请输入搜索内容" class="form-control"/>
                    <button type="submit" >
                        <span class="glyphicon glyphicon-search"></span>
                    </button>
                </form>
		<% if(name!=null) {%>
                <a  href="${pageContext.request.contextPath}/exit" class="btn navbar-btn btn-primary btn-md navbar-right">退出</a><%} %>
                <div class="navbar-right">
                    <ui class="nav navbar-nav">
                        <li><a href="${pageContext.request.contextPath}/bootstrap/register.jsp">注册</a></li>
                        <%if(name==null){ %>
                        <li><a href="${pageContext.request.contextPath}/bootstrap/login.jsp">登录</a></li><%} %>
                    </ui>
                    <%if(name!=null){ %>
                    <p class="navbar-text">您好,<a class="navbar-link" href="#"><%=name.getName()%></a></p>
					<%} %>
                </div>
               
            </div>
</nav>

<div class="page-header" style="margin-top:150dp">
<ol class="breadcrumb">
  <li class="page" style="display: inline;"><a href="${pageContext.request.contextPath}/see/${(travel.id-1)}" >上一篇</a></li>
  
  <li><a href="${pageContext.request.contextPath}/see/${(travel.id+1)}">下一篇</a></li>
  <li class="active">当前</li> 
</ol>
</div>

	<div class="container">
    <div class="page-header">
        <h1>${travel.title}<small style="margin-left:30px">Xurent for travel</small></h1>
        <span><p>${travel.date}</p></span>
      </div>
    

      <ul class="media-list">
        <li class="media">
          <div class="media-center">
            <a href="#">
              <img class="media-object" style="width:600px;height:500px" src="${travel.img}" alt="...">
            </a>
          </div>
          <div class="media-body">
            <h4 class="media-heading" style="margin-top:20px">地点:${travel.addr}</h4>
            <label style="color:red;display:inline;font-size:60dp;">门票价格: ${travel.money}/元</label>
            <div class="panel panel-primary" style="width: 700px;margin-top:50dp">
               <p style="word-wrap: break-word;word-break: break-all;overflow: hidden;width: 700px">
              &nbsp;&nbsp;&nbsp;&nbsp; ${travel.content}
            </p>
            </div>
                             		
                <span class="badge navbar-right" style="font-size:15px;margin-right: 10px;display: block">浏览次数:${travel.num}</span> 	     
            

          </div>
        </li>
      </ul>

</div>


<div class="container">


<c:forEach var="coment" items="${cots}">
	<div class="well well-sm " style="width: 700dp">
		<td>${coment.name}:${coment.content}</td>
		<td>${coment.date} </td>
	</div>
</c:forEach>


<div style="width: 800px;">
  <form class="layui-form" method="POST">
    <div class="layui-form-item">
      <textarea name="demo" id="demo" class="layui-hide"></textarea>
    </div>
    <button class="layui-btn">提交</button>
    <a class="layui-btn" id="getChoose">获取选中内容</a>
  </form>
</div>

</div>


<script src="../admin/src/layui.js"></script>
<script>
layui.use('layedit', function(){
  var layedit = layui.layedit;
  
  var index = layedit.build('demo', {
    //hideTool: ['image']
    uploadImage: {
      url: 'json/upload/demoLayEdit.json'
      ,type: 'get'
    }
    //,tool: []
    //,height: 100
  });
  
  getChoose.onclick = function(){
    alert(layedit.getSelection(index));
  };
  
});
</script>


</body>
</html>