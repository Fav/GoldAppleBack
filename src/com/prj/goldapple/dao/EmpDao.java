package com.prj.goldapple.dao;

import java.util.List;

import com.prj.goldapple.bean.EmpBean;

public interface EmpDao {

	int doInsertEmp(EmpBean empBean);
	
	int doInsertEmpSelective(EmpBean empBean);
	
	int doDeleteEmpById(Integer empId);
	
	List<EmpBean> doGetEmpList();
	
	EmpBean doGetEmpById(Integer empId);
}
