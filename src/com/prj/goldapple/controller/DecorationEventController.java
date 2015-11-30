package com.prj.goldapple.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prj.goldapple.bean.AABB03A;
import com.prj.goldapple.service.IDecorationEventService;

@Controller
@RequestMapping("/decorationEvent/")
public class DecorationEventController {

	private IDecorationEventService decorationEventService;

	public IDecorationEventService getDecorationEventService() {
		return decorationEventService;
	}

	@Autowired
	public void setDecorationEventService(IDecorationEventService decorationEventService) {
		this.decorationEventService = decorationEventService;
	}

	@ResponseBody
	@RequestMapping("getJSON")
	public Map<String, Object> getJSON(String decorationEventId){

		return new HashMap<String, Object>();
	}
	
	@ResponseBody
	@RequestMapping("create")
	public Map<String, String> create(AABB03A aabb03a) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			aabb03a.setAABB03A010(UUID.randomUUID().toString());
			decorationEventService.create(aabb03a);
		} catch (Exception e) {
			map.put("result", "fail");
			return map;
		}
		map.put("result", "success");
		return map;
	}

	@ResponseBody
	@RequestMapping("delete")
	public Map<String, String> delete(String userId) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			decorationEventService.delete(userId);
		} catch (Exception e) {
			map.put("result", "fail");
			return map;
		}
		map.put("result", "success");
		return map;
	}

	@ResponseBody
	@RequestMapping("update")
	public Map<String, String> update(AABB03A aabb03a) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			decorationEventService.update(aabb03a);
		} catch (Exception e) {
			map.put("result", "fail");
			return map;
		}
		map.put("result", "success");
		return map;
	}

	@ResponseBody
	@RequestMapping("retrive")
	public AABB03A retrive(String userId) {
		AABB03A aabb03a = decorationEventService.retrieve(userId);
		return aabb03a;
	}

	@ResponseBody
	@RequestMapping("queryForList")
	public List<AABB03A> queryForList() {
		List<AABB03A> lst = decorationEventService.queryForList(null);
		return lst;
	}
}
