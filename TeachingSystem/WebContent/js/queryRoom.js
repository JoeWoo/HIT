var xmlhttp;
	if (window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}
	else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	var changeColor	=function (id){
		var container = document.getElementById(id);
		container.style.background="red";
		container.style.color = "red";
		container.innerHTML="�п�";
	} 
	var changeBackColor=function(id){
		var container = document.getElementById(id);
		if(container!=null){   
			container.style.background="white";
			container.innerHTML="";
		}
	}
var initRoomInput = function(){
	
	xmlhttp.onreadystatechange=function(){
	  if (xmlhttp.readyState==4 && xmlhttp.status==200){
	    document.getElementById("room-input").innerHTML=xmlhttp.responseText;
	    }
	  }
	xmlhttp.open("GET","ajax/room.txt",true);
	xmlhttp.send();
}
var init = function(){
	var x = new Array(7);
	for(var i=0; i<x.length; i++)
		x[i] = new Array(5);
	for(var i=0; i<7; i++)
		for(var j=0; j<5; j++){
			x[i][j] = ""+i+j;
			var ele = document.getElementById(x[i][j]);
			ele.setAttribute("onclick","queryRoom('"+x[i][j]+"')");
		}
}
var queryRoom = function(id){
	var ele = document.getElementById(id);
	if(ele.style.background=="red"){
		var classroom = document.getElementById("room-input");
		getCourse(id,classroom.options[classroom.selectedIndex].value);
	}	
}
var queryCourse = function(){
	var week0 = document.getElementById("week-input");
	var week = week0.options[week0.selectedIndex].value;
	var rname0 = document.getElementById("room-input");
	var rname = rname0.options[rname0.selectedIndex].value;
	xmlhttp.onreadystatechange=function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			var result = document.getElementById("data").value.split("#");
			for(var i=0; i<result.length; i++)
				changeBackColor(result[i]);
			document.getElementById("data").value = xmlhttp.responseText;
			
			result = xmlhttp.responseText.split("#");
			for(var i=0; i<result.length; i++)
			{
				changeColor(result[i]);
			}

		}
	}
	xmlhttp.open("GET","HasCourse?Cweek="+week+"&Rname="+rname,true);
	xmlhttp.send();
}
var getResult=function(){
	var result = document.getElementById("data").value.split("#");
	for(var i=0; i<result.length; i++)
	{
		//alert(result.length+" i="+i);
		//alert(result[i]);
		changeColor(result[i]);
	}
}
var getCourse = function(id,classroomvalue){
	var select = document.getElementById("week-input");
	var week = select.options[select.selectedIndex].value;
	xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
		   // alert(xmlhttp.responseText);
			  var result = xmlhttp.responseText.split("#");
			  var ele = document.getElementById("Cname");
			  ele.innerHTML = result[0];
			  ele = document.getElementById("Cid");
			  ele.innerHTML = result[1];
			  ele = document.getElementById("Ccredit");
			  ele.innerHTML = result[2];
			  ele = document.getElementById("Chour");
			  ele.innerHTML = result[3];
			  ele = document.getElementById("Tid");
			  ele.innerHTML += result[4];
			  ele = document.getElementById("Tname");
			  ele.innerHTML += result[5];
			  ele = document.getElementById("Ttitle");
			  ele.innerHTML += result[6];
			  ele = document.getElementById("Ttelephone");
			  ele.innerHTML += result[7];
			  ele = document.getElementById("Temail");
			  ele.innerHTML += result[8];
			//  alert(result[4]);
		    }
		  }
	//alert(classroomvalue);
	
		xmlhttp.open("GET","courseAjax?day="+id[0]+"&num="+id[1]+"&classroom="+classroomvalue+"&week="+week,true);
		xmlhttp.send();
}