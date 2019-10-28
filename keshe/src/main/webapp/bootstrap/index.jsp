<%@page import="com.xurent.keshe.model.User"%>
<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
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
<body>
<% User name=(User) session.getAttribute("user");%>

 <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <a href="#" class="navbar-brand"><strong>Xurent.cn</strong></a>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="${pageContext.request.contextPath}/index/0">首页</a></li>
                    <li><a href="javascript:Alert()">旅游攻略</a></li>
                    <li><a href="${pageContext.request.contextPath}/chat">在线智能问答</a></li>
                </ul>

                <form action="" class="navbar-form navbar-left ">
                    <input type="text"  placeholder="请输入搜索内容" class="form-control"/>
                    <button type="submit" >
                        <span class="glyphicon glyphicon-search"></span>
                    </button>
                </form>
<% if(name!=null) {%>
                <a  href="${pageContext.request.contextPath}/exit" class="btn navbar-btn btn-primary btn-md navbar-right">退出</a> <% }%>
                <div class="navbar-right">
                    <ui class="nav navbar-nav">
                        <li><a href="${pageContext.request.contextPath}/bootstrap/register.jsp">注册</a></li>
                        <%if(name==null){ %>
                        <li><a href="${pageContext.request.contextPath}/bootstrap/login.jsp">登录</a></li><%} %>
                    </ui>
                    <%if(name!=null){ %>
                    <p class="navbar-text">您好,<a class="navbar-link" href="#"><%=name.getName() %></a></p>
					<%} %>
                </div>
               
            </div>
