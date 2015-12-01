function emailRegiste() {
	var json = {};
	var temp = $('#AABB02A060').val();
	if (temp == null || temp == undefined ||temp =="") {
		return;
	}
	json.AABB02A060 = temp;
	temp = $('#AABB02A050').val();
	if (temp == null || temp == undefined ||temp =="") {
		return;
	}
	json.AABB02A050 = temp;
	json.AABB02A020 = 3;
	$.ajax({
     	type: "get",
		async: false,
     	url: "create.do",
     	data: json,
     	success:function(json){
     		if (json!=null && json !=""){
     			if (json.result == "success") {
     				top.user = json.abaa02a;
					alert("注册成功，请登录邮箱验证");
				}else{
					alert(json.result);
				}
     		 }
     	},
     	error:function(ex){
     		alert("注册失败");
     	}
     });
}