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
		  };
		xmlhttp.open("GET","AdminQueryComm?Did="+Did+"&Tid="+Tid+"&Term="+Term,true);
		xmlhttp.send();
};
var getTids1 = function(id){
	//var select = document.getElementById("dept-input");
	var Did = id;
	xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
		    document.getElementById("teacher-input").innerHTML="<option value='nochoose'>-未选择-</option>"+xmlhttp.responseText;
		  }
		  };
		xmlhttp.open("GET","GetTids?Did="+Did,true);
		xmlhttp.send();
};
var init_comm = function(id){
	//alert('zz');
	//alert(id);
	if(id!='00') getTids1(id);
	//alert('zz');
};