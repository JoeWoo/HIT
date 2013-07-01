var xmlhttp;
	if (window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}
	else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
var initMajor = function(){
	var major_select = document.getElementById("major-input");
	xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
		    eval(xmlhttp.responseText);
		    }
		  }
		xmlhttp.open("GET","ajax/major.txt",true);
		xmlhttp.send();
}

var queryScores = function(){
	
}