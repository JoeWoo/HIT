var xmlhttp;
	if (window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}
	else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
var queryStudent = function(){
	var select = document.getElementById("dept-input");
	var Did = select.options[select.selectedIndex].value;
	select = document.getElementById("major-input");
	var Mid = select.options[select.selectedIndex].value;
	select = document.getElementById("year-input");
	var Syear = select.options[select.selectedIndex].value;
	select = document.getElementById("Sid-input");
	var Sid = select.options[select.selectedIndex].value;
	xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
		    document.getElementById("student_table").innerHTML=xmlhttp.responseText;
		    document.getElementById("dept-input-right").innerHTML = "<option value='nochoose'>-閺堫亪锟介幏锟�/option>"+xmlhttp.responseText;
		    }
		  }
		xmlhttp.open("GET","AdminQueryStudent?Did="+Did+"&Mid="+Mid+"&Syear="+Syear+"&Sid="+Sid,true);
		xmlhttp.send();
}
var edit = function(row){
	var line = document.getElementById(row);
	document.getElementById("Sid").value = line.cells[0].innerText;
	var select = document.getElementById("year-input");
	var Syear = select.options[select.selectedIndex].value;
	document.getElementById("Syear").value = Syear;
	document.getElementById("Semail").value = line.cells[6].innerText;
	var info = document.getElementById("info"+row).value;
	var result = info.split("#");
	document.getElementById("Stelephone").value = result[0];
	document.getElementById("Saddress").value = result[1];
	document.getElementById("Sclass").value = line.cells[5].innerText;
	document.getElementById("Ssex").value = line.cells[2].innerText;
	document.getElementById("Sname").value = line.cells[1].innerText;
	document.getElementById("Sbirthday").value = result[3];
	document.getElementById("SpersonID").value = result[2];
    var Did = line.cells[0].innerText[3]+line.cells[0].innerText[4];
    document.getElementById("Did").value=Did;
    var Mid = Did+line.cells[0].innerText[5];
    xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
		    document.getElementById("Mid").innerHTML="<option value='nochoose'>-鏈�鎷�</option>"+xmlhttp.responseText;
		    document.getElementById("Mid").value=Mid;  
		  }
		  }
	xmlhttp.open("GET","GetMajorOfDept?Did="+Did,true);
	xmlhttp.send();
}

var getSids = function(){
	var select = document.getElementById("major-input");
	var Mid = select.options[select.selectedIndex].value;
	var select = document.getElementById("year-input");
	var Syear = select.options[select.selectedIndex].value;
	xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
		    document.getElementById("student_table").innerHTML=xmlhttp.responseText;
		    document.getElementById("dept-input-right").innerHTML = "<option value='nochoose'>-閺堫亪锟介幏锟�/option>"+xmlhttp.responseText;
		    }
		  }
		xmlhttp.open("GET","GetSids?Mid="+Mid+"&Syear="+Syear+"&Sid="+Sid,true);
		xmlhttp.send();
}

var addStudent = function(){
	var Sid = document.getElementById("Sid").value;
	var Did = document.getElementById("Did").value;
	
	var Mid = document.getElementById("Mid").value;
	var Syear = document.getElementById("Syear").value;
	var Stelephone = document.getElementById("Stelephone").value;
	var Sclass = document.getElementById("Sclass").value;
	var Semail = document.getElementById("Semail").value;
	var Saddress = document.getElementById("Saddress").value;
	var Ssex = document.getElementById("Ssex").value;
	var Sname = document.getElementById("Sname").value;
	var Sbirthday = document.getElementById("Sbirthday").value;
	var SpersonID = document.getElementById("SpersonID").value;
	
	xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
		    alert("yes");
		    }
		  }
	
		xmlhttp.open("GET","AddStudents?Sid="+Sid+"&Syear="+Syear+"&Sname="+Sname+"&Ssex="+Ssex+"&Sbirthday="+Sbirthday+"&SpersonID="+SpersonID+"&Stelephone="+Stelephone+"&Sclass="+Sclass+"&Semail="+Semail+"&Saddress="+Saddress+"&Mid="+Mid+"&Did="+Did,true);
		xmlhttp.send();
}

var updateStudent = function(){
	var Sid = document.getElementById("Sid").value;
	var Did = document.getElementById("Did").value;
	
	var Mid = document.getElementById("Mid").value;
	var Syear = document.getElementById("Syear").value;
	var Stelephone = document.getElementById("Stelephone").value;
	var Sclass = document.getElementById("Sclass").value;
	var Semail = document.getElementById("Semail").value;
	var Saddress = document.getElementById("Saddress").value;
	var Ssex = document.getElementById("Ssex").value;
	var Sname = document.getElementById("Sname").value;
	var Sbirthday = document.getElementById("Sbirthday").value;
	var SpersonID = document.getElementById("SpersonID").value;
	
	xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
		    alert("yes");
		    }
		  }
	
		xmlhttp.open("GET","UpdateStudents?Sid="+Sid+"&Syear="+Syear+"&Sname="+Sname+"&Ssex="+Ssex+"&Sbirthday="+Sbirthday+"&SpersonID="+SpersonID+"&Stelephone="+Stelephone+"&Sclass="+Sclass+"&Semail="+Semail+"&Saddress="+Saddress+"&Mid="+Mid+"&Did="+Did,true);
		xmlhttp.send();
}