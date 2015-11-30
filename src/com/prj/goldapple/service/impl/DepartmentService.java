package com.prj.goldapple.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.goldapple.bean.DepartmentBean;
import com.prj.goldapple.dao.DepartmentDao;
import com.prj.goldapple.service.IDepartmentService;

@Service("departmentService")
public class DepartmentService implements IDepartmentService{

	public List<DepartmentBean> doGetDepartmentList() {
		return departmentDao.doGetDepartmentList();
	}

	private DepartmentDao departmentDao;

	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	@Autowired
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	
}
