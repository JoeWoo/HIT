var xmlhttp;
	if (window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}
	else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
var queryComm = function(){
	var select = document.getElementById("dept-input");
	var Did = select.options[select.selectedIndex].value;
	select = document.getElementById("teacher-input");
	var Tid = select.options[select.selectedIndex].value;
	select = document.getElementById("term-input");
	var Term = select.options[select.selectedIndex].value;
	xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
		    document.getElementById("comment-table").innerHTML=xmlhttp.responseText;
		    }
		  }
		xmlhttp.open("GET","AdminQueryTeacher?Did="+Did+"&Tid="+Tid+"&Term="+Term,true);
		xmlhttp.send();
}