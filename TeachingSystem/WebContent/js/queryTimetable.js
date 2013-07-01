var xmlhttp;
	if (window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}
	else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
var query = function(){
	//alert('asd');
	var x1 = document.getElementById("major-input");
	var Major = x1.options[x1.selectedIndex].value;
	var x2 = document.getElementById("class-input");
	var Class = x2.options[x2.selectedIndex].value;
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
} 

var setCourse = function(id,value){
	var ele = document.getElementById(id);
	var info = value.split("#--#");
	//alert(ele.innerHTML);
	if(ele.innerHTML!="&nbsp;")
		ele.innerHTML += "<hr/>";
	ele.innerHTML += info[0]+"<br/>"+info[1]+"&nbsp;"+info[2]+"<br/>"+info[3]+"-"+info[4]+info[5];
	
}