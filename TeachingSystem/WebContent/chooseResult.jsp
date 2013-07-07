<%@page import="com.hit.DataControllor.DataManager"%>
<%@page import="com.hit.DataControllor.DBControllor"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.hit.Entity.Student"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title></title>
	<link rel="stylesheet" type="text/css" href="./css/student.css">
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
			<li><a href="./chooseBixiu.jsp" >必修</a></li>
			<li><a href="./chooseResult.jsp" class="navActive">选课结果</a></li>
			<li><a href="./student.jsp">返回</a></li>
		</ul>
	</div>		
	<div id="content">
		<div id="main">
			<div id="main-top">
				
			</div>
			<div id="main-main">
				<h2 id="queryRoom">
					<span>选课结果</span>
				</h2>
				<form action="" id="query-input">	
<!-- 					<div class="getIn"> -->
<!-- 						<div> -->
<!-- 						&nbsp; -->
<!-- 						<span class="week">学期：</span> -->
<!-- 						<select id="class-input" name="class-input" dataType="Require"  msg="未选择学期"  > -->
<!--                         <option value="201001">201001</option> -->
<!--                         <option value="201002">201001</option> -->
<!--                         <option value="201101">201001</option> -->
<!--                         <option value="201102">201001</option> -->
<!-- 						</select> -->
<!-- 						&nbsp; -->
<!-- 						&nbsp; -->
<!-- 						<input id="submit" name="submit" value="查询"type="submit"/> -->
<!-- 						</div> -->
						
<!-- 					</div> -->

				</form>
				<h3 style="text-align: center;height:5px;color: #444">必修课选课结果</h3>
				<div id="biao" style="overflow: auto;">
					<table  id="scorestable1" style="width:810px;" border="1" cellpadding="0" cellspacing="0">
				        <tbody>
				        	<tr bgcolor="#CCCCCC">
					            <td height="28"><div><strong>课程号</strong></div></td>
					            <td ><div><strong>课程名</strong></div></td>
					            <td ><div><strong>授课教师</strong></div></td>
					            <td><div><strong>学时</strong></div></td>
					            <td><div><strong>学分</strong></div></td>
<!-- 					            <td><div><strong>起止周</strong></div></td> -->
					            <td><div><strong>上课时间与教室</strong></div></td>
					             <td><div><strong>备注</strong></div></td>
					        </tr>
					        <%
					        	String sql = "select distinct Course.Cid,Cname,Tname,Chour,Ccredit,SC.Tempid from SC inner join TempCourse on SC.Tempid=TempCourse.Tempid"+
					        	" inner join Course on Course.Cid=TempCourse.Cid inner join Teacher on Teacher.Tid="
					        	+"TempCourse.Tid";
					        	sql+=String.format(" where SC.Sid='%s' and TempCourse.Term='%s' and Ctype='1'", student.getID(),
					        			DataManager.getTerm());
					        	ResultSet rs = DBControllor.excuteQuery(sql);
					        	while(rs.next()){
					         %>
				       		<tr bgcolor="#C8D6FF">
					            <td height="25"><%=rs.getString("Cid") %></td>
					            <td><%=rs.getString("Cname") %></td>
					            <td><%=rs.getString("Tname") %></td>
					            <td><%=rs.getString("Chour") %></td>
					            <td><%=rs.getString("Ccredit") %></td>
					            <% String tempid = rs.getString("Tempid");
					            	sql = "select Cday,Cnum,Rname,Cstart,Cend from SCT inner join Cweek on SCT.SCTid=Cweek.SCTid inner "+
					            	"join Ctime on Ctime.CweekID=Cweek.CweekID inner join CRoomArrange on Cweek.CweekID="+
					            	"CRoomArrange.CweekID";
					            	sql+=String.format(" where SCT.Tempid='%s'", rs.getString("Tempid"));
					            	//System.out.print(sql);
					            	ResultSet rs1 = DBControllor.excuteQuery(sql);
					            %>
<!-- 					            <td>1-12</td> -->
					            <td>
					            <%
					            String[] weekday = {"周日","周一","周二","周三","周四","周五","周六"};
					            String[] num = {"1-2节","3-4节","5-6节","7-8节","9-10节"};
					            boolean yes = false;
					            while(rs1.next()){ yes=true; %>
					            <%=weekday[Integer.parseInt(rs1.getString("Cday"))] %>
					            <%=num[Integer.parseInt(rs1.getString("Cnum"))] %> 
					            <%=rs1.getString("Rname") %> 
					            	第<%=rs1.getString("Cstart") %>周-第<%=rs1.getString("Cend") %>周<br />
					            <%} if(!yes){%>
					            <%="未定" %>
					            <%} %>
					            </td>
					            <td></td>
				           </tr>  
				           <%} %>
				      </tbody>
				  </table>
				</div>
				<h3 style="text-align: center;height:5px;color: #444">英语课选课结果</h3>
				<div id="biao" style="overflow: auto;">
					<table  id="scorestable2" style="width:810px;" border="1" cellpadding="0" cellspacing="0">
				        <tbody>
				        	<tr bgcolor="#CCCCCC">
					            <td height="28"><div><strong>课程号</strong></div></td>
					            <td ><div><strong>课程名</strong></div></td>
					            <td ><div><strong>授课教师</strong></div></td>
					            <td><div><strong>学时</strong></div></td>
					            <td><div><strong>学分</strong></div></td>
