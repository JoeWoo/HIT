var xmlhttp;
if (window.XMLHttpRequest){
	xmlhttp=new XMLHttpRequest();
}
else{
	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
}
var Tid;
var init_page = function(id){
	Tid = id;
	getDept();
};
var getDept = function(){
	var select = document.getElementById("term-input");
	var Term = select.options[select.selectedIndex].value;
	xmlhttp.onreadystatechange=function(){
	  if (xmlhttp.readyState==4 && xmlhttp.status==200){
		  document.getElementById("major-input").innerHTML = xmlhttp.responseText;
	    }
	  };
	xmlhttp.open("GET","GetTermDept?Tid="+Tid+"&Term="+Term,true);
	xmlhttp.send();
};

var query1 = function(){
	var select = document.getElementById("term-input");
	var Term = select.options[select.selectedIndex].value;
	select = document.getElementById("major-input");
	var Mid = select.options[select.selectedIndex].value;
	xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
			  document.getElementById("course-table").innerHTML = xmlhttp.responseText;
		    }
		  };
		xmlhttp.open("GET","GetDeptCourse?Tid="+Tid+"&Term="+Term+"&Mid="+Mid,true);
		xmlhttp.send();
};