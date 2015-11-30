package com.prj.goldapple.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prj.goldapple.bean.AABB01A;
import com.prj.goldapple.service.IUserTypeService;
import com.prj.util.CommonVar;
import com.prj.util.SendEmail;

@Controller
@RequestMapping("/userType/")
public class UserTypeController {

	private IUserTypeService userTypeService;

	public IUserTypeService getUserTypeService() {
		return userTypeService;
	}

	@Autowired
	public void setUserTypeService(IUserTypeService userTypeService) {
		this.userTypeService = userTypeService;
	}

	@ResponseBody
	@RequestMapping("getJSON")
	public List<AABB01A> getJSON() {
		try {
			SendEmail.Test();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userTypeService.queryForList(null);
	}
}