</nav>


	<div class="container">


            <div id="轮播图的ID" class="carousel slide" data-ride="carousel">
                    <!-- ol标签是图片轮播的控制点 -->
                    <ol class="carousel-indicators">
                      <!-- 
                        每一个li就是一个单独的控制点
                          data-target属性就是指定当前控制点控制的是哪一个轮播图，其目的是如果界面上有多个轮播图，便于区分到底控制哪一个
                          data-slide-to属性是指当前的li元素绑定的是第几个轮播项
                        注意，默认必须给其中某个li加上active，展示的时候就是焦点项目
                      -->
                      <li data-target="#轮播图的ID" data-slide-to="0" class="active"></li>
                      <li data-target="#轮播图的ID" data-slide-to="1"></li>
                      <li data-target="#轮播图的ID" data-slide-to="2"></li>
                      <!-- ...更多的 -->
                    </ol>
                    <!-- 
                      .carousel-inner是所有轮播项的容器盒子，
                      注意role="listbox"代表当前div是一个列表盒子，作用就是给当前div添加一个语义
                    -->
                    <div class="carousel-inner" role="listbox">
                      <!-- 每一个.item就是单个轮播项目，注意默认要给第一个轮播项目加上active，表示为焦点 -->
                      <div class="item active">
                        <!-- 轮播项目中展示的图片 -->
                        <img  src="https://static.visitabudhabi.cn/visitabudhabi/DataFolder/Images/Thumbnails/2000x800/family-attractions-hero.jpg" alt="示例图片" style="height:350px;width: 100%">
                        <div class="carousel-caption">
                          <!-- 标题或说明性文字，如果不需要，直接删除当前div.carousel-caption -->
                        </div>
                      </div>
                      <div class="item" style="height:350px">
                            <img  src="https://b2-q.mafengwo.net/s12/M00/32/1F/wKgED1wGf6SACdaTAAnR17uTfAQ31.jpeg?imageMogr2%2Finterlace%2F1" alt="示例图片">
                            <div class="carousel-caption">
                              <!-- 标题或说明性文字，如果不需要，直接删除当前div.carousel-caption -->
                            </div>
                      </div>
                      <div class="item" style="height:350px">
                        <img  src="https://p3-q.mafengwo.net/s12/M00/02/4B/wKgED1wDeC6AX9oSACdTjXRIG-A60.jpeg?imageMogr2%2Fthumbnail%2F1360x%2Fstrip%2Fquality%2F90" alt="示例图片">
                        <div class="carousel-caption">
                          <!-- 标题或说明性文字，如果不需要，直接删除当前div.carousel-caption -->
                        </div>
                  </div>
                      <!-- ... -->
                    </div>
                    <!-- 图片轮播上左右两个控制按钮，分别点击可以滚动到上一张和下一张 -->
                    <!-- 此处需要注意的是 该a链接的href属性必须指向需要控制的轮播图ID -->
                    <!-- 另外a链接中的data-slide="prev"代表点击该链接会滚到上一张，如果设置为next的话则相反 -->
                    <a class="left carousel-control" href="#轮播图的ID" role="button" data-slide="prev">
                      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                      <span class="sr-only">上一张</span>
                    </a>
                    <a class="right carousel-control" href="#轮播图的ID" role="button" data-slide="next">
                      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                      <span class="sr-only">下一张</span>
                    </a>
                  </div>



            <!-- <div class="jumbotron" >
                <IMG src="img/quick.png">
                    <h1>旅游推荐与智能问答系统</h1>
                    <p>桂林象鼻山....</p>
                </IMG>
                    
            </div> -->


        <div class="row">
            <div class="col-sm-6 col-md--4 col-lg-2 col-xs-2">
                <h1>网站简介</h1>
                <div class="alert alert-info" style="height:750px">
                <h4 style="text-align: center">旅游推荐与智能问答系统</h2>
                  <p style="color:black">
                  该系统可以通过用户上传旅游景点等分享到该平台，并且通过数据分析，用户点击量等推荐出热门的旅游以及最受欢迎的景点。除此之外我们还赋予
                  了该网站强大的智能问答系统，用户可以通过该系统得到相关旅游方面的咨询。该网站由xurent-何旭荣初次完成，不足之处请大家指点，后面有时间
       	我也会慢慢完善，请继续关注我，嘻嘻!           
                    <br>
                  <span class="label label-default">旅游</span>
                  <span class="label label-primary">最热门景点</span>
                  <span class="label label-success">智能在线回答</span>
                  <span class="label label-info">轻松快乐</span>
                  <span class="label label-warning">旅行推荐</span>
                  <span class="label label-danger">一场自我之旅</span>
                  <span class="label label-default">Xurent</span>
                  <span class="label label-primary">Primary</span>
                  <span class="label label-success">Success</span>
                  <span class="label label-info">Info</span>
                  <span class="label label-warning">Warning</span>
                  <span class="label label-danger">Danger</span>
                  </p>
                </div>
               
            </div>
            <div class="col-sm-6 col-md-8 col-lg-10 col-xs-2">
                <h1>景点</h1>
                <p class="alert ">Dark light,just light each other.The responsibility that you and my shoulders take together,the such as one dust covers up.Afraid only afraid the light is suddenly put out in theendless dark night and Countless loneliness</p>
                </div>

                <div class="row">
                        <div class="col-sm-6 col-md-4">
               <c:if test="${!(travels[0] eq  null)}">
                          <div class="thumbnail">
                            <img src="${travels[0].img}" alt="加载图片失败">
                            <div class="caption">
                              <h3>${travels[0].title}</h3>
                             <div class="row">
                             <ul class="list-group">
  							<li class="list-group-item">
    						<span class="badge">${travels[0].num}</span>
   							 地点:${travels[0].addr}
 				 			</li>
							</ul>
                              <p class="col-md-8" style="color: red;display: inline;font-size: 25px">门票:${travels[0].money}/元</p>
                              <p class="col-md-4"><a href="${pageContext.request.contextPath}/see/${travels[0].id}" class="btn btn-primary" role="button" style="width: 75px">查看</a> </p>
                              <label style="margin-left:30px;color:#808080">${travels[0].date}</label>
                             </div>
                            </div>
                          </div>
    </c:if>                      
