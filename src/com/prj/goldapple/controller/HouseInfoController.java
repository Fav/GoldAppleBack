package com.prj.goldapple.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prj.goldapple.bean.AABB04A;
import com.prj.goldapple.service.IHouseInfoService;

@Controller
@RequestMapping("/houseInfo/")
public class HouseInfoController {

	private IHouseInfoService houseInfoService;

	public IHouseInfoService getHouseInfoService() {
		return houseInfoService;
	}

	@Autowired
	public void setHouseInfoService(IHouseInfoService houseInfoService) {
		this.houseInfoService = houseInfoService;
	}

	@ResponseBody
	@RequestMapping("getJSON")
	public Map<String, Object> getJSON(String houseInfoId){

		return new HashMap<String, Object>();
	}
	
	@ResponseBody
	@RequestMapping("create")
	public Map<String, String> create(AABB04A aabb04a) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			aabb04a.setAABB04A010(UUID.randomUUID().toString());
			houseInfoService.create(aabb04a);
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
			houseInfoService.delete(userId);
		} catch (Exception e) {
			map.put("result", "fail");
			return map;
		}
		map.put("result", "success");
		return map;
	}

	@ResponseBody
	@RequestMapping("update")
	public Map<String, String> update(AABB04A aabb04a) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			houseInfoService.update(aabb04a);
		} catch (Exception e) {
			map.put("result", "fail");
			return map;
		}
		map.put("result", "success");
		return map;
	}

	@ResponseBody
	@RequestMapping("retrive")
	public AABB04A retrive(String userId) {
		AABB04A aabb04a = houseInfoService.retrieve(userId);
		return aabb04a;
	}

	@ResponseBody
	@RequestMapping("queryForList")
	public List<AABB04A> queryForList() {
		List<AABB04A> lst = houseInfoService.queryForList(null);
		return lst;
	}
}
