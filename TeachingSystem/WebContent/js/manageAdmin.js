
var xmlhttp;
	if (window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}
	else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
var getAdmins = function(){
	var select = document.getElementById("dept-input");
	var Did = select.options[select.selectedIndex].value;
	xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
		    document.getElementById("admin-input").innerHTML="<option value='nochoose'>-未选择-</option>"+xmlhttp.responseText;
		    }
		  };
		xmlhttp.open("GET","GetAdminOfDept?Did="+Did,true);
		xmlhttp.send();
};
var getTids = function(){
	var select = document.getElementById("dept-input");
	var Did = select.options[select.selectedIndex].value;
	xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
		    document.getElementById("teacher-input").innerHTML="<option value='nochoose'>-未选择-/option>"+xmlhttp.responseText;
		    }
		  };
		xmlhttp.open("GET","GetTids?Did="+Did,true);
		xmlhttp.send();
};

var queryTeacher = function(){
	
	var select = document.getElementById("dept-input");
	var Did = select.options[select.selectedIndex].value;
	select = document.getElementById("teacher-input");
	var Tid = select.options[select.selectedIndex].value;
	xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
		    document.getElementById("teacher-table").innerHTML=xmlhttp.responseText;
		    }
		  };
		xmlhttp.open("GET","AdminQueryTeacher?Did="+Did+"&Tid="+Tid,true);
		xmlhttp.send();
};


var edit1 = function(row){
	var line = document.getElementById(row);
	var info = document.getElementById("info"+row).value;
	var result = info.split("#");
	
	document.getElementById("Aname").value = line.cells[1].innerText;
	document.getElementById("Asex").value = line.cells[2].innerText;
	document.getElementById("Abirthday").value = result[0];
	document.getElementById("ApersonID").value = result[1];
	document.getElementById("Aid").value = line.cells[0].innerText;
	document.getElementById("dept-input-right").value = result[2];
	document.getElementById("Atelephone").value = line.cells[4].innerText;
	document.getElementById("Aemail").value = line.cells[5].innerText;
};

var addAdmin = function(){
	var Aname = document.getElementById("Aname").value;
	var Asex = document.getElementById("Asex").value;
	var Abirthday = document.getElementById("Abirthday").value;
	var ApersonID = document.getElementById("ApersonID").value;
	var Aid = document.getElementById("Aid").value;
	select = document.getElementById("dept-input-right");
	var did = select.options[select.selectedIndex].value;
	var Atelephone = document.getElementById("Atelephone").value;
	var Aemail = document.getElementById("Aemail").value;
	xmlhttp.onreadystatechange=function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			alert("添加成功");
			//document.getElementById("teacher-table").innerHTML=xmlhttp.responseText;
		}
	};
	xmlhttp.open("GET","AddAdmin?name="+Aname+"&Aid="+Aid+"&sex="+Asex+"&bir="+Abirthday
			+"&personid="+ApersonID+"&Did="+did+"&tel="+Atelephone+"&email="+Aemail,true);
	xmlhttp.send();
};
var updateAdmin = function(){
	var Aname = document.getElementById("Aname").value;
	var Asex = document.getElementById("Asex").value;
	var Abirthday = document.getElementById("Abirthday").value;
	var ApersonID = document.getElementById("ApersonID").value;
	var Aid = document.getElementById("Aid").value;
	//var dname = document.getElementById("Dname").value;
	select = document.getElementById("dept-input-right");
	var Did = select.options[select.selectedIndex].value;
//	var ttitle = document.getElementById("Ttitle").value;
	var Atelephone = document.getElementById("Atelephone").value;
	var Aemail = document.getElementById("Aemail").value;
	xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
		    alert("yes");
		    }
		  }
	xmlhttp.open("GET","UpdateAdmin?Did="+Did+"&Aname="+Aname+"&Asex="+Asex+"&Abirthday="+Abirthday+"&ApersonID="+ApersonID+"&Atelephone="+Atelephone+"&Aid="+Aid+"&Aemail="+Aemail,true);
	xmlhttp.send();
}
var queryAdmin = function(){
	var did,aid;
	var select = document.getElementById("dept-input");
	did = select.options[select.selectedIndex].value;
	if(did!="nochoose"){
		select = document.getElementById("admin-input");
		aid = select.options[select.selectedIndex].value;
		if(aid=="nochoose") aid="00";
	}
	else{
		did = "00";
		aid = "00";
	}
	xmlhttp.onreadystatechange=function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			document.getElementById("admin-table").innerHTML=xmlhttp.responseText;
		}
	};
	xmlhttp.open("GET","GetAdmin?did="+did+"&aid="+aid,true);
	xmlhttp.send();
};