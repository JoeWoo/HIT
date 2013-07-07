
var xmlhttp;
	if (window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}
	else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
var choose = function(id){
	var Tempid = id;
	xmlhttp.onreadystatechange=function(){
			  if (xmlhttp.readyState==4 && xmlhttp.status==200){
				  alert("确认成功");
				  document.getElementById(id+"_button").innerText = "已确认";
				//  document.getElementById("course-input").innerHTML = xmlhttp.responseText;
			    
			  }
			  };
		xmlhttp.open("GET","ChooseCourse?Tempid="+Tempid,true);
		xmlhttp.send();
};