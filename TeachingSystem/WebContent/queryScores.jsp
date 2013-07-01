<%@page import="com.hit.DataControllor.DataManager"%>
<%@page import="com.hit.Entity.Student"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title></title>
	<link rel="stylesheet" type="text/css" href="./css/student.css"/>
	<script type="text/javascript" src="js/queryScores.js"></script>
	</head>
<%
	Student student = (Student)session.getAttribute("USER");
%>
<body onload="init('<%=student.getID() %>');">
	<span id="welcome"><%=student.getID() %> <%=student.getName() %> | <a id="title" href="">退出</a></span>
	<div id="header">	
			<a id="logo" href="http://www.hit.edu.cn">
				<img src="./pics/hit.png" alt="" />
			</a>
		<ul id="nav">
			<li><a href="./chooseCourse.jsp">课程选修</a></li>
			<li><a href="./queryTimetable.jsp" >课表查询</a></li>
			<li><a href="./queryRoom.jsp"  >教室查询</a></li>
			<li><a href="./comment.jsp">学生评教</a></li>
			<li><a href="./queryScores.jsp" class="navActive">成绩查询</a></li>
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
					<span>成绩查询</span>
				</h2>
				<form  action="" id="query-input" >	
					<div class="getIn" style="width:400px">
						<div>
						&nbsp;
						<span class="week"><%=student.getID() %>--<%=student.getName() %></span>
						&nbsp;
						&nbsp;
						<span class="week">学期：</span>
						<select id="term-input" name="class-input" dataType="Require"  msg="未选择学期"  >
                        <option value="all">全部学期</option>
							<%
								String s = student.getSyear()+"02";
								String now = DataManager.getTerm();
								while(s.compareTo(now)<=0){
									String info = String.format("<option value='%s'>%s</option>",s,DataManager.getTermString(s));
									out.print(info);
									s = DataManager.termPluOne(s);
								}
							%>
						</select>
						&nbsp;
						&nbsp;
						<input name="submit" value="查询"type="button" onclick="queryScoreList()"/>
						</div>
						
					</div>

				</form>
				<div id="biao">
					<table  id="scorestable"border="1" cellpadding="0" cellspacing="0">
				        <tbody id="score-input">
				        	<tr bgcolor="#CCCCCC">
					            <td height="28"><div><strong>学期</strong></div></td>
					            <td><div><strong>课程号</strong></div></td>
					            <td width="25%"><div><strong>课程名</strong></div></td>
					            <td width="10%"><div><strong>授课教师</strong></div></td>
					            <td><div><strong>类别</strong></div></td>
					            <td><div><strong>学分</strong></div></td>
					            <td><div><strong>学时</strong></div></td>
					            <td><div><strong>成绩</strong></div></td>
					            <td><div><strong>备注</strong></div></td>
					        </tr>
				       		<tr bgcolor="#C8D6FF">
					            <td height="25">2010秋季</td>
					            <td>08T1370030</td>
					            <td>程序设计语言</td>
					            <td>赵岩</td>
					            <td>必修</td>
					            <td>4.5</td>
					            <td>70</td>
					            <td>88</td>
					            <td></td>
				           </tr>
				           <tr bgcolor="#C8D6FF">
					            <td height="25">2010秋季</td>
					            <td>08T1370030</td>
					            <td>程序设计语言</td>
					            <td>赵岩</td>
					            <td>必修</td>
					            <td>4.5</td>
					            <td>70</td>
					            <td>88</td>
					            <td></td>
				           </tr>
				           <tr><td colspan="10" height="10">&nbsp;</td></tr>
				           <tr bgcolor="#C8D6FF">
					            <td height="25">2010春季</td>
					            <td>08T1370030</td>
					            <td>程序设计语言</td>
					            <td>赵岩</td>
					            <td>必修</td>
					            <td>4.5</td>
					            <td>70</td>
					            <td>88</td>
					            <td></td>
				           </tr>
				           <tr bgcolor="#C8D6FF">
					            <td height="25">2010春季</td>
					            <td>08T1370030</td>
					            <td>程序设计语言</td>
					            <td>赵岩</td>
					            <td>必修</td>
					            <td>4.5</td>
					            <td>70</td>
					            <td>88</td>
					            <td></td>
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