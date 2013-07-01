<%@page import="com.hit.DataControllor.DataManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.hit.DataControllor.DBControllor"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.hit.Entity.Administrator"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title></title>
	<link rel="stylesheet" type="text/css" href="./css/student.css"/>
	<script type="text/html" src="js/setTimetable.js"></script>
</head>
<script type="text/javascript">
	var container;
	var t=function(){
		var a=document.getElementById("class-input");
		
		alert(a.value);
	}
	var xmlhttp;
	if (window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}
	else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	var Did;
	var chooseele="none";
	var init_classinput = function(id){
		Did = id;
		xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
			  document.getElementById("class-input").innerHTML = xmlhttp.responseText;
		    }
		  }
		xmlhttp.open("GET","GetClassOfDept?Did="+Did,true);
		xmlhttp.send();
	}
	var init_courseinput = function(){
		xmlhttp.onreadystatechange=function(){
			  if (xmlhttp.readyState==4 && xmlhttp.status==200){
				  document.getElementById("course-input").innerHTML = xmlhttp.responseText;
			    }
			  }
			xmlhttp.open("GET","GetCourseOfDept?Did="+Did,true);
			xmlhttp.send();
	}
	var init = function(){
		var data = new Array(7);
		for(var i=0; i<7; i++)
			data[i] = new Array(5);
		for(var i=0; i<7; i++)
			for(var j=0; j<5; j++)
			{
				data[i][j] = i+""+j;
				document.getElementById(data[i][j]).setAttribute("onclick","changecolor('"+data[i][j]+"')") 
			}
	}
	var changecolor = function(id){
		var ele = document.getElementById(id);
		if(ele.style.background=="red"){
			ele.style.background = "white";
			chooseele = "none";
		}
		else {
			if(chooseele!="none")
				changecolor(chooseele);
			ele.style.background="red";
			chooseele = id;
		}
	}
	
	var getQueryString=function(name) {
	    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	    var r = window.location.search.substr(1).match(reg);
	    if (r != null) return unescape(r[2]); return null;
	    }
	
	var query = function(){
		//alert('asd');
		var x2 = document.getElementById("class-input");
		var Class = x2.options[x2.selectedIndex].value;
		var Major = Class.substring(2,5);
		xmlhttp.onreadystatechange=function(){
			  if (xmlhttp.readyState==4 && xmlhttp.status==200){
			    //document.getElementById("room-input").innerHTML=xmlhttp.responseText;
			//	document.write(xmlhttp.responseText);
			//	  alert("asd");
			    eval(xmlhttp.responseText);
			    }
			  }
			xmlhttp.open("GET","CourseList?class="+Class+"&major="+Major,true);
			xmlhttp.send();
			var Tempid=getQueryString("Tempid");
			document.getElementById("course-input").value=Tempid;
	} 

	var setCourse = function(id,value){
		var ele = document.getElementById(id);
		var info = value.split("#--#");
		//alert(ele.innerHTML);
		if(ele.innerHTML!="&nbsp;")
			ele.innerHTML += "<hr/>";
		ele.innerHTML += info[0]+"<br/>"+info[1]+"&nbsp;"+info[2]+"<br/>"+info[3]+"-"+info[4]+info[5];
		
	}
	var arrange = function(){
		
		if(chooseele=="none"){
			alert("请先选择一个课");
			return;
		}
		var x2 = document.getElementById("class-input");
		var Class = x2.options[x2.selectedIndex].value;
		x2 = document.getElementById("course-input");
		Tempid = x2.options[x2.selectedIndex].value;
		x2 = document.getElementById("week1-input");
		var Cstart = x2.options[x2.selectedIndex].value;
		x2 = document.getElementById("week2-input");
		var Cend = x2.options[x2.selectedIndex].value;
		x2 = document.getElementById("room-input");
		var Rname = x2.options[x2.selectedIndex].value;
		//alert("asds");
		xmlhttp.onreadystatechange=function(){
			  if (xmlhttp.readyState==4 && xmlhttp.status==200){
			    //document.getElementById("room-input").innerHTML=xmlhttp.responseText;
			//	document.write(xmlhttp.responseText);
			//	  alert("asd");
			alert('成功');
			    eval(xmlhttp.responseText);
			    }
			  }
			xmlhttp.open("GET","ArrangeCourse?Class="+Class+"&Tempid="+Tempid+"&Cstart="+Cstart+"&Cend="+Cend+"&Rname="+Rname+"&Ctime="+chooseele,true);
			xmlhttp.send();
	}
	</script>
	<%
		Administrator administrator = (Administrator)session.getAttribute("USER");
	%>
