var xmlhttp;
	if (window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}
	else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
var init_page = function(Did){
	xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
		    document.getElementById("dept-input").innerHTML="<option value='nochoose'>-未选择-</option>"+xmlhttp.responseText;
		  }
		    if(document.getElementById("dept-input-right")!=null)
		    document.getElementById("dept-input-right").innerHTML = "<option value='nochoose'>-未选择-</option>"+xmlhttp.responseText;
		    }
		xmlhttp.open("GET","GetDept?Did="+Did,true);
		xmlhttp.send();
};

var getMajor = function(flag){
	var select;
	if(flag==0)
	select = document.getElementById("dept-input");
	else select = document.getElementById("dept-input-right");
	var Did = select.options[select.selectedIndex].value;
		xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
			  if(flag==0)
		    document.getElementById("major-input").innerHTML="<option value='nochoose'>-未选择-</option>"+xmlhttp.responseText;
			  else 
				  document.getElementById("major-input-right").innerHTML=xmlhttp.responseText; 
		    }
		  };
		xmlhttp.open("GET","GetMajorOfDept?Did="+Did,true);
		xmlhttp.send();
};

var getClass = function(flag){
	var select;
	if(flag==0)
	{
		select = document.getElementById("dept-input");
		var Did=select.options[select.selectedIndex].value;
		select = document.getElementById("major-input");
		var Major = select.options[select.selectedIndex].value;
		select = document.getElementById("year-input");
		var Syear = select.options[select.selectedIndex].value;
		xmlhttp.onreadystatechange=function(){
			  if (xmlhttp.readyState==4 && xmlhttp.status==200){
			    document.getElementById("class-input").innerHTML="<option value='nochoose'>-未选择-</option>"+xmlhttp.responseText;
			  }
		};
			xmlhttp.open("GET","GetClassOfDept?Did="+Did+"&Mid="+Major+"&Syear="+Syear,true);
			xmlhttp.send();	
	
	}
};

var getStudent = function(){
	var select;
	select = document.getElementById("class-input");
	var Class = select.options[select.selectedIndex].value;
	xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
		    document.getElementById("sid-input").innerHTML="<option value='nochoose'>-未选择-</option>"+xmlhttp.responseText;
		  }
	};
		xmlhttp.open("GET","GetStudentOfClass?Sclass="+Class,true);
		xmlhttp.send();	
};

var queryScores = function(){
	var select;
	select = document.getElementById("class-input");
	var Class = select.options[select.selectedIndex].value;
	select = document.getElementById("sid-input");
	var Sid = select.options[select.selectedIndex].value;
	 select = document.getElementById("term-input");
	var Term = select.options[select.selectedIndex].value;
	
	if(Class!="nochoose" && Sid!="nochoose"){
		document.getElementById("biao2").style.display="none";
		document.getElementById("biao1").style.display="block";
		var flag = 0;
		info = Term;
		xmlhttp.onreadystatechange=function(){
			  if (xmlhttp.readyState==4 && xmlhttp.status==200){
				  document.getElementById("score-input").innerHTML = xmlhttp.responseText;
			    }
			  }
			xmlhttp.open("GET","GetScores?flag="+flag+"&info="+info+"&Sid="+Sid,true);
			xmlhttp.send();
	}
	else{
		document.getElementById("biao1").style.display="none";
		document.getElementById("biao2").style.display="block";
		xmlhttp.onreadystatechange=function(){
			  if (xmlhttp.readyState==4 && xmlhttp.status==200){
				  var head="<tr bgcolor='#CCCCCC'><td height='28'>"+
				  "<div><strong>排名</strong></div></td><td ><div><strong>学号</strong></div></td>"+
				  "<td width='20%'><div><strong>姓名</strong></div></td><td width='25%'>"+
				  "<div><strong>平均学分绩</strong></div></td><td width='10%'><div><strong>不及格科目数</strong></div><td><div><strong>百分比</strong></div></td><td><div><strong>备注</strong></div></td></tr>";
				 
				  document.getElementById("xuefenji").innerHTML = head + xmlhttp.responseText;
			    }
			  };
			xmlhttp.open("GET","GetScoresOfClass?SClass="+Class+"&Term="+Term,true);
			xmlhttp.send();
	}
		
};