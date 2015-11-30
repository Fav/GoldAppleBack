package com.prj.goldapple.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.prj.goldapple.bean.EmpBean;
import com.prj.goldapple.service.IEmpService;

@Controller
@RequestMapping("/emp/")
public class EmpController {

	private IEmpService empService;

	public IEmpService getEmpService() {
		return empService;
	}

	@Autowired
	public void setEmpService(IEmpService empService) {
		this.empService = empService;
	}
	
	@RequestMapping("doInsertEmp")
	public ModelAndView doInsertEmp(@ModelAttribute EmpBean empBean){
		
		int rc = empService.doInsertEmp(empBean);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");

		mv.addObject("stack", "doInsertEmp->"+rc);
		
		return mv;
	}
	
	@RequestMapping("doInsertEmpSelective")
	public ModelAndView doInsertEmpSelective(@ModelAttribute EmpBean empBean){
		
		int rc = empService.doInsertEmpSelective(empBean);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("stack", "doInsertEmpSelective->"+rc);
		
		return mv;
		
	}
	
	@RequestMapping("doDeleteEmpById")
	public ModelAndView doDeleteEmpById(@RequestParam String empId){
		empService.doDeleteEmpById(Integer.parseInt(empId));
		List<EmpBean> empList = empService.doGetEmpList();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view/emp/emplist");
		mv.addObject("modelList", empList);
		return mv;
	}
	
	@RequestMapping("doGetEmpList")
	public ModelAndView doGetEmpList(){
		List<EmpBean> empList = empService.doGetEmpList();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view/emp/emplist");
		mv.addObject("modelList", empList);
		return mv;
	}
	
	@RequestMapping("doGetEmpById")
	public ModelAndView doGetEmpById(@RequestParam String empId){
		ModelAndView mv = new ModelAndView();
		EmpBean empBean = empService.doGetEmpById(Integer.parseInt(empId));
		mv.setViewName("view/emp/empupdate");
		mv.addObject("model", empBean);
		return mv;
	}
	@ResponseBody
	@RequestMapping("getJSON")
	public Map<String, Object> getJSON(){
		List<EmpBean> empList = empService.doGetEmpList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("a", 100);
		map.put("value", empList);
		return map;
	}
}