<c:if test="${!(travels[1] eq  null)}">
                          <div class="thumbnail">
                                <img src="${travels[1].img}" alt="加载图片失败">
                                <div class="caption">
                                  <h3>${travels[1].title}</h3>
                                   <div class="row">
                             <ul class="list-group">
  							<li class="list-group-item">
    						<span class="badge">${travels[1].num}</span>
   							 地点:${travels[1].addr}
 				 			</li>
							</ul>
                              <p class="col-md-8" style="color: red;display: inline;font-size: 25px">门票:${travels[1].money}/元</p>
                              <p class="col-md-4"><a href="${pageContext.request.contextPath}/see/${travels[1].id}" class="btn btn-primary" role="button" style="width: 75px">查看</a> </p>
                              <label style="margin-left:30px;color:#808080">${travels[1].date}</label>
                             </div>
                                </div>
                              </div>
</c:if>
                        </div>

				
                        <div class="col-sm-push-1 col-md-4">
      <c:if test="${!(travels[2] eq  null)}">
                                <div class="thumbnail">
                                  <img src="${travels[2].img}" alt="加载图片失败">
                                  <div class="caption">
                                    <h3>${travels[2].title}</h3>
                                    <div class="row">
                             <ul class="list-group">
  							<li class="list-group-item">
    						<span class="badge">${travels[2].num}</span>
   							 地点:${travels[2].addr}
 				 			</li>
							</ul>
                              <p class="col-md-8" style="color: red;display: inline;font-size: 25px">门票:${travels[2].money}/元</p>
                              <p class="col-md-4"><a href="${pageContext.request.contextPath}/see/${travels[2].id}" class="btn btn-primary" role="button" style="width: 75px">查看</a> </p>
                              <label style="margin-left:30px;color:#808080">${travels[2].date}</label>
                             </div>
                                  </div>
                                </div>
                        </c:if>
      <c:if test="${!(travels[3] eq  null)}">
                                <div class="thumbnail">
                                      <img src="${travels[3].img}" alt="加载图片失败">
                                      <div class="caption">
                                        <h3>${travels[3].title}</h3>
                                         <div class="row">
                             <ul class="list-group">
  							<li class="list-group-item">
    						<span class="badge">${travels[3].num}</span>
   							 地点:${travels[3].addr}
 				 			</li>
							</ul>
                              <p class="col-md-8" style="color: red;display: inline;font-size: 25px">门票:${travels[3].money}/元</p>
                              <p class="col-md-4"><a href="${pageContext.request.contextPath}/see/${travels[3].id}" class="btn btn-primary" role="button" style="width: 75px">查看</a> </p>
                              <label style="margin-left:30px;color:#808080">${travels[3].date}</label>
                             </div>
                                      </div>
                                    </div>
      </c:if>
                              </div>

			
			<c:if test="${travels[1] eq  null}" >
			 		<div class="col-md-6"  style="margin-top: 200px;left: 180px;color: aqua;">
			 		
			 			<h2>没有 更多的旅游景点了...</h2>
			 		</div>
			 		
				</c:if> 
			
                      </div> 
                      
                
                            

            </div>

        </div>
     	


    <nav aria-label="Page navigation" class="navbar navbar-static-bottom" style="left:300px">
            <div class="container navbar-right">
            <ul class="pagination">
              <li>
                <a href="#" aria-label="Previous">
                  <span aria-hidden="true">&laquo;</span>
                </a>
              </li>
              <li><a id="index0" href="${pageContext.request.contextPath}/index/1">1</a></li>
              <li><a href="${pageContext.request.contextPath}/index/2">2</a></li>
              <li><a href="${pageContext.request.contextPath}/index/3">3</a></li>
              <li><a href="${pageContext.request.contextPath}/index/4">4</a></li>
              <li><a href="${pageContext.request.contextPath}/index/5">5</a></li>
              <li>
                <a href="#" aria-label="Next">
                  <span aria-hidden="true">&raquo;</span>
                </a>
              </li>
            </ul>
            </div>
          </nav>

</body>

<script type="text/javascript">
 function Alert(){
	 
	 alert("时间有限,还没做好!");
 }

</script>

</html>