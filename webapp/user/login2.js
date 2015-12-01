$(function(){

});

function login() {
	var json = {};
	json.AABB02A060 = $('#username').val();
	json.AABB02A050 = $('#pwd').val();
	json.AABB02A020 = 3;
	$.ajax({
     	type: "get",
		async: false,
     	url: "login.do",
     	data: json,
     	success:function(json){
     		if (json!=null && json !=""){
     			if (json.result == "success") {
     				top.user = json.abaa02a;
					alert("登录成功");
					top.location='../index.html'; 
				}else{
					alert(json.result);
				}
     		 }
     	},
     	error:function(ex){
     		alert("登录失败");
     	}
     });
}