<%@page import="com.hit.DataControllor.DBDeliver"%>
<%@page import="com.hit.DataControllor.DBControllor"%>
<%@page import="com.hit.DataControllor.DataManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.hit.Entity.Student"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title></title>
	<link rel="stylesheet" type="text/css" href="./css/student.css"/>
	<script type="text/javascript" src="js/comment.js"></script>
</head>
	<script type="text/javascript">
	var container;
	var call=function (id){
	 	container = document.getElementById(id);
		var x=0,y=0;
		while(container.offsetParent)
		{
			x+=container.offsetLeft;
			y+=container.offsetTop;
			container=container.offsetParent;
		} 
		container = document.getElementById(id);
		var sco = document.getElementById("sco");
		sco.style.left = (x+30)+"px";
        sco.style.top = (y-12)+"px";
        sco.style.display = "block";
		} 
	var discall=function(){
		var sco = document.getElementById("sco");
		if (event.clientX<1075-250)
		sco.style.display="none";
	}
	var sel=function(id){
		container.value=id+"";
	}
	var popout=function(){
		var sco = document.getElementById("sco");
		sco.style.display="none";
		var cText = document.getElementById("cText");
		cText.style.display="block";

	}
	</script>
	<%
	Student student = (Student)session.getAttribute("USER");
