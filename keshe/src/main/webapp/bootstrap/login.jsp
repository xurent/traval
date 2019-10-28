<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests" /> -->
<title>Xurent-欢迎登录</title>
<script src="${pageContext.request.contextPath}/bootstrap/lib/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/lib/bootstrap/css/bootstrap.min.css">
    <!-- <link rel="stylesheet" href="lib/bootstrap/css/style.css"> -->
    <script  src="${pageContext.request.contextPath}/bootstrap/lib/bootstrap/js/bootstrap.min.js" ></script>
</head>
<body>
<body>
    <div style="height: 80px;" >
        <nav class="navbar navbar-default">
            <div class="navbar-header">
            <a href="${pageContext.request.contextPath}/bootstrap/index">
             <img  style="height:100px" src="${pageContext.request.contextPath}/bootstrap/img/quick.png" alt="图片">  </a>
            </div>
            <div class="navbar navbar-left" style="color:crimson">
                <h1>闲云旅游</h1>
            </div>
            <div class="navbar navbar-text">
                <h2>欢迎登录</h2>
            </div>
        </nav>

    </div>


   <% String note=(String)request.getAttribute("note"); %>
        
        <div class="row">
                <div style="background: url(${pageContext.request.contextPath}/bootstrap/img/banner.jpg);height: calc(100vh - 200px);height: 650px;">
			<div style="border-radius: 2%;height: 520px;width:500px;float: right;background-color: white;margin-right: 23rem;margin-top: 10rem;">
				<div><strong><h3 style="margin-left: 50px;margin-top: 50px;">用户登录</h3></strong></div>
				<div>
					<form action="${pageContext.request.contextPath}/login" method="post">
						<div class="input-group input-group-lg" style="padding-left:50px;padding-right: 50px;padding-bottom: 20px;padding-top: 20px;">
							<span class="input-group-addon glyphicon glyphicon-user" id="Username"></span>
							<input  name="username" type="text" class="form-control" placeholder="用户名" aria-describedby="basic-addon1" />
						</div>
						<div class="input-group input-group-lg" style="padding-left:50px;padding-right: 50px;padding-top: 20px;">
							<span class="input-group-addon" id="password">@</span>
							<input name="password" type="text" class="form-control" placeholder="密码" aria-describedby="basic-addon1" />
						</div>
						<%if(note!=null){ %>
						<strong><h4 style="margin-left: 50px;color: red;height: 25dp"><%=note %></h4></strong>						
						<% }   %>
						<div class="input-group" style="padding-left:50px;padding-right:50px;padding-top:30px;width: 100%;letter-spacing: 20px;">
							<button type="submit" class="btn btn-primary btn-lg btn-block btn-danger">登录</button>
						</div>
						
						
						<div class="input-group" style="padding:10px;float:right;margin-right: 40px;letter-spacing: 1px">
							<a href="${pageContext.request.contextPath}/bootstrap/register.jsp"><label>注册账号</label></a>
							<a style="margin-left: 20px;" href="#"><label>忘记密码</label></a>
						</div>
					</form>
				</div>
				<div style="clear: both;"></div>
				<!--其它方式登录-->
				<div style="height: 140px;display: flex;flex-direction: column;">
					<div style="height: 40px;display: flex;align-items: center;">
						<div style="height: 1px;flex: 1;border: 1px solid rgb(244,244,244);"></div>
						<div style="width: 200px;display: flex;align-items: center;justify-content: center;">
							<div style="color: rgb(180,180,180);"><h4>其它方式登录</h4></div>
						</div>
						<div style="height: 1px;flex: 1;border: 1px solid rgb(244,244,244);"></div>
					</div>
					<div style="height: 100px;display: flex;justify-content: space-around;">
						<div style="display: flex;align-items: center;">
							<a href="#"><img src="${pageContext.request.contextPath}/bootstrap/img/QQ.png" style="width: 50px;height: 50px;" /></a>
						</div>
						<div style="display: flex;align-items: center;">
							<a href="#"><img src="${pageContext.request.contextPath}/bootstrap/img/weixing.png" style="width: 50px;height: 50px;" /></a>
						</div>
						<div style="display: flex;align-items: center;">
							<a href="#"><img src="${pageContext.request.contextPath}/bootstrap/img/weibo.png" style="width: 50px;height: 50px;" /></a>
						</div>
					</div>
				</div>
			</div>
		</div>
            

        
        </div>


<div class="row">

    <div id="footer-2013" style="height: 100px;margin-top: 20px;display: flex;flex-direction: column;align-items: center;justify-content: center;">
        <div class="links" style="display: flex;">
            <a rel="nofollow" target="_blank" href="//www.jd.com/intro/about.aspx" >
                <h4>关于我们</h4>
            </a>
            <div style="display: flex;align-items: center;justify-content: center;margin-right: 20px;margin-left: 20px;"><div>|</div></div>
            <a rel="nofollow" target="_blank" href="//www.jd.com/contact/">
                <h4>联系我们</h4>
            </a>
            <div style="display: flex;align-items: center;justify-content: center;margin-right: 20px;margin-left: 20px;"><div>|</div></div>
            <a rel="nofollow" target="_blank" href="//zhaopin.jd.com/" >
                <h4>人才招聘</h4>
            </a>
            <div style="display: flex;align-items: center;justify-content: center;margin-right: 20px;margin-left: 20px;"><div>|</div></div>
            <a rel="nofollow" target="_blank" href="//www.jd.com/contact/joinin.aspx" >
                <h4>商家入驻</h4>
            </a>
            
        </div>
        <div class="copyright" style="margin-top: 10px;margin-bottom: 50px;">
            Copyright&nbsp;©&nbsp;2004-2018&nbsp;&nbsp;闲云旅游Xurent.com&nbsp;版权所有
        </div>
    </div>


</div>



</div>


</body>
</html>