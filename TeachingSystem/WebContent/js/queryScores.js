var xmlhttp;
	if (window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}
	else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
var Sid;
var init = function(id){
	Sid = id;
	//alert(Sid);
}
var queryScoreList = function(){
	var select = document.getElementById("term-input");
	var Term = select.options[select.selectedIndex].value;
	//alert(Term);
	var flag = 0;
	var info="";
	if(Term=="all"){
		flag = 1;
		for(var i=1; i<select.options.length; i++)
			if(i>1) info+="AAA"+select.options[i].value;
			else info=select.options[i].value;
	} else info = Term;
	//alert(info);
	xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
			  document.getElementById("score-input").innerHTML = xmlhttp.responseText;
		    }
		  }
		xmlhttp.open("GET","GetScores?flag="+flag+"&info="+info+"&Sid="+Sid,true);
		xmlhttp.send();
	
}