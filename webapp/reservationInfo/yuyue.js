/**
	2015-12-6
  */
(function(window) {
	$("#lijiyuyue").on("click",function() {
		//称呼
	var  chenghu = $(".chenghu").val();
	var telephone = $(".telephone").val();
	var mianji = $(".mianji").val();
	var yuyueshi = $(".yuyue-shi").val();
	var qu = $(".yuyue-qu").val();
	var xiaoqu = $(".yuyue-xiaoqu").val();
	var wushi = $(".yuyue-wushi").val();
	var ting = $(".yuyue-ting").val();
	var wei = $(".yuyue-wei").val();
	var chufang = $(".yuyue-chufang").val();
	var yangtai = $(".yuyue-yangtai").val();
	var zxfg = $("input[name='yuyue-zxfg']:checked").val();
	var yqm  = $(".yuyue-yaoqingma").val();

	var json = {};
	json.AABB04A010 = "001";
	json.AABB05A020 = "001";
	json.AABB05A030 = yuyueshi + "市;"+qu+"区;"+xiaoqu+"小区;-"+wushi+"-"+ting+"-"+wei+"-"+chufang+"-"+yangtai;
	json.AABB05A040 = chenghu;
	json.AABB05A050 = telephone;
	json.AABB05A060 = zxfg;
	json.AABB05A070 = yqm;
	$.ajax({
     	type: "get",
		async: false,
     	url: "create.do",
     	data: json,
     	success:function(json){
     		if (json && json.result) {
     			alert("预约成功");
     		 }
     	},
     	error:function(ex){
     		alert("预约失败");
     	}
     });
	});
	
})(window);