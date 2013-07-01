var xmlhttp;
	if (window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}
	else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	
var Tid;
var init_page = function(id){
	Tid = id;
//	xmlhttp.onreadystatechange=function(){
//		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
//			  document.getElementById("course-input").innerHTML = xmlhttp.responseText;
//		    }
//		  }
//		xmlhttp.open("GET","GetCourseOfTeacher?Tid="+Tid,true);
//		xmlhttp.send();
}

var query = function(Tid){
	var select = document.getElementById("term-input");
	var Term = select.options[select.selectedIndex].value;
	select = document.getElementById("course-input");
	var Cid = select.options[select.selectedIndex].value;
	xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
			  document.getElementById("course-input").innerHTML = xmlhttp.responseText;
		    }
		  }
		xmlhttp.open("GET","GetStudentOfCourse?Tid="+Tid+"&Term="+Term+"&Cid="+Cid,true);
		xmlhttp.send();
}

var getTermCourse = function(){
	var select = document.getElementById("term-input");
	var Term = select.options[select.selectedIndex].value;
	//alert(Tid);
	xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
			  document.getElementById("course-input").innerHTML = xmlhttp.responseText;
		    }
		  }
		xmlhttp.open("GET","GetCourseOfTerm?Tid="+Tid+"&Term="+Term,true);
		xmlhttp.send();
}

var queryStudent = function(){
	var select = document.getElementById("term-input");
	var Term = select.options[select.selectedIndex].value;
	select = document.getElementById("course-input");
	var Cid = select.options[select.selectedIndex].value;
	xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
			  document.getElementById("student-table").innerHTML = xmlhttp.responseText;
		    }
		  }
		xmlhttp.open("GET","GetStudentOfTeacher?Tid="+Tid+"&Term="+Term+"&Cid="+Cid,true);
		xmlhttp.send();
}

var queryStu = function(){
	var select = document.getElementById("term-input");
	var Term = select.options[select.selectedIndex].value;
	select = document.getElementById("course-input");
	var Cid = select.options[select.selectedIndex].value;
	xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
			  document.getElementById("student-table").innerHTML = xmlhttp.responseText;
		    }
		  }
		xmlhttp.open("GET","GetStudentandScores?Tid="+Tid+"&Term="+Term+"&Cid="+Cid,true);
		xmlhttp.send();
}

var queryComment = function(){
	//alert("asd");
	var select = document.getElementById("term-input");
	var Term = select.options[select.selectedIndex].value;
	select = document.getElementById("course-input");
	var Cid = select.options[select.selectedIndex].value;
	xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
			  var res = xmlhttp.responseText.split("&&&");
			  var scores = res[0].split("###");
			  var infos = res[1].split("$$$");
			  showscores(scores);
			  showinfos(infos);
		    }
		  }
		xmlhttp.open("GET","GetComments?Tid="+Tid+"&Term="+Term+"&Cid="+Cid,true);
		xmlhttp.send();
}

var showscores = function(scores){
	var table = document.getElementById("scorestable");
	for(var i=1; i<=10; i++){
		if(scores[i-1]!="0")
		table.rows[i].cells[2].innerText = scores[i-1]+"";
		else 
			table.rows[i].cells[2].innerText = "---";
	}
	
}
var showinfos = function(infos){
	var cols = document.getElementById("comms");
	var text = "";
	for(var i=0; i<infos.length; i++)
		if(infos[i]!="")
		text+="<li>"+infos[i]+"</li>"
		cols.innerHTML = text;
}