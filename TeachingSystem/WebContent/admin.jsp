<%@page import="com.hit.DataControllor.DataManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hit.DataControllor.DBControllor"%>
<%@page import="com.hit.Entity.Administrator"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title></title>
	<link rel="stylesheet" type="text/css" href="./css/student.css">
	<script type="text/javascript" src="js/checkform.js"></script>
	<script type="text/javascript" src="js/admin.js"></script>
	</head>
	<%
		Administrator administrator = (Administrator)session.getAttribute("USER");
	%>
<body onload="init_page('<%=administrator.getDid() %>')">
	<span id="welcome"><%=administrator.getID() %> <%=administrator.getName() %> | <a id="title" href="">退出</a></span>
	<div id="header">	
			<a id="logo" href="http://www.hit.edu.cn">
				<img src="./pics/hit.png" alt="" />
			</a>
		<ul id="nav">
			<li><a href="./admin.jsp" class="navActive">课程管理</a></li>
			<li><a href="./setTimetable.jsp">排课</a></li>
			<li><a href="./manageStudent.jsp">学籍管理</a></li>
			<li><a href="./manageScores.jsp">成绩管理</a></li>
			<li><a href="./manageTeacher.jsp">教师管理</a></li>
			<li><a href="./manageComm.jsp">评教管理</a></li>
			<li><a href="./manageAdmin.jsp">管理员管理</a></li>
			<li><a href="./changeManagePwd.html">修改密码</a></li>
			<li><a href="./manageInfo.jsp">个人信息</a></li>
			
		</ul>
	</div>		
	<div id="content">
		<div id="left">
			<div id="left-top">
				
			</div>
			<div id="left-main">
				<h2 id="queryRoom">
					<span>课程管理</span>
				</h2>
				<form action="" id="query-input">	
					<div class="getIn" style="width:600px;">
						<div>

						&nbsp;
						<span class="week">类型：</span>
						<select id="style-input" name="major-input" dataType="Require"  msg="未选择类型"  >
                        <option value="0">全部课程</option>
                        <option value="1">必修</option>
                        <option value="2">全校任选</option>
                        <option value="3">英语</option>
                        <option value="4">体育</option>
						</select>
						&nbsp;
						<span class="week">院系：</span>
						<select id="dept-input" name="dept-input" dataType="Require"  msg="未选择院系"  onchange="getMajor(0)" >
                        <option value="00">-未选择-</option>
                       
						</select>
						&nbsp;
			
						<span class="week">专业：</span>
						<select id="major-input" name="major-input" dataType="Require"  msg="未选择专业"  >
                        <option value="000">-未选择-</option>
						</select>
						&nbsp;
					
						<span class="week">学期：</span>
						<select id="term-input" name="major-input" dataType="Require"  msg="未选择学期"  >
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
					
						<input  value="查询"type="button" onclick="queryCourse()">
						</div>
						
					</div>

				</form>
				<div id="biao">
					<table  id="scorestable" style="width:610px;" border="1" cellpadding="0" cellspacing="0">
				        <tbody id="course_table">
				        	<tr bgcolor="#CCCCCC">
					            <td height="28"><div><strong>课程号</strong></div></td>
					            <td ><div><strong>课程名</strong></div></td>
					             <td ><div><strong>院系</strong></div></td>
					              <td ><div><strong>专业</strong></div></td>
					            <td ><div><strong>授课教师</strong></div></td>
					            <td><div><strong>类型</strong></div></td>
					            <td><div><strong>学时</strong></div></td>
					            <td><div><strong>学分</strong></div></td>
					            <td><div><strong>备注</strong></div></td>
					            <td><div><strong>操作</strong></div></td>
					        </tr>
					        
				       		<!-- <tr bgcolor="#C8D6FF">
					           
					            <td height="25">08T1370030</td>
					            <td>程序设计语言</td>
					            <td>软件学院</td>
					            <td>软件工程</td>
					            <td>赵岩</td>
					            <td>必修</td>
					            <td>70</td>
					            <td>4</td>
					            <td>考试</td>
					            <td>
					            	<a href="">查看</a>
					            	&nbsp;<a href="">删除</a>
					            	&nbsp;<a href="">排课</a>
					            </td>
				           </tr>
				          -->
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
				<div id="image2">				
						<dl>
							<dd>课程编号：<input id="Cid" class="input2" style="width:120px"name="Sname"type="text" readonly="readonly"/><input id="Tempid" type="hidden" readonly="readonly"/></dd>
							<dd>课程名称：<input id="Cname" class="input2" style="width:120px"name="Sname"type="text" /></dd>
							<dd>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;分： <input id="Ccredit" class="input2" style="width:120px"name="Sname"type="text" /></dd>
							<dd>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时： <input id="Chour" class="input2" style="width:120px"name="Sname"type="text" /></dd>
							
						</dl>	
				</div>
			</div>
			<ul id="prop">
				<li>
					<span class="aside-icon"></span>
					<span>教&nbsp;&nbsp;&nbsp;&nbsp;师：</span>
					<input id="Teacher" class="input2" style="width:120px"name="Sname"type="text" />
				</li>
				<li>
					<span class="aside-icon"></span>
					<span>学&nbsp;&nbsp;&nbsp;&nbsp;期：</span>
					<select id="term-input-right" class="input2" style="width:120px"name="Sname"type="text" >
					    <%
					    	String s = DataManager.getTerm();
					    	for(int i=0; i<2; i++){
					    		
					    	
					    %>
					    <option value="<%=i %>"><%=DataManager.getTermString(s) %></option>
					    <%
					    	s = DataManager.termPluOne(s);	
					    }
					    %>
					</select>
				
				</li>
				<li>
					<span class="aside-icon"></span>
					<span>院&nbsp;&nbsp;&nbsp;&nbsp;系：</span>
					<select id="dept-input-right" class="input2" style="width:120px"name="Sname"type="text" onchange="getMajor(1)" >
						
					</select>
				</li>
				<li>
					<span class="aside-icon"></span>
					<span>专&nbsp;&nbsp;&nbsp;&nbsp;业：</span>
					<select id="major-input-right" class="input2" style="width:120px"name="Sname"type="text" >
					</select>
				</li>
				<li>
					<span class="aside-icon"></span>
					<span>年&nbsp;&nbsp;&nbsp;&nbsp;级：</span>
					<select id="syear-input-right" class="input2" style="width:120px"name="Sname"type="text" >
					 <%
					    	ArrayList<String> sList = DataManager.getSyear();
					    	for(int i=0; i<sList.size() ; i++){
					    		
					    %>
					    <option value="<%=sList.get(i) %>"><%=sList.get(i) %></option>
					    <%
					    }
					    %>
					</select>
				</li>
				<li>
					<span class="aside-icon"></span>
					<span>类&nbsp;&nbsp;&nbsp;&nbsp;型：</span>
					<select id="Ctype" class="input2" style="width:120px"name="Sname"type="text" >
						<option value="1">必修</option>
						<option value="2">全校任选</option>
						<option value="3">英语</option>
						<option value="4">体育</option>
					</select>
				</li>
				<li>
					<span class="aside-icon"></span>
					<span>备&nbsp;&nbsp;&nbsp;&nbsp;注：</span>
					<select id="Cproperty" class="input2" style="width:120px"name="Sname"type="text" >
						<option value="1">考试</option>
						<option value="0">考察</option>
					</select>
				</li>
			</ul>
			
			<div class="clear"></div>
			<input id="confirm" type="button" class="submit1" style="margin-left:0px; float:left;width:97px;"value="确认修改" onclick="updateCourse()"/>
					<input id="add" type="button" class="submit1" style="margin-left:55px;float:left;width:97px;"value="添加" onclick="addCourse()"/>	
					
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