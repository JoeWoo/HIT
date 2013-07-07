<%@page import="java.util.ArrayList"%>
<%@page import="com.hit.DataControllor.DataManager"%>
<%@page import="com.hit.DataControllor.DBControllor"%>
<%@page import="com.hit.Entity.Administrator"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title></title>
	<link rel="stylesheet" type="text/css" href="./css/student.css" />
	<script type="text/javascript" src="js/admin.js"></script>
	<script type="text/javascript" src="js/manageTeacher.js"></script>
	<script type="text/javascript" src="js/manageComm.js"></script>
</head>

<%
		Administrator administrator = (Administrator)session.getAttribute("USER");
ArrayList<String> sList = DataManager.getYears();
%>
<body onload="init_page('<%=administrator.getDid() %>');init_comm('<%=administrator.getDid() %>')">
	<span id="welcome"><%=administrator.getID() %> <%=administrator.getName() %> | <a id="title" href="">退出</a></span>
	<div id="header">	
			<a id="logo" href="http://www.hit.edu.cn">
				<img src="./pics/hit.png" alt="" />
			</a>
		<ul id="nav">
			<li><a href="./admin.jsp" >课程管理</a></li>
			<li><a href="./setTimetable.jsp">排课</a></li>
			<li><a href="./manageStudent.jsp">学籍管理</a></li>
			<li><a href="./manageScores.jsp">成绩管理</a></li>
			<li><a href="./manageTeacher.jsp">教师管理</a></li>
			<li><a href="./manageComm.jsp"class="navActive">评教管理</a></li>
			<li><a href="./manageAdmin.jsp">管理员管理</a></li>
			<li><a href="./changeManagePwd.html">修改密码</a></li>
			<li><a href="./manageInfo.jsp">个人信息</a></li>
		</ul>
	</div>		
	<div id="content">
		<div id="main">
			<div id="main-top">	
			</div>
			<div id="main-main">
				<h2 id="queryRoom">
					<span>评教管理</span>
				</h2>
				<form action="" id="query-input">	
					<div class="getIn"style="width:500px;">
						<div>
						&nbsp;
						<span class="week">院系：</span>
						<select id="dept-input" name="dept-input" onchange="getTids()">
                        <option value="1">软件学院</option>
                       
						</select>
						&nbsp;
						<span class="week">学期：</span>
						<select id="term-input" name="major-input" >
                        <%
                        	if(!DBControllor.isConnected()) DBControllor.connctTo("TeachingDB");
                        	ArrayList<String> tList = DataManager.getTermList();
                        	for(String s:tList){
                        %>
                        <option value="<%=s %>"><%=DataManager.getTermString(s) %></option>
                        <%
                        	}
                        %>
						</select>
						&nbsp;
			
						<span class="week">教师编号：</span>
						<select id="teacher-input" name="major-input" >
                        <option value="nochoose">-未选择-</option>
						</select>
					
						
						&nbsp;
						&nbsp;
					
						<input  name="submit" value="查询"type="button" onclick="queryComm()"/>
						</div>
						
					</div>

				</form>
				<div id="biao1" >
					<table  id="scorestable"border="1" cellpadding="0" cellspacing="0">
				        <tbody id="comment-table">
				        	
				      </tbody>
				  </table>	
				</div>
				
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