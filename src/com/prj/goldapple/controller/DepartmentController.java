package com.prj.goldapple.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.prj.goldapple.bean.DepartmentBean;
import com.prj.goldapple.service.IDepartmentService;

@Controller("departmentController")
@RequestMapping("/department/")
public class DepartmentController {

	@RequestMapping("getDepartmentList")
	public ModelAndView doGetDepartmentList(){
		
		ModelAndView mv = new ModelAndView();
		
		List<DepartmentBean> modelList = departmentService.doGetDepartmentList();
		mv.setViewName("index");
		
		
		return mv;
		
	}
	
	private IDepartmentService departmentService;

	public IDepartmentService getDepartmentService() {
		return departmentService;
	}

	@Autowired
	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
}
