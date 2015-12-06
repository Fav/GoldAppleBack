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
import com.prj.goldapple.bean.AABB05A;
import com.prj.goldapple.service.IReservationInfoService;
import com.prj.util.CommonVar;

@Controller
@RequestMapping("/reservationInfo/")
public class ReservationInfoController {

	private IReservationInfoService reservationInfoService;

	public IReservationInfoService getReservationInfoService() {
		return reservationInfoService;
	}

	@Autowired
	public void setReservationInfoService(IReservationInfoService reservationInfoService) {
		this.reservationInfoService = reservationInfoService;
	}

	@ResponseBody
	@RequestMapping("getJSON")
	public Map<String, Object> getJSON(String reservationInfoId){

		return new HashMap<String, Object>();
	}
	
	@ResponseBody
	@RequestMapping("create")
	public Map<String, String> create(AABB05A aabb05a,AABB04A aabb04a) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			aabb05a.setAABB05A010(UUID.randomUUID().toString());
			reservationInfoService.create(aabb05a);
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
			reservationInfoService.delete(userId);
		} catch (Exception e) {
			map.put(CommonVar.RESULT, CommonVar.FAIL);
			return map;
		}
		map.put(CommonVar.RESULT, CommonVar.SUCCESS);
		return map;
	}

	@ResponseBody
	@RequestMapping("update")
	public Map<String, String> update(AABB05A aabb05a) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			reservationInfoService.update(aabb05a);
		} catch (Exception e) {
			map.put(CommonVar.RESULT, CommonVar.FAIL);
			return map;
		}
		map.put(CommonVar.RESULT, CommonVar.SUCCESS);
		return map;
	}

	@ResponseBody
	@RequestMapping("retrive")
	public AABB05A retrive(String userId) {
		AABB05A aabb05a = reservationInfoService.retrieve(userId);
		return aabb05a;
	}

	@ResponseBody
	@RequestMapping("queryForList")
	public List<AABB05A> queryForList() {
		List<AABB05A> lst = reservationInfoService.queryForList(null);
		return lst;
	}
}
