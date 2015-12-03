package com.prj.goldapple.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.omg.CORBA.DATA_CONVERSION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prj.goldapple.bean.AABB02A;
import com.prj.goldapple.service.IUserService;
import com.prj.util.CommonMethod;
import com.prj.util.CommonVar;
import com.prj.util.SendEmail;

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
	public Map<String, String> create(AABB02A aabb02a) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			String id = UUID.randomUUID().toString();
			aabb02a.setAABB02A010(id);
			aabb02a.setAABB02A020(3);
			String code = CommonMethod.getRandomString(6);
			//TODO:验证email是否已经注册
			aabb02a.setAABB02A080(code);//推荐码
			aabb02a.setAABB02A120(new Date().toString());		
			aabb02a.setAABB02A130(0);
			aabb02a.setAABB02A140(0);
			aabb02a.setAABB02A150(code);
			aabb02a.setAABB02A160(code);
			userService.create(aabb02a);
			//发邮件
			SendEmail.doSend(aabb02a.getAABB02A060(), id, code);

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
	public Map<String, String> verificationEmail(String u, String c) {
		Map<String, String> map = new HashMap<String, String>();
		String string = "";
		try {
			AABB02A aabb02a = userService.retrieve(u);
			// aabb02a.se
			if (aabb02a != null && aabb02a.getAABB02A150().equals(c)) {
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
	
	@ResponseBody
	@RequestMapping("login")
	public Map<String, String> login(AABB02A aabb02a) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		if (aabb02a == null) {
			map.put(CommonVar.RESULT, CommonVar.FAIL);
			return map;
		}
		//邮箱登录
		String email = aabb02a.getAABB02A060();
		if (email != null) {
			AABB02A temp = userService.queryByEmail(email);
			if (temp == null) {
				map.put(CommonVar.RESULT,"用户名不存在");
				return map;
			}
			if (!aabb02a.getAABB02A050().equals(temp.getAABB02A050())) {
				map.put(CommonVar.RESULT,"密码错误");
				return map;
			}
			aabb02a.setAABB02A010(temp.getAABB02A010());
		}
		//手机登录
		String phone = aabb02a.getAABB02A070();
		if (phone != null) {
			AABB02A temp = userService.queryByEmail(email);
			if (temp == null) {
				map.put(CommonVar.RESULT,"用户名不存在");
				return map;
			}
			if (!aabb02a.getAABB02A050().equals(temp.getAABB02A050())) {
				map.put(CommonVar.RESULT,"密码错误");
				return map;
			}
			aabb02a.setAABB02A010(temp.getAABB02A010());
		}
		
		map.put(CommonVar.RESULT, CommonVar.SUCCESS);
		map.put("uid", aabb02a.getAABB02A010());
		return map;
	}
}
