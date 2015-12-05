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
     	url: "queryByIdForList.do",
     	data: json,
     	success:function(json){
     		if (json){
     			$(".js-mianji").html(json["AABB04A030"] + json["AABB04A040"]+"平米");
     			$(".js-dizhi").html(json["AABB04A050"] + json["AABB04A060"]+json["AABB04A070"]);
     			var huxing = json["AABB04A110"].replace(",", " ");
                    var taican = json["AABB03A030"];
     			$(".js-huxing").html(huxing);
     			$(".js-taican").html(taican);
     		 }
     	},
     	error:function(ex){
     		alert("注册失败");
     	}
     });
})(window);