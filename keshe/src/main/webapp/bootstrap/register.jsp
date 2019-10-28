<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests" /> -->
<title>闲云旅游-注册</title>
<script src="${pageContext.request.contextPath}/bootstrap/lib/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/lib/bootstrap/css/bootstrap.min.css">
    <!-- <link rel="stylesheet" href="lib/bootstrap/css/style.css"> -->
    <script  src="${pageContext.request.contextPath}/bootstrap/lib/bootstrap/js/bootstrap.min.js" ></script>
</head>
<body>

<div style="height: 80px;" >
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="navbar-header">
            <a href="${pageContext.request.contextPath}/bootstrap/index">
             <img  style="height:100px" src="${pageContext.request.contextPath}/bootstrap/img/quick.png" alt="图片">  </a>
            </div>
            <div class="navbar navbar-left" style="color:crimson">
                <h1>闲云旅游</h1>
            </div>
            <div class="navbar navbar-text">
                <h2>用户注册</h2>
            </div>

            <div class="container" >
            <div class="navbar navbar-right navbar-text" style="font-size:20px;">
                <p class="navbar-text">已有账号?  <a class="navbar-link"  style="color:brown;" href="${pageContext.request.contextPath}/bootstrap/login.jsp">请登录 ></a></p>
            </div>
            </div>
        </nav>

    </div>


    <div class="container" style="display:block;margin:0 auto;border: 1px;margin-top: 10rem">

        <div  style="display:block;margin:0 auto;border: 1px;width: 500px;">
        
           <form action="${pageContext.request.contextPath}/register" method="post" >
         
            <div class="input-group input-group-lg" style="padding:10px" >
                <input name="username" type="text" class="form-control" placeholder="用户名" />
                <span class="input-group-btn">
                  <button class="btn btn-default" type="button">检查可用</button>
                </span>				
              </div><strong style="display: inline;color: red;">${note}</strong>
              <div class="input-group input-group-lg" style="padding:10px" >
                  
                <span class="input-group-addon" id="password">密码</span>
                <input name="password" type="text" class="form-control" placeholder="不得少于6位" />
              </div>
                <div class="input-group input-group-lg" style="padding:10px" >                 
                        <span class="input-group-addon" id="password">真实姓名</span>
                        <input name="name" type="text" class="form-control" placeholder="必填选项" />
                 </div>
                 <div class="input-group input-group-lg" style="padding:10px" >                 
                    <span class="input-group-addon" id="password">+86</span>
                    <input name="phone" type="text" class="form-control" placeholder="手机号码" />
             </div>
             <div class="input-group input-group-lg" style="padding:10px" >                 
                <span class="input-group-addon" id="password">城市</span>
                <input name="city"  type="text" class="form-control" placeholder="例如:桂林" />
            </div>
            <div class="input-group input-group-lg" style="padding:10px;width: 350px;left: 70px" >                 
                        <span class="input-group-addon" id="password">
                            <img  src="http://guethome.cdvv.top:6019/login/GetValidateCode"   style="width:110px;height:25px;size: 100px" alt="验证码">
                        </span>
                        <input type="text" class="form-control" placeholder="" >
            </div>

            <div class="input-group input-group-lg" style="padding-left:50px;padding-right:50px;padding-top:30px;width: 100%;letter-spacing: 20px;">
                    <button type="submit" class="btn btn-primary btn-lg btn-block btn-danger">注册</button>
            </div>

           </form>

        </div>


    </div>

</body>
</html>