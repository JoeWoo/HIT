<%@page import="com.hit.DataControllor.DBDeliver"%>
<%@page import="com.hit.DataControllor.DBControllor"%>
<%@page import="java.sql.ResultSet"%>
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
	<script type="text/javascript" src="js/chooseBiXiu.js"></script> 
	<script type="text/javascript"> 
  
</script> 
	</head><%
	Student student = (Student)session.getAttribute("USER");
%>
<body>
	<span id="welcome"><%=student.getID() %> <%=student.getName() %> | <a id="title" href="">退出</a></span>
	<div id="header">	
			<a id="logo" href="http://www.hit.edu.cn">
				<img src="./pics/hit.png" alt="" />
			</a>
		<ul id="nav">
			<li><a href="./chooseQuanxiao.jsp" >全校任选</a></li>
			<li><a href="./chooseEnglish.jsp">英语</a></li>
			<li><a href="./chooseTiyu.jsp"  >体育</a></li>
			<li><a href="./chooseBixiu.jsp" class="navActive">必修</a></li>
			<li><a href="./chooseResult.jsp">选课结果</a></li>
			<li><a href="./student.jsp">返回</a></li>
		</ul>
	</div>		
	<div id="content">
		<div id="left">
			<div id="left-top">
				
			</div>
			<div id="left-main">
				<h2 id="queryRoom">
					<span>必修课</span>
				</h2>
				<div id="biao" style="height: 500px;overflow: auto;">
					<table  id="coursetable" style="width:610px;" border="1" cellpadding="0" cellspacing="0">
				        <tbody>
				        	<tr bgcolor="#CCCCCC">
					            <td height="28"><div><strong>选课编号</strong></div></td>
					            <td ><div><strong>课程名</strong></div></td>
					            <td ><div><strong>授课教师</strong></div></td>
					            <td><div><strong>学时</strong></div></td>
					            <td><div><strong>学分</strong></div></td>
					            <td><div><strong>备注</strong></div></td>
					            <td><div><strong>操作</strong></div></td>
					        </tr>
					        
					        <%
					        String sql = String.format("select T1.Tempid,Course.Cid,Cname,Tname,Ctype,Chour,Ccredit,Cproperty " +
									"from (select * from TempCourse where TempCourse.Mid='%s' " +
									"and Term='%s') as T1 inner join Course on T1.Cid=Course.Cid " +
									"inner join Teacher on T1.Tid=Teacher.Tid where Ctype='1' and T1.Syear='%s'",student.getMid(),DataManager.getTerm(),student.getSyear());
					       		System.out.print(sql);
					        	ResultSet rs = DBControllor.excuteQuery(sql);
					       		int cnt = 0;
					       		while(rs.next()){
					        %>
				       		<tr bgcolor="#C8D6FF" id="<%=rs.getString("Tempid")%>">
					            <td height="25"><%=rs.getString("Tempid") %></td>
					            <td><%=rs.getString("Cname") %></td>
					            <td><%=rs.getString("Tname") %></td>
					            
					            <td><%=rs.getString("Chour") %></td>
					            <td><%=rs.getString("Ccredit") %></td>
					            <td><%=rs.getString("Cproperty").equals("1")?"考试":"考察" %></td>
					            <td id="<%=rs.getString("Tempid")%>_button">
					            <%if(!DBDeliver.judgeConfirmBixu(student.getID(), DataManager.getTerm(), rs.getString("Tempid"))){ %>
					            	&nbsp;<a href="javascript:void(0)" onclick="choose('<%=rs.getString("Tempid")%>')">确认</a>
					            	<%}else {%>
					            	已确认
					            	<%} %>
					            </td>
				           </tr> 
				           <%} %> 
				      </tbody>
				  </table>
				</div>
				
				
				
			</div>
		</div>
		<div id="right" style="display:none">
			<div id="ren">
				<div id="ren-top">
					<a href="">返回</a>
					<a href="">课程信息</a>
				</div>
				<div id="image2">				
						<dl>
							<dd>课程编号：<input class="input2" style="width:120px"name="Sname"type="text" /></dd>
							<dd>课程名称：<input class="input2" style="width:120px"name="Sname"type="text" /></dd>
							<dd>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;分： <input class="input2" style="width:120px"name="Sname"type="text" /></dd>
							<dd>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时： <input class="input2" style="width:120px"name="Sname"type="text" /></dd>
							
						</dl>	
				</div>
			</div>
			<ul id="prop">
				<li>
					<span class="aside-icon"></span>
					<span>教&nbsp;&nbsp;&nbsp;&nbsp;师：</span>
					<input class="input2" style="width:120px"name="Sname"type="text" />
				</li>
				<li>
					<span class="aside-icon"></span>
					<span>院&nbsp;&nbsp;&nbsp;&nbsp;系：</span>
					<input class="input2" style="width:120px"name="Sname"type="text" />
				</li>
				<li>
					<span class="aside-icon"></span>
					<span>专&nbsp;&nbsp;&nbsp;&nbsp;业：</span>
					<input class="input2" style="width:120px"name="Sname"type="text" />
				</li>
				<li>
					<span class="aside-icon"></span>
					<span>类&nbsp;&nbsp;&nbsp;&nbsp;型：</span>
					<input class="input2" style="width:120px"name="Sname"type="text" />
				</li>
				<li>
					<span class="aside-icon"></span>
					<span>备&nbsp;&nbsp;&nbsp;&nbsp;注：</span>
					<input class="input2" style="width:120px"name="Sname"type="text" />
				</li>
			</ul>
			
			<div class="clear"></div>
					
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