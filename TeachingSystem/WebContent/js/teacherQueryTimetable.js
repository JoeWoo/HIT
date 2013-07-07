

var xmlhttp;
	if (window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}
	else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
var query = function(){
	for(var i=0; i<7; i++)
	for(var j=0; j<5; j++)
		document.getElementById(i+''+j).innerHTML="&nbsp;";
	var select = document.getElementById("term-input");
	var term = select.options[select.selectedIndex].value;
	xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
		    eval(xmlhttp.responseText);
		    }
		  };
		xmlhttp.open("GET","CourseListOfTeacher?Term="+term,true);
		xmlhttp.send();
}; 
var setCourse = function(id,value){
	var ele = document.getElementById(id);
	var info = value.split("#--#");
	//alert(ele.innerHTML);
	if(ele.innerHTML!="&nbsp;")
		ele.innerHTML += "<hr/>";
	ele.innerHTML += info[0]+"<br/>"+info[1]+"&nbsp;"+info[2]+"<br/>"+info[3]+"-"+info[4]+info[5];
	
};