%>
<body>
	<span id="welcome"><%=student.getID() %> <%=student.getName() %> | <a id="title" href="">退出</a></span>
	<div id="header">	
			<a id="logo" href="http://www.hit.edu.cn">
				<img src="./pics/hit.png" alt="" />
			</a>
		<ul id="nav">
			<li><a href="./chooseCourse.jsp">课程选修</a></li>
			<li><a href="./queryTimetable.jsp" >课表查询</a></li>
			<li><a href="./queryRoom.jsp"  >教室查询</a></li>
			<li><a href="./comment.jsp" class="navActive">学生评教</a></li>
			<li><a href="./queryScores.jsp" >成绩查询</a></li>
			<li><a href="./changePwd.html">修改密码</a></li>
			<li><a href="./info.jsp" >学籍信息</a></li>
			<li><a href="http://http://today.hit.edu.cn/">今日哈工大</a></li>
		</ul>
	</div>	

	<div id="content">
		<div id="sco">
		<div id="hide">
			<div id="arrow2"></div>
			<div id="dafen">
				<dl>
					<dt>极好：<input type="button" value="100" style="background:#95693a" onclick="sel(100)"/></dt>
					<dt>很好：<input type="button" value="90"style="background:#ef2200" onclick="sel(90)" /></dt>
					<dt>好&nbsp;&nbsp;&nbsp;：<input type="button" value="80" style="background:#89c013" onclick="sel(80)"/></dt>
					<dt>较好：<input type="button" value="70" style="background:#a40000" onclick="sel(70)"/></dt>
					<dt>一般：<input type="button" value="60"style="background:#ff9000" onclick="sel(60)"/></dt>
					<dt>差&nbsp;&nbsp;&nbsp;：<input type="button" value="50" style="background:#a2e6e0"onclick="sel(50)"/></dt>
					<dt>很差：<input type="button" value="30"style="background:#e7e9e9" onclick="sel(30)"/></dt>
				</dl>
			</div>
			</div>
			</div>	
		<div id="left">
			<div id="left-top">	
			</div>
			<div id="left-main">
				<h2 id="queryRoom">
					<span>学生评教</span>
				</h2>
				<div id="biao">
				<table style="width:600px;" id="scorestable"border="1" cellpadding="0" cellspacing="0">
				        <tbody>
				        	<tr bgcolor="#CCCCCC">
					            <td  height="28" width="10%"><div><strong>类别</strong></div></td>
					            <td><div><strong>课程号</strong></div></td>
					            <td width="45%"><div><strong>课程名</strong></div></td>
					            <td width="15%"><div><strong>授课教师</strong></div></td>
					            <td><div><strong>评价</strong></div></td>
					            
					           
					        </tr>
					        <%
					        	String[] types={"必修","全校任选","英语","体育"};
					        	String sql = String.format("select Course.Cid,flag,T1.Tempid ,Ctype,Cname,Tname from " +
					    				"(select * from TempCourse where TempCourse.Term='%s') as T1 inner join " +
					    				"(select * from SC where SC.Sid='%s') as SC1 on SC1.Tempid=T1.Tempid inner " +
					    				"join Course on T1.Cid=Course.Cid inner join Teacher on T1.Tid=Teacher.Tid ",DataManager.getTerm(),student.getID());
					        	ResultSet rs = DBControllor.excuteQuery(sql);
					        	int cnt = 0;
					        	while(rs.next()){
					        %>
				       		<tr  id="row<%=++cnt %>" height="25" bgcolor="#C8D6FF">
					            <td><%=types[Integer.parseInt(rs.getString("Ctype"))-1] %></td>
					            <td><%=rs.getString("Cid") %></td>
					            <td><%=rs.getString("Cname") %></td>
					            <td><%=rs.getString("Tname") %></td>
					            <input type="hidden" id="Temprow<%=cnt %>" value="<%=rs.getString("Tempid") %>" />
					            <%if(rs.getString("flag").equals("1")){ %>
					            <td>已评完</td>
					            <%}else{ %>
					            	<td><a href="" onclick="comment('row<%=cnt %>');return false;">未评教</a></td>
					            <%} %>
					            
					            
				           </tr>
				           <%} %>
				           
				       </tbody>
				</table>
				</div>
				

			</div>
		</div>
		<div id="right">
			
		<form action="Comment" method="get">
		<div style="text-align:center;height:40px;">
			<span id="right-title" ></span>
			</div>	
		<div id="pingjiakuang">
				<ul id="prop2">
				<li onmouseover="call('re0')" onmouseout="discall()">
					<span class="aside-icon" style="margin-top:10px;"></span>
					<span>有明确的教学目标与计划，教学进度安排得当 </span>
					<input type="text" name="re0" id="re0" value="90"></input>
				</li>
				<li onmouseover="call('re1')"  onmouseout="discall()">
					<span class="aside-icon"style="margin-top:10px;"></span>
					<span>授课内容深浅度适当，学生能获得大量有价值的课程信息</span>
					<input type="text" name="re1" id="re1" value="90"></input>
				</li>
				<li onmouseover="call('re2')" onmouseout="discall()">
					<span class="aside-icon"style="margin-top:10px;"></span>
					<span style="line-height:55px;">教学内容熟练，脱稿讲授</span>
					<input type="text" style="height:50px;"name="re2"id="re2" value="90"></input>
				</li>
				<li onmouseover="call('re3')" onmouseout="discall()">
					<span class="aside-icon"style="margin-top:10px;"></span>
					<span>讲课思路清晰，重点突出，难点处理得当</span>
					<input type="text" id="re3" name="re3"value="90"></input>
				</li>
				<li onmouseover="call('re4')" onmouseout="discall()">
					<span class="aside-icon"style="margin-top:10px;"></span>
					<span>讲课具有启发性，能引导学生独立分析和思考</span>
					<input type="text" id="re4"name="re4" value="90"></input>
				</li>
				<li onmouseover="call('re5')" onmouseout="discall()">
					<span class="aside-icon"style="margin-top:10px;"></span>
					<span>讲课理论联系实际，能调动学生听课的积极性，引发学生对课程的兴趣</span>
					<input type="text" id="re5" name="re5"value="90"></input>
				</li>
				<li onmouseover="call('re6')" onmouseout="discall()">
					<span class="aside-icon"style="margin-top:10px;"></span>
					<span>注意精讲，适当练习，布置大作业（课程论文），并及时认真批改</span>
					<input type="text" id="re6" name="re6"value="90"></input>
				</li>
				<li onmouseover="call('re7')" onmouseout="discall()">
					<span class="aside-icon"style="margin-top:10px;"></span>
					<span>大作业（课程论文）联系实际，有利于课程内容的学习</span>
					<input type="text" id="re7"name="re7" value="90"></input>
				</li>
				<li onmouseover="call('re8')" onmouseout="discall()">
					<span class="aside-icon"style="margin-top:10px;"></span>
					<span style="line-height:55px;">认真组织教学，严格要求学生</span>
					<input type="text" style="height:50px;"name="re8"id="re8" value="90"></input>
				</li>
				<li onmouseover="call('re9')" onmouseout="discall()">
					<span class="aside-icon"style="margin-top:10px;"></span>
					<span>通过该课学习，学生能掌握本课程的知识并获得相应的能力提高 </span>
					<input type="text" id="re9" name="re9"value="90"></input>
				</li>
				<li onmouseover="popout()">
					<span class="aside-icon"style="margin-top:10px;"></span>
					<span>你认为该教师教学的突出优点是什么？教学有哪些需要改进的地方？</span>
				</li>
				<li id="cText"style="height:90px;display:none;"onmouseover="this.style.background='url(./pics/sidemenu-item.png) repeat'">
					<textarea name="info" style="margin-left:3px;margin-top:5px;border: 1px solid white;overflow: hidden;width:235px;height:75px;"name="commmentText" id="commentText"></textarea>
					
				</li>
				
			</ul>
			<div class="clear"></div>
					<input type="submit" class="submit1" style="margin-left:170px;"value="确认" />	
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