<%@page import="com.hit.DataControllor.DataManager"%>
<%@page import="com.hit.Entity.Teacher"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title></title>
	<link rel="stylesheet" type="text/css" href="./css/student.css" />
	<script type="text/javascript" src="js/InfoModify.js"></script>
	</head>
<%
		Teacher teacher = (Teacher)(session.getAttribute("USER"));
	%>
<body>
	<span id="welcome"><%=teacher.getID() %> <%=teacher.getName() %>| <a id="title" href="">退出</a></span>
	<div id="header">	
			<a id="logo" href="http://www.hit.edu.cn">
				<img src="./pics/hit.png" alt="" />
			</a>
		<ul id="nav">
			<li><a href="./teacher.jsp" >课程管理</a></li>
			<li><a href="./TeacherqueryTimetable.jsp" >课表查询</a></li>
			<li><a href="./TeachermanageStudent.jsp" >学生管理</a></li>
			<li><a href="./setScores.jsp">成绩评定</a></li>
			
			<li><a href="./TeacherComm.jsp">评教结果</a></li>
			<li><a href="./changePwd.html">修改密码</a></li>
			<li><a href="./TeacherInfo.jsp" class="navActive">个人信息</a></li>
		</ul>
	</div>		
	<div id="content">
		<div id="left">
			<div id="left-top">	
			</div>
			<div id="left-main">
				<h2 id="queryRoom">
					<span>教师信息</span>
				</h2>
				<div id="geren">
					<ul id="prop" style="margin-top:0px;">
					<li style="background: white;text-align: center">
						<span >个人信息</span>
					</li>
					<li>
						<span class="aside-icon"></span>
						<span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</span><%=teacher.getName() %>
					</li>
					<li>
						<span class="aside-icon"></span>
						<span>教师编号：</span><%=teacher.getID() %>
					</li>	
					<li>
						<span class="aside-icon"></span>
						<span>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</span><%=teacher.getSex() %>
					</li>
					<li>
						<span class="aside-icon"></span>
						<span>出生日期：</span><%=teacher.getBirthday() %>
					</li>
					<li>
						<span class="aside-icon"></span>
						<span>身份证号：</span><%=teacher.getPersonID() %>
					</li>
					
					</ul>
				</div>	
				<form action="ModifyInfo" id="query-input" method="get">	
					<div id="phone" style="width: 250px ;margin-top:0px;margin-left: 50px;">
						<div id="part3" style="width:250px">
							<span>联系信息</span>
						</div>
						<div style="float:left">
							<div class="item" style="margin-top:20px;width:145px">
								
								<span>&nbsp;院&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;系：</span><%=DataManager.getDeptNameByID(teacher.getDid()) %><br />
								<span>&nbsp;联系电话：</span>
								<input id="telephone" class="input2" style="width:120px"name="telephone"type="text" value="<%=teacher.getTelephone() %>"/>
								<br />
								<span>&nbsp;电子邮件：</span>
								<input id="email" class="input2" style="width:120px"name="email" type="email" value='<%=teacher.getEmail() %>'/>
								 <input type="submit" class="submit1" style="margin-left:0px;float:left;width:100px;height:30px;"value="更改" />
							</div>
						</div>
						<img id="pic2" style="margin-top:10px;"src="./Tres/1103710321.jpg"></img > 
						<a href="uploadpic.html"><input type="button" class="submit1" style="margin-left:5px;float:left;width:100px;height:30px;"value="上传图片"/></a>

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