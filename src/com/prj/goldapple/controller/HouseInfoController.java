﻿package com.prj.goldapple.controller;

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
import com.prj.util.CommonVar;

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
			map.put(CommonVar.RESULT, CommonVar.FAIL);
			return map;
		}
		map.put(CommonVar.RESULT, CommonVar.SUCCESS);
		return map;
	}

	@ResponseBody
	@RequestMapping("delete")
	public Map<String, String> delete(String userId) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			houseInfoService.delete(userId);
		} catch (Exception e) {
			map.put(CommonVar.RESULT, CommonVar.FAIL);
			return map;
		}
		map.put(CommonVar.RESULT, CommonVar.SUCCESS);
		return map;
	}

	@ResponseBody
	@RequestMapping("update")
	public Map<String, String> update(AABB04A aabb04a) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			houseInfoService.update(aabb04a);
		} catch (Exception e) {
			map.put(CommonVar.RESULT, CommonVar.FAIL);
			return map;
		}
		map.put(CommonVar.RESULT, CommonVar.SUCCESS);
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
	public List<AABB04A> queryForList(HashMap map) {
		map.put("AABB04A010", "String");
		List<AABB04A> lst = houseInfoService.queryForList(map);
		return lst;
	}
	
	@ResponseBody
	@RequestMapping("queryByIdForList")
	public HashMap queryByIdForList(String id) {
	//	map.put("AABB04A010", "String");
		id = "001";
		HashMap lst = houseInfoService.queryByIdForList(id);
		return lst;
	}
}
