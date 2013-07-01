<%@page import="com.hit.Entity.Student"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title></title>
	<link rel="stylesheet" type="text/css" href="./css/student.css"/>
	<script type="text/javascript"> 
  var Marquee = function(id){  
    try{document.execCommand("BackgroundImageCache", false, true);}catch(e){};  
    var container = document.getElementById(id),  
    slide = container.getElementsByTagName("li")[0],  
    speed = arguments[1] || 50,  //速度  
    delta = 0,//当前滚动的位置  
    critical = slide.offsetHeight;//临界点  
    slide.innerHTML  = slide.innerHTML;  
    var rolling = function(){  
      delta == -critical ? delta = 0 : delta--;  
      slide.style.top = delta +"px";  
    }  
    var timer = setInterval(rolling,speed)//设置定时器  
    container.onmouseover=function() {clearInterval(timer)}//鼠标移到marquee上时，清除定时器，停止滚动  
    container.onmouseout=function() {timer=setInterval(rolling,speed)}//鼠标移开时重设定时器  
  }  
  window.onload = function(){  
    Marquee("marquee");
    Marquee("marquee2");  
  }  
</script> 
</head>
<%
	Student student = (Student)session.getAttribute("USER");
%>
<body>
	<span id="welcome"><%=student.getID() %> <%=student.getName() %> | <a id="title" href="">退出</a></span>
	<div id="header">	
			<a id="logo" href="http://www.hit.edu.cn">
				<img src="./pics/hit.png" alt="" />
			</a>
		<ul id="nav">
			<li><a href="./chooseCourse.jsp">课程选修</a></li>
			<li><a href="./queryTimetable.jsp">课表查询</a></li>
			<li><a href="./queryRoom.jsp">教室查询</a></li>
			<li><a href="./comment.jsp">学生评教</a></li>
			<li><a href="./queryScores.jsp">成绩查询</a></li>
			<li><a href="./changePwd.html">修改密码</a></li>
			<li><a href="./info.jsp">学籍信息</a></li>
			<li><a href="http://http://today.hit.edu.cn/">今日哈工大</a></li>
		</ul>
	</div>		
	<div id="content">
		<div id="left">
			<div id="head"><a href="#" id="face"></a></div>
			<div id="message">
				<div class="arrow"></div>
				<div id="top"></div>
				<div id="text">
					<span id="tongzhi">最新通知</span>
					<ul id="marquee"> 
					  <li> 
					  	<br />
					  	<br />
					    <a href="#">各位同学：系统“学生建议管理”模块中新增了“教师回复”功能。教师对学生所提出的意见和建议可以回复。师生对话中，教师信息对学生可见，学生对教师匿名。欢迎广大师生使用，并提出宝贵意见。 [2012-6-20] </a><br /> 
					    <a href="#">各位同学： 2012春季学生评教活动已于2012年4月9日正式启动了。除毕业班的学生以外，现在点击“学生评教”菜单即可对已经开课2周的教师进行评价了。评教系统如果在使用过程中出现一些问题，可通过“信息反馈交流”功能把问题和建议反馈给我们。评教系统关闭时间为2012年7月6日。 本科生院 [2012-4-10] </a><br /> 
					  </li> 
					</ul>
				</div>
				<div id="bottom"></div>
		    </div>
		    <div class="clear"></div>
		    <br />
		    <div id="head"><a href="#" id="face2"></a></div>
			<div id="message">
				<div class="arrow"></div>
				<div id="top"></div>
				<div id="text">
					<span id="tongzhi">调课通知</span>
					<ul id="marquee2"> 
					  <li> 
					  	<br />
					  	<br />
					    <a href="#">各位同学：系统“学生建议管理”模块中新增了“教师回复”功能。教师对学生所贵意见。 [2012-6-20] </a><br /> 
					    <a href="#">各位同学： 2012春季学生评教活动已于2012年4月9日正式启动了。除毕进行评价了。问题和建议反馈给我们。评教系统关闭时间为2012年7月6日。 本科生院 [2012-4-10] </a><br /> 
					  </li> 
					</ul>
				</div>
				<div id="bottom"></div>
		    </div>
		</div>
		<div id="right">
			<div id="ren">
				<div id="ren-top">
					<a href="">退出</a>
					<a href="">个人信息</a>
				</div>
				<div id="image">
					<div id="name">
						<dl>
							<dd>姓名： <label><%=student.getName() %></label></dd>
							<dd>学号： <label><%=student.getID() %></label></dd>
							<dd>性别： <label><%=student.getSex() %></label></dd>
							<dd>院系： <label><%=student.getDid() %></label></dd>
							<dd>专业： <label><%=student.getMid() %></label></dd>
						</dl>
					</div>
				 	<img id="pic" src="./res/1103710321.jpg"></img>
				</div>
			</div>
			<ul id="prop">
				<li>
					<span class="aside-icon"></span>
					<span>身份证号：<%=student.getPersonID() %></span>
				</li>
				<li>
					<span class="aside-icon"></span>
					<span>出生日期：<%=student.getBirthday() %></span>
				</li>
				<li>
					<span class="aside-icon"></span>
					<span>录取年份：<%=student.getSyear() %></span>
				</li>
				<li>
					<span class="aside-icon"></span>
					<span>自然班号：<%=student.getSclass() %></span>
				</li>
			</ul>
			<ul id="info">
				<li>
					<span id="add-icon"></span>
					<span>家庭地址：<%=student.getSaddress() %></span>
					
				</li>
				<li>
					<span id="phone-icon"></span>
					<span>联系电话：<%=student.getTelephone() %></span>
					
				</li>
				<li>
					<span id="email-icon"></span>
					<span>电子邮件：<%=student.getEmail() %></span>
					
				</li>
			</ul>
			
			
		</div>
	</div>
	<div id="footer">
			<a href="#">关亍W3CStudy</a> | <a href="#">广告服务</a> | <a href="#">提交问题</a> | <a href="#">联系我们</a> | <a href="#">版权声明</a> | <a href="#">关于隐私</a> | <a href="#">合作伙伴</a>
		<br/>
			<a href="#">京ICP备10055601号</a>
			All rights(C)2008-2010 Reserved
	</div>

</body>
</html>