package com.prj.goldapple.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prj.goldapple.bean.AABB02A;
import com.prj.goldapple.service.IUserService;
import com.prj.util.CommonVar;

@Controller
@RequestMapping("/user/")
public class UserController {

	private IUserService userService;

	public IUserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@ResponseBody
	@RequestMapping("create")
	public Map<String, String> create(AABB02A aabb02a1) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			AABB02A aabb02a = new AABB02A();
			aabb02a.setAABB02A010(UUID.randomUUID().toString());
			userService.create(aabb02a);
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
			userService.delete(userId);
		} catch (Exception e) {
			map.put(CommonVar.RESULT, CommonVar.FAIL);
			return map;
		}
		map.put(CommonVar.RESULT, CommonVar.SUCCESS);
		return map;
	}

	@ResponseBody
	@RequestMapping("update")
	public Map<String, String> update(AABB02A aabb02a) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			userService.update(aabb02a);
		} catch (Exception e) {
			map.put(CommonVar.RESULT, CommonVar.FAIL);
			return map;
		}
		map.put(CommonVar.RESULT, CommonVar.SUCCESS);
		return map;
	}

	@ResponseBody
	@RequestMapping("retrive")
	public AABB02A retrive(String userId) {
		AABB02A aabb02a = userService.retrieve(userId);
		return aabb02a;
	}

	@ResponseBody
	@RequestMapping("queryForList")
	public List<AABB02A> queryForList() {
		List<AABB02A> lst = userService.queryForList(null);
		return lst;
	}

	@ResponseBody
	@RequestMapping("queryByEmail")
	public AABB02A queryByEmail(String email) {
		AABB02A aabb02a = userService.queryByEmail(email);
		return aabb02a;
	}

	@ResponseBody
	@RequestMapping("queryByPhone")
	public AABB02A queryByPhone(String phone) {
		AABB02A aabb02a = userService.queryByPhone(phone);
		return aabb02a;
	}

	@ResponseBody
	@RequestMapping("verificationEmail")
	public Map<String, String> verificationEmail(String userId, String code) {
		Map<String, String> map = new HashMap<String, String>();
		String string = "";
		try {
			AABB02A aabb02a = userService.retrieve(userId);
			// aabb02a.se
			if (aabb02a != null && aabb02a.getAABB02A150() == code) {
				aabb02a.setAABB02A130(1);
				userService.update(aabb02a);
				string = CommonVar.SUCCESS;
			} else {
				string = CommonVar.FAIL;
			}
		} catch (Exception e) {
			string = CommonVar.FAIL;
		}
		map.put(CommonVar.RESULT, string);
		return map;
	}

	@ResponseBody
	@RequestMapping("addEmail")
	public List<String> Test() throws Exception {
		return new ArrayList<String>();
	}
}
