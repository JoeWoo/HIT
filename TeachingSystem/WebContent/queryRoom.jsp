<%@page import="com.hit.Entity.Student"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title></title>
	<link rel="stylesheet" type="text/css" href="./css/student.css"/>
	<script type="text/javascript" src="js/queryRoom.js"></script>
	</head>
<%
	Student student = (Student)session.getAttribute("USER");
%>
<body onload = "initRoomInput(); init();  "  >
	<span id="welcome"><%=student.getID() %> <%=student.getName() %> | <a id="title" href="">退出</a></span>
	<div id="header">	
			<a id="logo" href="http://www.hit.edu.cn">
				<img src="./pics/hit.png" alt="" />
			</a>
		<ul id="nav">
			<li><a href="./chooseCourse.jsp">课程选修</a></li>
			<li><a href="./queryTimetable.jsp">课表查询</a></li>
			<li><a href="./queryRoom.jsp"  class="navActive">教室查询</a></li>
			<li><a href="./comment.jsp">学生评教</a></li>
			<li><a href="./queryScores.jsp">成绩查询</a></li>
			<li><a href="./changePwd.html">修改密码</a></li>
			<li><a href="./info.jsp">学籍信息</a></li>
			<li><a href="http://http://today.hit.edu.cn/">今日哈工大</a></li>
		</ul>
	</div>		
	<div id="content">
		<div id="left">
			<div id="left-top">
				
			</div>
			<div id="left-main">
				<h2 id="queryRoom">
					<span>教室查询</span>
				</h2>
				<form action="" id="query-input">	
					<div class="getIn">
						<div>
						&nbsp;
						<span class="week">周数：</span>
						<select id="week-input" name="week-input" dataType="Require"  msg="未录入周数"  >
                        <option value="1">第1周</option>
                        <option value="2">第2周</option>
                        <option value="3">第3周</option>
                        <option value="4">第4周</option>
                        <option value="5">第5周</option>
                        <option value="6">第6周</option>
                        <option value="7">第7周</option>
                        <option value="8">第8周</option>
                        <option value="9">第9周</option>
                        <option value="10">第10周</option>
                        <option value="11">第11周</option>
                        <option value="12">第12周</option>
                        <option value="13">第13周</option>
                        <option value="14">第14周</option>
                        <option value="15">第15周</option>
                        <option value="16">第16周</option>
                        <option value="17">第17周</option>
                        <option value="18">第18周</option>
                        <option value="19">第19周</option>
                        <option value="20">第20周</option>
                        <option value="21">第21周</option>
						</select>
						&nbsp;
						&nbsp;
						<span class="week">教室：</span>
						<select id="room-input" name="room-input" dataType="Require"  msg="未选择教室"  >
                        <option value="1">正心11</option>
						</select>
						&nbsp;
						&nbsp;
						<input id="submit" name="submit" value="查询" type="button" onclick="queryCourse();"/>
						<input id="data" type="hidden" />
						</div>
						
					</div>

				</form>
				<div id="biao">
					<table  border="1" cellpadding="0" cellspacing="0">
				        <tbody><tr>
				          <td width="51" height="34">&nbsp;</td>
				          <td width="70"><div align="center" class="style10" onclick="queryRoom('12')"><strong>周　一</strong></div></td>
				          <td width="70"><div align="center" class="style10"><strong>周　二</strong></div></td>
				          <td width="70"><div align="center" class="style10"><strong>周　三</strong></div></td>
				          <td width="70"><div align="center" class="style10"><strong>周　四</strong></div></td>
				          <td width="70"><div align="center" class="style10"><strong>周　五</strong></div></td>
				          <td width="70"><div align="center" class="style10"><strong>周　六</strong></div></td>
				          <td width="70"><div align="center" class="style10"><strong>周　日</strong></div></td>
				        </tr>
				        <tr>
				          <td height="40"><div align="center" class="style10"><strong>1-2节</strong></div></td>
				          <td id="10">&nbsp;</td>
				          <td id="20">&nbsp;</td>
				          <td id="30">&nbsp;</td>
				          <td id="40">&nbsp;</td>
				          <td id="50">&nbsp;</td>
				          <td id="60">&nbsp;</td>
				          <td id="00">&nbsp;</td>
				        </tr>
				        <tr>
				          <td height="40"><div align="center" class="style10"><strong>3-4节</strong></div></td>
				          <td id="11">&nbsp;</td>
				          <td id="21">&nbsp;</td>
				          <td id="31">&nbsp;</td>
				          <td id="41">&nbsp;</td>
				          <td id="51">&nbsp;</td>
				          <td id="61">&nbsp;</td>
				          <td id="01">&nbsp;</td>
				        </tr>
				        <tr>
				          <td height="40"><div align="center" class="style10"><strong>5-6节</strong></div></td>
				          <td id="12" >&nbsp;</td>
				          <td id="22">&nbsp;</td>
				          <td id="32">&nbsp;</td>
				          <td id="42">&nbsp;</td>
				          <td id="52">&nbsp;</td>
				          <td id="62">&nbsp;</td>
				          <td id="02">&nbsp;</td>
				        </tr>
				        <tr>
				          <td height="40"><div align="center" class="style10"><strong>7-8节</strong></div></td>
				          <td id="13">&nbsp;</td>
				          <td id="23">&nbsp;</td>
				          <td id="33">&nbsp;</td>
				          <td id="43">&nbsp;</td>
				          <td id="53">&nbsp;</td>
				          <td id="63">&nbsp;</td>
				          <td id="03">&nbsp;</td>
				        </tr>
				        <tr>
				          <td height="40"><div align="center" class="style10"><strong>9-10节</strong></div></td>
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
		<div id="right">
			<div id="ren">
				<div id="ren-top">
					<a href="">返回</a>
					<a href="">课程信息</a>
				</div>
				<div id="image">
					<div id="name">
						<dl>
							<dd>课程名称： <label id="Cname"></label></dd>
							<dd>课程号： <label id="Cid"></label></dd>
							<dd>学分： <label id="Ccredit"></label></dd>
							<dd>课时: <label id="Chour"></label></dd>
						<!--  	<dd>专业： <label>软件工程</label></dd> -->
						</dl>
					</div>
				 	<img id="pic" src="./pics/contents.png"></img>
				</div>
			</div>
			<ul id="prop">
				<li>
					<span class="aside-icon"></span>
					<span id="Tid">教师编号：</span>
				</li>
				<li>
					<span class="aside-icon"></span>
					<span id="Tname">教师姓名：</span>
				</li>
				<li>
					<span class="aside-icon"></span>
					<span id="Ttitle">教师职称：</span>
				</li>
				<li>
					<span class="aside-icon"></span>
					<span id="Ttelephone">教师电话：</span>
				</li>
				<li>
					<span class="aside-icon"></span>
					<span id="Temail">教师邮箱：</span>
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