var xmlhttp;
if (window.XMLHttpRequest){
	xmlhttp=new XMLHttpRequest();
}
else{
	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
}
var Did;
var init_classinput = function(id){
	Did = id;
	alert(Did);
	xmlhttp.onreadystatechange=function(){
	  if (xmlhttp.readyState==4 && xmlhttp.status==200){
		  document.getElementById("class-input").innerHTML = xmlhttp.responseText;
	    }
	  }
	xmlhttp.open("GET","GetClassOfDept?Did="+Did,true);
	xmlhttp.send();
}