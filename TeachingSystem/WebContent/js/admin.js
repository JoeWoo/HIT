var xmlhttp;
	if (window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}
	else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
var init_page = function(Did){
	//alert('zz');
	if(Did!="00"){
		var right = document.getElementById("right");
		if(right)
		right.style.display = "none";
	}
	
	xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
		    document.getElementById("dept-input").innerHTML="<option value='nochoose'>-未选择-</option>"+xmlhttp.responseText;
		    if(document.getElementById("Did")!=null){ 
		    document.getElementById("Did").innerHTML="<option value='nochoose'>-未选择-</option>"+xmlhttp.responseText;
		  }
		    if(document.getElementById("dept-input-right")!=null)
		    document.getElementById("dept-input-right").innerHTML = "<option value='nochoose'>-未选择-</option>"+xmlhttp.responseText;
		    }
		 // alert('zz');
		  };
		xmlhttp.open("GET","GetDept?Did="+Did,true);
		xmlhttp.send();
};

var getMajor = function(flag){
	var select;
	if(flag==0)
	select = document.getElementById("dept-input");
	else select = document.getElementById("dept-input-right");
	var Did = select.options[select.selectedIndex].value;
		xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
			  if(flag==0)
		    document.getElementById("major-input").innerHTML="<option value='nochoose'>-未选择-</option>"+xmlhttp.responseText;
			  else 
				  document.getElementById("major-input-right").innerHTML=xmlhttp.responseText; 
		    }
		  };
		xmlhttp.open("GET","GetMajorOfDept?Did="+Did,true);
		xmlhttp.send();
};
var getMajor2 = function(flag){
	var select;
	if(flag==0)
	select = document.getElementById("Did");
	else select = document.getElementById("dept-input-right");
	var Did = select.options[select.selectedIndex].value;
		xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
			  if(flag==0)
		    document.getElementById("Mid").innerHTML="<option value='nochoose'>-未选择-</option>"+xmlhttp.responseText;
			  else 
				  document.getElementById("dept-input-right").innerHTML=xmlhttp.responseText; 
		    }
		  };
		xmlhttp.open("GET","GetMajorOfDept?Did="+Did,true);
		xmlhttp.send();
};
var addCourse = function(){
	var Cid = document.getElementById("Cid").value;
	var Cname = document.getElementById("Cname").value;
	Cname = Cname.replace(/\+/g,'＋');
	var Ccredit = document.getElementById("Ccredit").value;
	var Chour = document.getElementById("Chour").value;
	var Teacher = document.getElementById("Teacher").value;
	var select = document.getElementById("dept-input-right");
	var Dept = select.options[select.selectedIndex].value;
	select = document.getElementById("major-input-right");
	var Major = select.options[select.selectedIndex].value;
	select = document.getElementById("Ctype");
	var Ctype = select.options[select.selectedIndex].value;
	select = document.getElementById("Cproperty");
	var Cproperty = select.options[select.selectedIndex].value;
	select = document.getElementById("term-input-right");
	var Term = select.options[select.selectedIndex].value;
	select = document.getElementById("syear-input-right");
	var Syear = select.options[select.selectedIndex].value;
	xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
			  alert("添加成功!");
		    }
		  };
		xmlhttp.open("GET","AddCourse?Cname="+Cname+"&Ccredit="+Ccredit+"&Chour="+Chour+"&Teacher="+Teacher
				+"&Major="+Major+"&Ctype="+Ctype+"&Cproperty="+Cproperty+"&Term="+Term+"&Cid="+Cid+"&Syear="+Syear,true);
		xmlhttp.send();
};
var updateCourse = function(){
	var Cid = document.getElementById("Cid").value;
	var Cname = document.getElementById("Cname").value;
	Cname = Cname.replace(/\+/g,'＋');
	var Ccredit = document.getElementById("Ccredit").value;
	var Chour = document.getElementById("Chour").value;
	var Teacher = document.getElementById("Teacher").value;
	var select = document.getElementById("dept-input-right");
	var Dept = select.options[select.selectedIndex].value;
	select = document.getElementById("major-input-right");
	var Major = select.options[select.selectedIndex].value;
	select = document.getElementById("Ctype");
	var Ctype = select.options[select.selectedIndex].value;
	select = document.getElementById("Cproperty");
	var Cproperty = select.options[select.selectedIndex].value;
	select = document.getElementById("term-input-right");
	var Tempid = document.getElementById("Tempid").value; 
	var Term = select.options[select.selectedIndex].value;
	select = document.getElementById("syear-input-right");
	var Syear = select.options[select.selectedIndex].value;
	xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
			  alert("更新成功!");
		    }
		  };
		  var url = URLEncode("UpdateCourse?"+"Ccredit="+Ccredit+"&Chour="+Chour+"&Teacher="+Teacher
					+"&Major="+Major+"&Ctype="+Ctype+"&Cproperty="+Cproperty+"&Term="+Term+"&Cid="+Cid+"&Tempid="+Tempid+"&Syear="+Syear+"&Cname='"+Cname+"'");
		xmlhttp.open("GET",url,true);
		xmlhttp.send();
};
var queryCourse = function(){
	var select = document.getElementById("style-input");
	var ctype = select.options[select.selectedIndex].value;
	select = document.getElementById("dept-input");
	var did = select.options[select.selectedIndex].value;
	select = document.getElementById("major-input");
	var mid = select.options[select.selectedIndex].value;
	select = document.getElementById("term-input");
	var term = select.options[select.selectedIndex].value;
	xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
			  var content = document.getElementById("course_table");
			  content.innerHTML = xmlhttp.responseText;
		    }
		  };
		xmlhttp.open("GET","AdminQueryCourse?Ctype="+ctype
				+"&Mid="+mid+"&Term="+term+"&Did="+did,true);
		xmlhttp.send();
};

var edit = function(row){
	var line = document.getElementById(row);
	var Cid=document.getElementById("Cid");
	var Cname=document.getElementById("Cname");
	var Ccredit=document.getElementById("Ccredit");
	var Chour=document.getElementById("Chour");
	var Cproperty=document.getElementById("Cproperty");
	Cid.value = line.cells[0].innerText;
	Cid.readOnly=true;
	
	Cname.value = line.cells[1].innerText;
	Ccredit.value = line.cells[7].innerText;
	Cproperty.value = line.cells[8].innerText;
	Chour.value = line.cells[6].innerText;
	var infos = document.getElementById("info"+row).value;
	//alert(infos);
	var result = infos.split("#");
	document.getElementById("Teacher").value = result[0];
	document.getElementById("Teacher").style.borderColor="blue";
	document.getElementById("Ctype").value = result[1];//value = result[1];
	document.getElementById("dept-input-right").value = result[2];
	document.getElementById("dept-input-right").style.borderColor="blue";
	getMajor(1);
	document.getElementById("major-input-right").value = result[3];
	document.getElementById("syear-input-right").value = result[5];
	document.getElementById("major-input-right").style.borderColor="blue";
	document.getElementById("term-input-right").style.borderColor="blue";
	document.getElementById("syear-input-right").style.borderColor="blue";
	document.getElementById("Tempid").value=result[4];
	//alert(result[1]);
	
};

