/**
	time:2015-12-4
	author:高义
	discribe:房屋信息展示
 */
(function(window) {
	var json = {};
	json.AABB04A010 = "001";
	$.ajax({
     	type: "get",
		async: false,
     	url: "queryForList.do",
     	data: json,
     	success:function(json){
     		if ($.isArray(json)){
     			$(".js-mianji").html(json[0]["aabb04A030"] + json[0]["aabb04A040"]+"平米");
     			$(".js-dizhi").html(json[0]["aabb04A050"] + json[0]["aabb04A060"]+json[0]["aabb04A070"]);
     			var huxing = json[0]["aabb04A110"].replace(",", " ");
     			$(".js-huxing").html(huxing);
     			$(".js-huxing").html(huxing);
     		 }
     	},
     	error:function(ex){
     		alert("注册失败");
     	}
     });
})(window);