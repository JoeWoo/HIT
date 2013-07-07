<%@page import="com.hit.Entity.Student"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title></title>
	<link rel="stylesheet" type="text/css" href="./css/student.css">
	</head>
<%
	Student student = (Student)session.getAttribute("USER");
%>
<body>
	<span id="welcome"><%=student.getID() %> <%=student.getName() %>| <a id="title" href="">退出</a></span>
	<div id="header">	
			<a id="logo" href="http://www.hit.edu.cn">
				<img src="./pics/hit.png" alt="" />
			</a>
		<ul id="nav">
			<li><a href="./chooseCourse.jsp">课程选修</a></li>
			<li><a href="./queryTimetable.jsp" >课表查询</a></li>
			<li><a href="./queryRoom.jsp"  >教室查询</a></li>
			<li><a href="./comment.jsp">学生评教</a></li>
			<li><a href="./queryScores.jsp" >成绩查询</a></li>
			<li><a href="./changePwd.html">修改密码</a></li>
			<li><a href="./info.jsp" class="navActive">学籍信息</a></li>
			<li><a href="http://http://today.hit.edu.cn/">今日哈工大</a></li>
		</ul>
	</div>		
	<div id="content">
		<div id="main">
			<div id="main-top">	
			</div>
			<div id="main-main">
				<h2 id="queryRoom">
					<span>学籍信息</span>
				</h2>
				<div id="geren">
					<ul id="prop">
					<li style="background: white;text-align: center">
						<span >个人信息</span>
					</li>
					<li>
						<span class="aside-icon"></span>
						<span>姓名：<%=student.getName() %></span>
					</li>	
					<li>
						<span class="aside-icon"></span>
						<span>性别：<%=student.getSex() %></span>
					</li>
					<li>
						<span class="aside-icon"></span>
						<span>出生日期：<%=student.getBirthday() %></span>
					</li>
					<li>
						<span class="aside-icon"></span>
						<span>身份证号：<%=student.getPersonID() %></span>
					</li>
					<li>
						<span class="aside-icon"></span>
						<span>政治面貌：</span>
					</li>
					</ul>
				</div>
				<div id="geren">
					<ul id="prop">
						<li style="background: white;text-align: center">
							<span >学籍信息</span>
						</li>	
						<li>
							<span class="aside-icon"></span>
							<span>学号：<%=student.getID() %></span>
						</li>
						<li>
							<span class="aside-icon"></span>
							<span>院系：<%=student.getDid() %></span>
						</li>
						<li>
							<span class="aside-icon"></span>
							<span>专业：<%=student.getMid() %></span>
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
			</div>
				<form action="StudentUpdateInfo" method="post" id="form1" name="form1">	
					<div id="phone">
						<div style="float:left">
						<div id="part3">
							<span>联系信息</span>
						</div>
						<div class="item">
							<span>&nbsp;联系电话：</span>
							<input class="input2" name="telephone"type="text" value="<%=student.getTelephone()%>"/>
							<br />
							<input type="hidden" name="Sid" value="<%=student.getID() %>"/>
							<span>&nbsp;电子邮件：</span>
							<input class="input2" name="email" type="email" value="<%=student.getEmail()%>"/>
					    </div>
					    </div>
					    <img id="pic2" src="./res/1103710321.jpg"></img >
					    <div class="clear"></div>
					    <div>
							<span style="color:#444;">&nbsp;家庭地址：</span>
						</div>	
					<textarea  name="address" id="address" ><%=student.getSaddress() %>
					</textarea>
					<input type="submit" class="submit1" value="更改"/>	
				    </div>		
				</form>
			</div>
		</div>
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