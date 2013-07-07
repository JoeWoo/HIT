var xmlhttp;
var flag;
if (window.XMLHttpRequest){
	xmlhttp=new XMLHttpRequest();
}
else{
	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
}

var choose = function(id){
	if(!flag) return;
	xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
			  var button = document.getElementById(id+"_button");
			  button.setAttribute("onclick","cancelChoose("+id+")");
			  button.innerText = '取消选课';
			  var s = '<tr bgcolor="#C8D6FF" id="'+id+'_choosed">';
			  var node = document.getElementById(id);
			  document.getElementById("haschoosed").innerHTML+=s+node.innerHTML+"</tr>";
			  node = document.getElementById(id+"_choosed");
			  var tmp = node.getElementsByTagName("a")[1];
			  //alert(tmp.parentNode.parentNode.innerHTML);
			  //alert(tmp.innerHTML);
			  tmp.setAttribute("id",id+'choosed_button');
			  //tmp.id = id+'_choosed_button';
			  
		    }
		  };
		xmlhttp.open("GET","ChooseCourse?Tempid="+id,true);
		xmlhttp.send();
};

var cancelChoose = function(id){
	xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
			  var button = document.getElementById(id+"_button");
			  node = document.getElementById(id+"_choosed");
			  //alert(node.parentNode.parentNode);
			  node.parentNode.removeChild(node);
			  button.setAttribute("onclick","choose("+id+")");
			  button.innerText = '选课';
			  //var tmp = node.getElementsByTagName("a")[1];			  
		    }
		  };
		xmlhttp.open("GET","CancelChooseCourse?tempid="+id+"&sid="+document.getElementById("sid").value,true);
		xmlhttp.send();
	
};

var init = function(){
	var table = document.getElementById("haschoosed");
	if(table==null) return;
	var tmp = table.getElementsByTagName("tr");
	var n = tmp.length;
	for(var i=1; i<n; i++){
		var node = document.getElementById(tmp[i].id.split('_')[0]);
		//var node = document.getElementById(id);
		if(!node) continue;
		var id = node.id;
		var button = document.getElementById(id+"_button");
		  button.setAttribute("onclick","cancelChoose("+id+")");
		  button.innerText = '取消选课';
	}
};

var judgeCanChoose = function(type){
	var table = document.getElementById("haschoosed");
	if(table==null) return false;
	var tmp = table.getElementsByTagName("tr");
	var n = tmp.length;
	if(type==2&&n<3) return true;
	if(type==3&&n<2) return true;
	if(type==4&&n<2) return true;
	return false;
};

var beforeChoose = function(type){
	flag = judgeCanChoose(type);
	if(!flag) alert('选课数量已到上线');
};