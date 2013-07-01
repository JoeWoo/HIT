var xmlhttp;
	if (window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}
	else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
var modify = function(){
	//alert("asd");
	var telephone = document.getElementById("telephone").value;
	var email = document.getElementById("email").value;
	alert(telephone);
	xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
			  alert("修改成功");
		    }
		  }
		xmlhttp.open("ModifyInfo",true);
		xmlhttp.send();
}