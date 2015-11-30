package com.prj.goldapple.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.goldapple.bean.AABB02A;
import com.prj.goldapple.dao.UserDao;
import com.prj.goldapple.service.IUserService;

/***
 * 用户
 * 
 * @author huqi
 * @date 2015/11/26 17:02:36
 * @version1.0
 */
@Service("userService")
public class UserService implements IUserService {
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	/**
	 * @param params
	 * @return
	 */
	public AABB02A retrieve(String key){
		return userDao.retrieve(key);
	}
	/**
	 * @param obj
	 */
	 public int update(AABB02A obj){
		return userDao.update(obj);
	 }
	 /**
	 * @param obj
	 */
	 public int create(AABB02A obj){
		return userDao.create(obj);
	 }
	 /**
	  * @param key
	  */
	 public int delete(String key){
		return userDao.delete(key);
	 }
	 /**
	  * @param list
	  */
	 public void deleteAll(List list){
		 for(int i=0;i<list.size();i++){
			 AABB02A obj = (AABB02A)list.get(i);
			 userDao.delete(obj.getAABB02A010());
		 }
	 }
	/**
	 * 
	 * @param params
	 * @return
	 */
	public List<AABB02A>  queryForList(Map<String, Object> params) {
		return userDao.queryForList(params);
	}

}
