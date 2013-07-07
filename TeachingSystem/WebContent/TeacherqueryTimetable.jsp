<%@page import="com.hit.Entity.Teacher"%>
<%@page import="com.hit.DataControllor.DataManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hit.DataControllor.DBControllor"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title></title>
	<link rel="stylesheet" type="text/css" href="./css/student.css"/>
	<script type="text/javascript" src="js/teacherQueryTimetable.js"></script>
	</head>
<%
		Teacher teacher = (Teacher)(session.getAttribute("USER"));
	%>
<body>
	<span id="welcome"><%=teacher.getID() %> <%=teacher.getName() %> | <a id="title" href="">退出</a></span>
	<div id="header">	
			<a id="logo" href="http://www.hit.edu.cn">
				<img src="./pics/hit.png" alt="" />
			</a>
		<ul id="nav">
			<li><a href="./teacher.jsp" >课程管理</a></li>
			<li><a href="./TeacherqueryTimetable.jsp" class="navActive">课表查询</a></li>
			<li><a href="./TeachermanageStudent.jsp">学生管理</a></li>
			<li><a href="./setScores.html">成绩评定</a></li>
			
			<li><a href="./TeacherComm.jsp">评教结果</a></li>
			<li><a href="./changePwd.html">修改密码</a></li>
			<li><a href="./TeacherInfo.jsp">个人信息</a></li>
		</ul>
	</div>		
	<div id="content">
		<div id="main">
			<div id="main-top">	
			</div>
			<div id="main-main">
				<h2 id="queryRoom">
					<span>课表查询</span>
				</h2>
				<form action="" id="query-input">	
					<div class="getIn" style="width:210px;">
						<div>
						&nbsp;
						<span class="week">学期：</span>
						<select id="term-input" name="major-input" dataType="Require"  msg="未选择专业" >
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
						&nbsp;
						<input  name="submit" value="查询" type="button" onclick="query()"/>
						</div>
						
					</div>

				</form>
				<div id="biao">
					<table  id="timetable"border="1" cellpadding="0" cellspacing="0">
				        <tbody><tr>
				          <td width="51" height="34">&nbsp;</td>
				          <td width="120"><div><strong>周　一</strong></div></td>
				          <td width="120"><div><strong>周　二</strong></div></td>
				          <td width="120"><div><strong>周　三</strong></div></td>
				          <td width="120"><div><strong>周　四</strong></div></td>
				          <td width="120"><div><strong>周　五</strong></div></td>
				          <td width="120"><div><strong>周　六</strong></div></td>
				          <td width="120"><div><strong>周　日</strong></div></td>
				        </tr>
				        <tr>
				          <td height="140"><div><strong>1-2节</strong></div></td>
				          <td id="10">&nbsp;</td>
				          <td id="20">&nbsp;</td>
				          <td id="30">&nbsp;</td>
				          <td id="40">&nbsp;</td>
				          <td id="50">&nbsp;</td>
				          <td id="60">&nbsp;</td>
				          <td id="00">&nbsp;</td>
				        </tr>
				        <tr>
				          <td height="140"><div><strong>3-4节</strong></div></td>
				          <td id="11">&nbsp;</td>
				          <td id="21">&nbsp;</td>
				          <td id="31">&nbsp;</td>
				          <td id="41">&nbsp;</td>
				          <td id="51">&nbsp;</td>
				          <td id="61">&nbsp;</td>
				          <td id="01">&nbsp;</td>
				        </tr>
				        <tr>
				          <td height="140"><div><strong>5-6节</strong></div></td>
				          <td id="12">&nbsp;</td>
				          <td id="22">&nbsp;</td>
				          <td id="32">&nbsp;</td>
				          <td id="42">&nbsp;</td>
				          <td id="52">&nbsp;</td>
				          <td id="62">&nbsp;</td>
				          <td id="02">&nbsp;</td>
				        </tr>
				        <tr>
				          <td height="140"><div><strong>7-8节</strong></div></td>
				          <td id="13">&nbsp;</td>
				          <td id="23">&nbsp;</td>
				          <td id="33">&nbsp;</td>
				          <td id="43">&nbsp;</td>
				          <td id="53">&nbsp;</td>
				          <td id="63">&nbsp;</td>
				          <td id="03">&nbsp;</td>
				        </tr>
				        <tr>
				          <td height="140"><div><strong>9-10节</strong></div></td>
				          <td id="14">&nbsp;</td>
				          <td id="24">&nbsp;</td>
				          <td id="34">&nbsp;</td>
				          <td id="44">&nbsp;</td>
				          <td id="54">&nbsp;</td>
				          <td id="64">&nbsp;</td>
				          <td id="04">&nbsp;</td>
				        </tr>
				      </tbody>
				  </table>
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