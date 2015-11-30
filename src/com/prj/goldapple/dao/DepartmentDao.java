package com.prj.goldapple.dao;

import java.util.List;

import com.prj.goldapple.bean.DepartmentBean;

public interface DepartmentDao {

	List<DepartmentBean> doGetDepartmentList();
	
}