<!-- 					            <td><div><strong>起止周</strong></div></td> -->
					            <td><div><strong>上课时间与教室</strong></div></td>
					             <td><div><strong>备注</strong></div></td>

					        </tr>
				       		<%
					        	 sql = "select distinct Course.Cid,Cname,Tname,Chour,Ccredit,SC.Tempid from SC inner join TempCourse on SC.Tempid=TempCourse.Tempid"+
					        	" inner join Course on Course.Cid=TempCourse.Cid inner join Teacher on Teacher.Tid="
					        	+"TempCourse.Tid";
					        	sql+=String.format(" where SC.Sid='%s' and TempCourse.Term='%s' and Ctype='3'", student.getID(),
					        			DataManager.getTerm());
					        	 rs = DBControllor.excuteQuery(sql);
					        	while(rs.next()){
					         %>
				       		<tr bgcolor="#C8D6FF">
					            <td height="25"><%=rs.getString("Cid") %></td>
					            <td><%=rs.getString("Cname") %></td>
					            <td><%=rs.getString("Tname") %></td>
					            <td><%=rs.getString("Chour") %></td>
					            <td><%=rs.getString("Ccredit") %></td>
					            <% String tempid = rs.getString("Tempid");
					            	sql = "select Cday,Cnum,Rname,Cstart,Cend from SCT inner join Cweek on SCT.SCTid=Cweek.SCTid inner "+
					            	"join Ctime on Ctime.CweekID=Cweek.CweekID inner join CRoomArrange on Cweek.CweekID="+
					            	"CRoomArrange.CweekID";
					            	sql+=String.format(" where SCT.Tempid='%s'", rs.getString("Tempid"));
					            	//System.out.print(sql);
					            	ResultSet rs1 = DBControllor.excuteQuery(sql);
					            %>
<!-- 					            <td>1-12</td> -->
					            <td>
					            <%
					            String[] weekday = {"周日","周一","周二","周三","周四","周五","周六"};
					            String[] num = {"1-2节","3-4节","5-6节","7-8节","9-10节"};
					            boolean yes = false;
					            while(rs1.next()){ yes=true;%>
					            <%=weekday[Integer.parseInt(rs1.getString("Cday"))] %>
					            <%=num[Integer.parseInt(rs1.getString("Cnum"))] %> 
					            <%=rs1.getString("Rname") %> 
					            	第<%=rs1.getString("Cstart") %>周-第<%=rs1.getString("Cend") %>周<br />
					            <%} if(!yes){%>
					            <%="未定" %>
					            <%} %>
					            </td>
					            <td></td>
				           </tr>  
				           <%} %>
				      </tbody>
				  </table>
				</div>
				<h3 style="text-align: center;height:5px;color: #444">体育课选课结果</h3>
				<div id="biao" style="overflow: auto;">
					<table  id="scorestable3" style="width:810px;" border="1" cellpadding="0" cellspacing="0">
				        <tbody>
				        	<tr bgcolor="#CCCCCC">
					            <td height="28"><div><strong>课程号</strong></div></td>
					            <td ><div><strong>课程名</strong></div></td>
					            <td ><div><strong>授课教师</strong></div></td>
					            <td><div><strong>学时</strong></div></td>
					            <td><div><strong>学分</strong></div></td>
