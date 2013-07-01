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
					<div class="getIn">
						<div>
						&nbsp;
						<span class="week">学期：</span>
						<select id="class-input" name="class-input" dataType="Require"  msg="未选择学期"  >
                        <option value="all">全部学期</option>
                        <option value="201001">201001</option>
                        <option value="201002">201001</option>
                        <option value="201101">201001</option>
                        <option value="201102">201001</option>
						</select>
						&nbsp;
						&nbsp;
						<input id="submit" name="submit" value="查询"type="submit">
						</div>
						
					</div>

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
					            <td><div><strong>起止周</strong></div></td>
					            <td><div><strong>上课时间与教室</strong></div></td>
					             <td><div><strong>备注</strong></div></td>

					        </tr>
				       		<tr bgcolor="#C8D6FF">
					           
					            <td height="25">08T1370030</td>
					            <td>程序设计语言</td>
					            
					            <td>全校任选</td>
					            <td>70</td>
					            <td>4</td>
					            <td>1-12</td>
					            <td>周一1-2节 正心22 <br />周三5-6节 致知12	</td>
					            <td></td>
				           </tr>  
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
					            <td><div><strong>起止周</strong></div></td>
					            <td><div><strong>上课时间与教室</strong></div></td>
					             <td><div><strong>备注</strong></div></td>

					        </tr>
				       		<tr bgcolor="#C8D6FF">
					           
					            <td height="25">08T1370030</td>
					            <td>程序设计语言</td>
					            
					            <td>全校任选</td>
					            <td>70</td>
					            <td>4</td>
					            <td>1-12</td>
					            <td>周一1-2节 正心22 <br />周三5-6节 致知12	</td>
					            <td></td>
				           </tr>  
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
					            <td><div><strong>起止周</strong></div></td>
					            <td><div><strong>上课时间与教室</strong></div></td>
					             <td><div><strong>备注</strong></div></td>

					        </tr>
				       		<tr bgcolor="#C8D6FF">
					           
					            <td height="25">08T1370030</td>
					            <td>程序设计语言</td>
					            
					            <td>全校任选</td>
					            <td>70</td>
					            <td>4</td>
					            <td>1-12</td>
					            <td>周一1-2节 正心22 <br />周三5-6节 致知12	</td>
					            <td></td>
				           </tr>  
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
					            <td><div><strong>起止周</strong></div></td>
					            <td><div><strong>上课时间与教室</strong></div></td>
					             <td><div><strong>备注</strong></div></td>

					        </tr>
				       		<tr bgcolor="#C8D6FF">
					           
					            <td height="25">08T1370030</td>
					            <td>程序设计语言</td>
					            
					            <td>全校任选</td>
					            <td>70</td>
					            <td>4</td>
					            <td>1-12</td>
					            <td>周一1-2节 正心22 <br />周三5-6节 致知12	</td>
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