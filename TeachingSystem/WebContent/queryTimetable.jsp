<%@page import="com.hit.Entity.Student"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title></title>
	<link rel="stylesheet" type="text/css" href="./css/student.css"/>
	<script type="text/javascript" src="js/queryTimetable.js" charset="utf-8"></script>
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
			<li><a href="./queryTimetable.jsp" class="navActive">课表查询</a></li>
			<li><a href="./queryRoom.jsp"  >教室查询</a></li>
			<li><a href="./comment.jsp">学生评教</a></li>
			<li><a href="./queryScores.jsp">成绩查询</a></li>
			<li><a href="./changePwd.html">修改密码</a></li>
			<li><a href="./info.jsp">学籍信息</a></li>
			<li><a href="http://http://today.hit.edu.cn/">今日哈工大</a></li>
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
					<div class="getIn">
						<div>
						&nbsp;
						<span class="week" >专业：</span>
						<select id="major-input" name="major-input" dataType="Require"  msg="未选择专业" >
                        <option value="1">软件工程</option>
						</select>
						&nbsp;
						&nbsp;
						<span class="week" >班级：</span>
						<select id="class-input" name="class-input" dataType="Require"  msg="未选择教室"  >
                        <option value="1037103">1037103</option>
						</select>
						&nbsp;
						&nbsp;
						<input id="submit" name="submit" value="查询"type="button" onclick="query()"/>
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