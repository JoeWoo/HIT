
var xmlhttp;
	if (window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}
	else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
var choose = function(id){
	alert("asd");
	var table = document.getElementById("coursetable");
	var Tempid = table.rows[id].cells[0].innerText;
	xmlhttp.onreadystatechange=function(){
			  if (xmlhttp.readyState==4 && xmlhttp.status==200){
				  alert("确认成功");
				//  document.getElementById("course-input").innerHTML = xmlhttp.responseText;
			    
			  }
			  }
		xmlhttp.open("GET","ChooseCourse?Tempid="+Tempid,true);
		xmlhttp.send();
}