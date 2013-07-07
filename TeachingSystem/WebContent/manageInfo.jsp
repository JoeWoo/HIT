<%@page import="com.hit.Entity.Administrator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title></title>
	<link rel="stylesheet" type="text/css" href="./css/student.css">
</head>
<%
	Administrator admin = (Administrator)session.getAttribute("USER");
%>
<body>
	<span id="welcome"><%=admin.getID() %> <%=admin.getName() %>| <a id="title" href="">退出</a></span>
	<div id="header">	
			<a id="logo" href="http://www.hit.edu.cn">
				<img src="./pics/hit.png" alt="" />
			</a>
		<ul id="nav">
			<li><a href="./admin.jsp">课程管理</a></li>
			<li><a href="./setTimetable.jsp">排课</a></li>
			<li><a href="./manageStudent.jsp" >学籍管理</a></li>
			<li><a href="./manageScores.jsp">成绩管理</a></li>
			<li><a href="./manageTeacher.jsp">教师管理</a></li>
			<li><a href="./manageComm.jsp">评教管理</a></li>
			<li><a href="./manageAdmin.jsp" >管理员管理</a></li>
			<li><a href="./changeManagePwd.html">修改密码</a></li>
			<li><a href="./manageInfo.jsp"class="navActive">个人信息</a></li>
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
					<ul id="prop" style="margin-top:0px;">
					<li style="background: white;text-align: center">
						<span >个人信息</span>
					</li>
					<li>
						<span class="aside-icon"></span>
						<span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<%=admin.getName() %></span>
					</li>	
					<li>
						<span class="aside-icon"></span>
						<span>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：<%=admin.getSex() %></span>
					</li>
					<li>
						<span class="aside-icon"></span>
						<span>出生日期：<%=admin.getBirthday().split(" ")[0] %></span>
					</li>
					<li>
						<span class="aside-icon"></span>
						<span>身份证号：<%=admin.getPersonID() %></span>
					</li>
					<li>
						<span class="aside-icon"></span>
						<span>账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：<%=admin.getID() %></span>
					</li>
					</ul>
				</div>	
				<form action="AdminUpdateInfo"  id="form1" name="form1" method="post">	
					<div id="phone" style="width: 250px ;margin-top:0px;">
						<div id="part3" style="width:250px">
							<span>联系信息</span>
						</div>
						<div style="float:left">
							<div class="item" style="margin-top:20px;width:145px">
								
								<span>&nbsp;院&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;系：<%=admin.getDid()%></span><br />
								<span>&nbsp;联系电话：</span>
								<input class="input2" style="width:120px"name="telephone"type="text" value="<%=admin.getTelephone() %>"/>
								<br />
								<input type="hidden" name="Aid" id="Aid" value="<%=admin.getID() %>"/>
								<span>&nbsp;电子邮件：</span>
								<input class="input2" style="width:120px"name="email" type="email" value="<%=admin.getEmail() %>"/>
								 <input type="submit" class="submit1" style="margin-left:0px;float:left;width:100px;height:30px;"value="更改"/>
							</div>
						</div>
						<img id="pic2" style="margin-top:10px;"src="./res/1103710321.jpg"></img > 
						<input type="button" class="submit1" style="margin-left:5px;float:left;width:100px;height:30px;"value="上传图片"/>

						<div class="clear"></div>
					  
					</div>		
				</form>
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