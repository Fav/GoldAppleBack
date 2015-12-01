package com.prj.goldapple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prj.goldapple.service.IUserTypeService;

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
}