<body onload="init(); query()"> 
	<span id="welcome"><%=administrator.getID() %> <%=administrator.getName() %> | <a id="title" href="">退出</a></span>
	<div id="header">	
			<a id="logo" href="http://www.hit.edu.cn">
				<img src="./pics/hit.png" alt="" />
			</a>
		<ul id="nav">
			<li><a href="./admin.jsp" >课程管理</a></li>
			<li><a href="./setTimetable.jsp"class="navActive">排课</a></li>
			<li><a href="./manageStudent.jsp">学籍管理</a></li>
			<li><a href="./manageScores.jsp">成绩管理</a></li>
			<li><a href="./manageTeacher.jsp">教师管理</a></li>
			<li><a href="./manageComm.jsp">评教管理</a></li>
			<li><a href="./manageAdmin.html">管理员管理</a></li>
			<li><a href="./changeManagePwd.html">修改密码</a></li>
			<li><a href="./manageInfo.html">个人信息</a></li>
		</ul>
	</div>		
	<div id="content">
		<div id="main">
			<div id="main-top">	
			</div>
			<div id="main-main">
				<h2 id="queryRoom">
					<span>排课</span>
				</h2>
				<form action="" id="query-input">	
					<div class="getIn"style="width:890px;height:60px;">
						<div>
						&nbsp;
						<span class="week">班级：</span>
						<select id="class-input"  name="class-input" dataType="Require"  msg="未选择班级"  onchange="query()">
                     	<%
                     	String sql = String.format("select distinct Sclass from Student where Did='%s'", administrator.getDid());
                		ResultSet rs = DBControllor.excuteQuery(sql);
                		try {
                			while(rs.next()){
                				String s = String.format("<option value='%s'>%s</option>", rs.getString("Sclass"),rs.getString("Sclass"));
                				out.print(s);
                			}
                		} catch (SQLException e) {
                			// TODO Auto-generated catch block
                			e.printStackTrace();
                		}
                     	%>	
						</select>
						&nbsp;
						&nbsp;
						<span class="week">课程名：</span>
						<select id="course-input" name="course-input" dataType="Require" style="width:8em;" msg="未选择课程"  >
                        <%
                        String Did = administrator.getDid();
                		sql = String.format("select Tempid,Cname from TempCourse inner join Course on TempCourse.Cid=Course.Cid inner join (select * from Major where Major.Did='%s') as M1 on M1.Mid=TempCourse.Mid where TempCourse.Term='%s'", Did,DataManager.getTerm());
                		rs = DBControllor.excuteQuery(sql);
                		try {
                			while(rs.next()){
                				String s = String.format("<option value='%s'>%s</option>",rs.getString("Tempid"),rs.getString("Cname") );
                				out.print(s);
                			}
                		} catch (SQLException e) {
                			// TODO Auto-generated catch block
                			e.printStackTrace();
                		}
                        %>
						</select>
						&nbsp;
						<span class="week2">授课时间：</span>
						<select id="week1-input" name="week1-input" dataType="Require"  msg="未选择教室"  >
                        <%
                        	for(int i=1; i<=20; i++){
                        		String s = String.format("<option value='%d'>第%d周</option>",i,i);
                        		out.print(s);
                        	}
                        %>
						</select>
						至
						<select id="week2-input" name="week2-input" dataType="Require"  msg="未选择教室"  >
                         <%
                        	for(int i=1; i<=20; i++){
                        		String s = String.format("<option value='%d'>第%d周</option>",i,i);
                        		out.print(s);
                        	}
                        %>
						</select>
						&nbsp;<br />&nbsp;
						<span class="week2">地点：</span>
						<select id="room-input" name="room-input" dataType="Require"  msg="未选择教室"  >
                        <%
                        	rs = DBControllor.excuteQuery("select Rname from Room order by Rname desc");
                        	while(rs.next()){
                        		String s0 = String.format("<option value='%s'>%s</option>",rs.getString("Rname"),rs.getString("Rname"));
                        		out.print(s0);
                        	}
                        %>
						</select>
						&nbsp;&nbsp;&nbsp;
						<span class="week2">剩余课时数：</span>
						<input id="chour-input" name="chour-input" style="width:75px;" dataType="Require" readonly="true" />
						&nbsp;
						<span class="week2">当前学期：</span>
						<select id="term-input" name="term-input" dataType="Require"  msg="未选择学期"  >
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
					    &nbsp;&nbsp;
						<input id="submit" style="background:yellow;border: 1px solid #C7CACC;
	border-radius: 4px;cursor:pointer;" name="submit" value="排课"type="button" onclick="arrange()"/>
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