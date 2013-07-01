<%@page import="com.hit.DataControllor.DataManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hit.DataControllor.DBControllor"%>
<%@page import="com.hit.Entity.Teacher"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title></title>
	<link rel="stylesheet" type="text/css" href="./css/student.css" />
	<script type="text/javascript" src="js/teacherManageStudent.js"></script>
	
	</head>
<%
		Teacher teacher = (Teacher)(session.getAttribute("USER"));
	%>
<body onload="init_page('<%=teacher.getID() %>');getTermCourse();">
	<span id="welcome"><%=teacher.getID() %> <%=teacher.getName() %> | <a id="title" href="">退出</a></span>
	<div id="header">	
			<a id="logo" href="http://www.hit.edu.cn">
				<img src="./pics/hit.png" alt="" />
			</a>
		<ul id="nav">
			<li><a href="./teacher.jsp" >课程管理</a></li>
			<li><a href="./TeacherqueryTimetable.jsp" >课表查询</a></li>
			<li><a href="./TeachermanageStudent.jsp" >学生管理</a></li>
			<li><a href="./setScores.jsp">成绩评定</a></li>
			
			<li><a href="./TeacherComm.jsp"class="navActive">评教结果</a></li>
			<li><a href="./changePwd.html">修改密码</a></li>
			<li><a href="./TeacherInfo.jsp">个人信息</a></li>
		</ul>
	</div>		
	<div id="content">
		<div id="left">
			<div id="left-top">	
			</div>
			<div id="left-main">
				<h2 id="queryRoom">
					<span>评价结果</span>
				</h2>
				<form action="" id="query-input">	
					<div class="getIn" style="width:380px;">
						<div>
							&nbsp;
						<span class="week">学期：</span>
						<select id="term-input" name="major-input" dataType="Require"  msg="未选择专业" onchange="getTermCourse()">
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
						<span class="week">课程：</span>
						<select id="course-input" style="width:120px;"name="major-input" dataType="Require"  msg="未选择专业" >
                        
						</select>
						&nbsp;
						&nbsp;
						<input id="submit" name="submit" value="查询"type="button" onclick="queryComment()"/>
					
						</div>
						
					</div>

				</form>
				<div id="biao">
					<table  id="scorestable" style="width:590px;" border="1" cellpadding="0" cellspacing="0">
				        <tbody>
				        	<tr bgcolor="#CCCCCC">
				        		<td height="28"><div><strong>编号</strong></div></td>
					            <td ><div><strong>评价项目</strong></div></td>
					            <td width="20%"><div><strong>成绩</strong></div></td>   
					        </tr>
				       		<tr  bgcolor="#C8D6FF">
					            <td height="25">1</td>
					            <td>有明确的教学目标与计划，教学进度安排得当</td>
					            <td>---</td>
				           </tr>
				           <tr  bgcolor="#C8D6FF">
					            <td height="25">2</td>
					            <td>授课内容深浅度适当，学生能获得大量有价值的课程信息</td>
					            <td>---</td>
				           </tr>
				           <tr  bgcolor="#C8D6FF">
					            <td height="25">3</td>
					            <td>教学内容熟练，脱稿讲授</td>
					            <td>---</td>
				           </tr>
				           <tr  bgcolor="#C8D6FF">
					            <td height="25">4</td>
					            <td>讲课思路清晰，重点突出，难点处理得当</td>
					            <td>---</td>
				           </tr>
				           <tr  bgcolor="#C8D6FF">
					            <td height="25">5</td>
					            <td>讲课具有启发性，能引导学生独立分析和思考</td>
					            <td>---</td>
				           </tr>
				           <tr  bgcolor="#C8D6FF">
					            <td height="25">6</td>
					            <td>讲课理论联系实际，能调动学生听课的积极性，引发学生对课程的兴趣</td>
					            <td>---</td>
				           </tr>
				           <tr  bgcolor="#C8D6FF">
					            <td height="25">7</td>
					            <td>注意精讲，适当练习，布置大作业（课程论文），并及时认真批改</td>
					            <td>---</td>
				           </tr>
				           <tr  bgcolor="#C8D6FF">
					            <td height="25">8</td>
					            <td>大作业（课程论文）联系实际，有利于课程内容的学习</td>
					            <td>---</td>
				           </tr>
				           <tr  bgcolor="#C8D6FF">
					            <td height="25">9</td>
					            <td>认真组织教学，严格要求学生</td>
					            <td>---</td>
				           </tr>
				           <tr  bgcolor="#C8D6FF">
					            <td height="25">10</td>
					            <td>通过该课学习，学生能掌握本课程的知识并获得相应的能力提高</td>
					            <td>---</td>
				           </tr> 
				           <tr  bgcolor="yellow">
					            <td height="25">10</td>
					            <td>综合</td>
					            <td>---</td>
				           </tr>     
				      </tbody>
				  </table>
				</div>
			</div>
		</div>
		<div id="right" style="height:500px">
			<div id="teacher-comms">
				<div id="part3" style="width:250px">
							<span>学生建议</span>
				</div>
				
				<ul name="comms" id="comms">
				</ul>
				
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