<!-- 					            <td><div><strong>起止周</strong></div></td> -->
					            <td><div><strong>上课时间与教室</strong></div></td>
					             <td><div><strong>备注</strong></div></td>
					        </tr>
				       		<%
					        	 sql = "select distinct Course.Cid,Cname,Tname,Chour,Ccredit,SC.Tempid from SC inner join TempCourse on SC.Tempid=TempCourse.Tempid"+
					        	" inner join Course on Course.Cid=TempCourse.Cid inner join Teacher on Teacher.Tid="
					        	+"TempCourse.Tid";
					        	sql+=String.format(" where SC.Sid='%s' and TempCourse.Term='%s' and Ctype='4'", student.getID(),
					        			DataManager.getTerm());
					        	 rs = DBControllor.excuteQuery(sql);
					        	while(rs.next()){
					         %>
				       		<tr bgcolor="#C8D6FF">
					            <td height="25"><%=rs.getString("Cid") %></td>
					            <td><%=rs.getString("Cname") %></td>
					            <td><%=rs.getString("Tname") %></td>
					            <td><%=rs.getString("Chour") %></td>
					            <td><%=rs.getString("Ccredit") %></td>
					            <% String tempid = rs.getString("Tempid");
					            	sql = "select Cday,Cnum,Rname,Cstart,Cend from SCT inner join Cweek on SCT.SCTid=Cweek.SCTid inner "+
					            	"join Ctime on Ctime.CweekID=Cweek.CweekID inner join CRoomArrange on Cweek.CweekID="+
					            	"CRoomArrange.CweekID";
					            	sql+=String.format(" where SCT.Tempid='%s'", rs.getString("Tempid"));
					            	//System.out.print(sql);
					            	ResultSet rs1 = DBControllor.excuteQuery(sql);
					            %>
<!-- 					            <td>1-12</td> -->
					            <td>
					            <%
					            String[] weekday = {"周日","周一","周二","周三","周四","周五","周六"};
					            String[] num = {"1-2节","3-4节","5-6节","7-8节","9-10节"};
					            boolean yes = false;
					            while(rs1.next()){ yes=true;%>
					            <%=weekday[Integer.parseInt(rs1.getString("Cday"))] %>
					            <%=num[Integer.parseInt(rs1.getString("Cnum"))] %> 
					            <%=rs1.getString("Rname") %> 
					            	第<%=rs1.getString("Cstart") %>周-第<%=rs1.getString("Cend") %>周<br />
					            <%} if(!yes){%>
					            <%="未定" %>
					            <%} %>
					            </td>
					            <td></td>
				           </tr>  
				           <%} %>
				      </tbody>
				  </table>
				</div>
				<h3 style="text-align: center;height:5px;color: #444">全校任选课选课结果</h3>
				<div id="biao" style="overflow: auto;">
					<table  id="scorestable4" style="width:810px;" border="1" cellpadding="0" cellspacing="0">
				        <tbody>
				        	<tr bgcolor="#CCCCCC">
					            <td height="28"><div><strong>课程号</strong></div></td>
					            <td ><div><strong>课程名</strong></div></td>
					            <td ><div><strong>授课教师</strong></div></td>
					            <td><div><strong>学时</strong></div></td>
					            <td><div><strong>学分</strong></div></td>
<!-- 					            <td><div><strong>起止周</strong></div></td> -->
					            <td><div><strong>上课时间与教室</strong></div></td>
					             <td><div><strong>备注</strong></div></td>

					        </tr>
				       		<%
					        	 sql = "select distinct Course.Cid,Cname,Tname,Chour,Ccredit,SC.Tempid from SC inner join TempCourse on SC.Tempid=TempCourse.Tempid"+
					        	" inner join Course on Course.Cid=TempCourse.Cid inner join Teacher on Teacher.Tid="
					        	+"TempCourse.Tid";
					        	sql+=String.format(" where SC.Sid='%s' and TempCourse.Term='%s' and Ctype='2'", student.getID(),
					        			DataManager.getTerm());
					        	 rs = DBControllor.excuteQuery(sql);
					        	while(rs.next()){
					         %>
				       		<tr bgcolor="#C8D6FF">
					            <td height="25"><%=rs.getString("Cid") %></td>
					            <td><%=rs.getString("Cname") %></td>
					            <td><%=rs.getString("Tname") %></td>
					            <td><%=rs.getString("Chour") %></td>
					            <td><%=rs.getString("Ccredit") %></td>
					            <% String tempid = rs.getString("Tempid");
					            	sql = "select Cday,Cnum,Rname,Cstart,Cend from SCT inner join Cweek on SCT.SCTid=Cweek.SCTid inner "+
					            	"join Ctime on Ctime.CweekID=Cweek.CweekID inner join CRoomArrange on Cweek.CweekID="+
					            	"CRoomArrange.CweekID";
					            	sql+=String.format(" where SCT.Tempid='%s'", rs.getString("Tempid"));
					            	//System.out.print(sql);
					            	ResultSet rs1 = DBControllor.excuteQuery(sql);
					            %>
<!-- 					            <td>1-12</td> -->
					            <td>
					            <%
					            String[] weekday = {"周日","周一","周二","周三","周四","周五","周六"};
					            String[] num = {"1-2节","3-4节","5-6节","7-8节","9-10节"};
					            boolean yes = false;
					            while(rs1.next()){ yes=true;%>
					            <%=weekday[Integer.parseInt(rs1.getString("Cday"))] %>
					            <%=num[Integer.parseInt(rs1.getString("Cnum"))] %> 
					            <%=rs1.getString("Rname") %> 
					            	第<%=rs1.getString("Cstart") %>周-第<%=rs1.getString("Cend") %>周<br />
					            <%} if(!yes){%>
					            <%="未定" %>
					            <%} %>
					            </td>
					            <td></td>
				           </tr>  
				           <%} %>
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