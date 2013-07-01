<%@page import="com.hit.DataControllor.DBControllor"%>
<%@page import="com.hit.DataControllor.DataManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hit.Entity.Administrator"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title></title>
	<link rel="stylesheet" type="text/css" href="./css/student.css">
	<script type="text/javascript" src="js/admin.js"></script>
	<script type="text/javascript" src="js/manageStudent.js"></script>
	</head>
	<%
		if(!DBControllor.isConnected()) DBControllor.connctTo("TeachingDB");
		Administrator administrator = (Administrator)session.getAttribute("USER");
		ArrayList<String> sList = DataManager.getYears();
	%>
<body onload="init_page('<%=administrator.getDid() %>')">
	<span id="welcome"><%=administrator.getID() %> <%=administrator.getName() %> | <a id="title" href="">退出</a></span>
	<div id="header">	
			<a id="logo" href="http://www.hit.edu.cn">
				<img src="./pics/hit.png" alt="" />
			</a>
		<ul id="nav">
			<li><a href="./admin.jsp">课程管理</a></li>
			<li><a href="./setTimetable.jsp">排课</a></li>
			<li><a href="./manageStudent.jsp" class="navActive">学籍管理</a></li>
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
			<div id="left-top"></div>
			<div id="left-main">
				<h2 id="queryRoom">
					<span>学生学籍</span>
				</h2>
					
					<div class="getIn" style="width:600px;">
						<div>
						&nbsp;
						<span class="week">院系：</span>
						<select id="dept-input" name="dept-input" dataType="Require"  msg="未选择院系" onchange="getMajor(0)" >
                        <option value="1">软件学院</option>
                       
						</select>
						&nbsp;
			
						<span class="week">专业：</span>
						<select id="major-input" name="major-input" dataType="Require"  msg="未选择专业"  onchange="getSids()">
                        <option value="nochoose">-未选择-</option>
						</select>
						&nbsp;
					
						<span class="week">年级：</span>
						<select id="year-input" name="major-input" dataType="Require"  msg="未选择学期"  >
                        <%
                        	int cnt = 0;
                        	for(String s:sList){
                        %>
                        <option value="<%=s %>"><%=s+"级" %></option>
                        <%
                        	}
                        %>
						</select>
						&nbsp;
					
						<span class="week">学号：</span>
						<select id="Sid-input" name="major-input" dataType="Require"  msg="未选择学期"  >
                        <option value="nochoose">-未选择-</option>
						</select>
						&nbsp;
					
						<input  name="submit" value="查询"type="button" onclick="queryStudent()">
						</div>
						
					</div>
				
				<div id="biao">
					<table  id="scorestable" style="width:610px;" border="1" cellpadding="0" cellspacing="0">
				        <tbody id="student_table">
				        	<tr bgcolor="#CCCCCC">
					            <td height="28"><div><strong>学号</strong></div></td>
					            <td width="10%"><div><strong>姓名</strong></div></td>
					            <td ><div><strong>性别</strong></div></td>
					             <td ><div><strong>院系</strong></div></td>
					              <td ><div><strong>专业</strong></div></td>
					            <td ><div><strong>班级</strong></div></td>
					            
					            <td><div><strong>电子邮件</strong></div></td>
					            <td><div><strong>操作</strong></div></td>
					        </tr>
				       		
				         
				      </tbody>
				  </table>
				</div>

			</div>
		</div>
		<div id="right" style="margin-left:10px;width:270px">	
			<div id="geren">
					<ul id="prop" style="margin-top:0px">
						<li style="background: white;text-align: center">
							<span >学籍信息</span>
						</li>	
						<li>
							<span class="aside-icon"></span>
							<span>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</span><input id="Sid" class="input2" style="width:120px"name="Sid"type="text" />
						</li>
						<li>
							<span class="aside-icon"></span>
							<span>院&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;系：</span><select id="Did" name="dept-input" dataType="Require"  msg="未选择院系" onchange="getMajor2(0)"></select>
						</li>
						<li>
							<span class="aside-icon"></span>
							<span>专&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业：</span><select id="Mid" name="major-input" dataType="Require"  msg="未选择专业" ></select>
						</li>
						<li>
							<span class="aside-icon"></span>
							<span>录取年份：</span><input id="Syear" class="input2" style="width:120px"name="year"type="text" />
						</li>
						<li>
							<span class="aside-icon"></span>
							<span>自然班号：</span><input id="Sclass" class="input2" style="width:120px"name="classId"type="text" />
						</li>
					</ul>
			</div>
			
			<div id="phone" style="width: 250px">
					<div id="part3" style="width:250px">
						<span>联系信息</span>
					</div>
					<div style="float:left">
						<div class="item" style="margin-top: 10px;width:145px">
							<span>&nbsp;联系电话：</span>
							<input id="Stelephone" class="input2" style="width:120px"name="telephone"type="text" />
							<br />
							<span>&nbsp;电子邮件：</span>
							<input id="Semail" class="input2" style="width:120px"name="email" type="email" />
							<div>
								<span style="color:#444;">&nbsp;家庭地址：</span>
							</div>	
							<textarea  name="address" id="Saddress" style="width:120px;margin-left:0px;" ></textarea>	
						</div>
					</div>
					<img id="pic2" style="margin-top:10px;"src="./res/1103710321.jpg"></img > 
					<input type="submit" class="submit1" style="margin-left:4px;float:left;width:100px;height:30px;"value="上传图片"/>
					<div class="clear"></div>
					   
				    </div>		
			
			<div id="geren">
				<ul id="prop">
				<li style="background: white;text-align: center">
					<span >个人信息</span>
				</li>
				<li>
					<span class="aside-icon"></span>
					<span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</span>
					<input id="Sname" class="input2" style="width:120px"name="Sname"type="text" />
				</li>	
				<li>
					<span class="aside-icon"></span>
					<span>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</span><input id="Ssex" class="input2" style="width:120px"name="Ssex"type="text" />
				</li>
				<li>
					<span class="aside-icon"></span>
					<span>出生日期：</span><input id="Sbirthday" class="input2" style="width:120px"name="Sbirthday"type="text" />
				</li>
				<li>
					<span class="aside-icon"></span>
					<span>身份证号：</span><input id="SpersonID" class="input2" style="width:120px"name="SpersonID"type="text" />
				</li>
				</ul>
			</div>

			<div class="clear"></div>
			<input type="button" class="submit1" style="margin-left:20px; float:left;width:97px;"value="确认修改" onclick="updateStudent()"/>
			<input type="button" class="submit1" style="margin-left:55px;float:left;width:97px;"value="添加" onclick="addStudent()"/>	
					
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