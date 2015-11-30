package com.prj.goldapple.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.goldapple.bean.AABB01A;
import com.prj.goldapple.dao.UserTypeDao;
import com.prj.goldapple.service.IUserTypeService;

/***
 * 用户类型表
 * 
 * @author huqi
 * @date 2015/11/29 11:29:39
 * @version1.0
 */
@Service("userTypeService")
public class UserTypeService implements IUserTypeService {
	private UserTypeDao userTypeDao;

	public UserTypeDao getUserTypeDao() {
		return userTypeDao;
	}

	@Autowired
	public void setUserTypeDao(UserTypeDao userTypeDao) {
		this.userTypeDao = userTypeDao;
	}
	/**
	 * @param params
	 * @return
	 */
	public AABB01A retrieve(String key){
		return userTypeDao.retrieve(key);
	}
	/**
	 * @param obj
	 */
	 public int update(AABB01A obj){
		return userTypeDao.update(obj);
	 }
	 /**
	 * @param obj
	 */
	 public int create(AABB01A obj){
		return userTypeDao.create(obj);
	 }
	 /**
	  * @param key
	  */
	 public int delete(String key){
		return userTypeDao.delete(key);
	 }
	/**
	 * 
	 * @param params
	 * @return
	 */
	public List<AABB01A>  queryForList(Map<String, Object> params) {
		return userTypeDao.queryForList(params);
	}

}
