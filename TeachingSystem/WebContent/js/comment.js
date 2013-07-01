var xmlhttp;
	if (window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}
	else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
var comment = function(id){
	var line = document.getElementById(id);
	var Tempid = document.getElementById("Temp"+id).value;
	document.getElementById("right-title").innerHTML ="<input type='hidden' id='Cid0' name='Tempid0' value='"+Tempid+"'>" +line.cells[2].innerText;
}

var confirm = function(){
	var Tempid = document.getElementById("Cid0").value;
	xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
			  alert("评教成功");
			  //document.getElementById("course-input").innerHTML = xmlhttp.responseText;
			  
		    }
		  }
		xmlhttp.open("GET","Comment?Tempid="+Tempid+"&Sid="+Sid,true);
		xmlhttp.send();
}