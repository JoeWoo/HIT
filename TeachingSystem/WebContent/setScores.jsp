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
	<script type="text/javascript">
	 var check=function(myfatherid,id)
        {
        	var container = document.getElementById(myfatherid);
        	var container2 = document.getElementById(id);
        	//alert("dfdfd");
        	if(container2.value=="")
        	{
        		
        		container.style.background="#C8D6FF";	
        	}
        		
        	else
        		container.style.background="#cccccc";
        }
		
	</script>
	<span id="welcome"><%=teacher.getID() %> <%=teacher.getName() %> | <a id="title" href="">退出</a></span>
	<div id="header">	
			<a id="logo" href="http://www.hit.edu.cn">
				<img src="./pics/hit.png" alt="" />
			</a>
		<ul id="nav">
			<li><a href="./teacher.jsp" >课程管理</a></li>
			<li><a href="./TeacherqueryTimetable.jsp" >课表查询</a></li>
			<li><a href="./TeachermanageStudent.jsp" >学生管理</a></li>
			<li><a href="./setScores.jsp"class="navActive">成绩评定</a></li>
			
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
					<span>成绩评定</span>
				</h2>
				<form action="UpdateScores" id="query-input" method="post">	
					<div class="getIn" style="width:450px;">
						<div>
							&nbsp;
						<span class="week">学期：</span>
						<select id="term-input" name="major-input" dataType="Require"  msg="未选择专业" onchange="getTermCourse()" >
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
						<input  name="submit" value="查询"type="button"  onclick="queryStu()"/>
						<input id="save" style="background:yellow;border: 1px solid #C7CACC;
	border-radius: 4px;cursor:pointer;height:25px;width:50px;margin-left:20px;" name="save" value="保存"type="submit"  />
						</div>
						
					</div>

				
				<div id="biao">
					<table  id="scorestable" style="width:800px;" border="1" cellpadding="0" cellspacing="0">
				        <tbody id="student-table">
				        	<tr bgcolor="#CCCCCC">
				        		<td height="28"><div><strong>编号</strong></div></td>
					            <td ><div><strong>学号</strong></div></td>
					            <td ><div><strong>姓名</strong></div></td>
					             <td ><div><strong>院系</strong></div></td>
					              <td ><div><strong>专业</strong></div></td> 
					            <td ><div><strong>成绩</strong></div></td> 
					            
					        </tr>
				       		
				         
				      </tbody>
				  </table>
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