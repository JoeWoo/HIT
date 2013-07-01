
var xmlhttp;
	if (window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}
	else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
var getTids = function(){
	var select = document.getElementById("dept-input");
	var Did = select.options[select.selectedIndex].value;
	xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
		    document.getElementById("teacher-input").innerHTML="<option value='nochoose'>-未选择-</option>"+xmlhttp.responseText;
		  }
		  }
		xmlhttp.open("GET","GetTids?Did="+Did,true);
		xmlhttp.send();
}

var queryTeacher = function(){
	
	var select = document.getElementById("dept-input");
	var Did = select.options[select.selectedIndex].value;
	select = document.getElementById("teacher-input");
	var Tid = select.options[select.selectedIndex].value;
	xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
		    document.getElementById("teacher-table").innerHTML=xmlhttp.responseText;
		    }
		  }
		xmlhttp.open("GET","AdminQueryTeacher?Did="+Did+"&Tid="+Tid,true);
		xmlhttp.send();
}


var edit1 = function(row){
	var line = document.getElementById(row);
	var info = document.getElementById("info"+row).value;
	var result = info.split("#");
	document.getElementById("Tname").value = line.cells[1].innerText;
	document.getElementById("Tsex").value = line.cells[2].innerText;
	document.getElementById("Tbirthday").value = result[0];
	document.getElementById("TpersonID").value = result[1];
	document.getElementById("Tid").value = line.cells[0].innerText;
	document.getElementById("dept-input-right").value = result[2];
	document.getElementById("Ttitle").value = line.cells[4].innerText;
	document.getElementById("Ttelephone").value = line.cells[5].innerText;
	document.getElementById("Temail").value = line.cells[6].innerText;
};
var addTeacher = function(){
	var tname = document.getElementById("Tname").value;
	var tsex = document.getElementById("Tsex").value;
	var tbirthday = document.getElementById("Tbirthday").value;
	var tpersonID = document.getElementById("TpersonID").value;
	var tid = document.getElementById("Tid").value;
	//var dname = document.getElementById("Dname").value;
	select = document.getElementById("dept-input-right");
	var did = select.options[select.selectedIndex].value;
	var ttitle = document.getElementById("Ttitle").value;
	var ttelephone = document.getElementById("Ttelephone").value;
	var temail = document.getElementById("Temail").value;
	xmlhttp.onreadystatechange=function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			alert("yes");
			//document.getElementById("teacher-table").innerHTML=xmlhttp.responseText;
		}
	};
	xmlhttp.open("GET","AddTeacher?name="+tname+"&Tid="+tid+"&sex="+tsex+"&bir="+tbirthday
			+"&personid="+tpersonID+"&Did="+did+"&title="+ttitle+"&tel="+ttelephone+"&email="+temail,true);
	xmlhttp.send();
};

var updateTeacher = function(){
	var tname = document.getElementById("Tname").value;
	var tsex = document.getElementById("Tsex").value;
	var tbirthday = document.getElementById("Tbirthday").value;
	var tpersonID = document.getElementById("TpersonID").value;
	var tid = document.getElementById("Tid").value;
	//var dname = document.getElementById("Dname").value;
	select = document.getElementById("dept-input-right");
	var did = select.options[select.selectedIndex].value;
	var ttitle = document.getElementById("Ttitle").value;
	var ttelephone = document.getElementById("Ttelephone").value;
	var temail = document.getElementById("Temail").value;
	xmlhttp.onreadystatechange=function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			alert("yes");
			//document.getElementById("teacher-table").innerHTML=xmlhttp.responseText;
		}
	};
	xmlhttp.open("GET","UpdateTeacher?name="+tname+"&Tid="+tid+"&sex="+tsex+"&bir="+tbirthday
			+"&personid="+tpersonID+"&Did="+did+"&title="+ttitle+"&tel="+ttelephone+"&email="+temail,true);
	xmlhttp.send();
}