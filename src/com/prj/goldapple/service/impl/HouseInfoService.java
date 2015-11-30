package com.prj.goldapple.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.goldapple.bean.AABB04A;
import com.prj.goldapple.dao.HouseInfoDao;
import com.prj.goldapple.service.IHouseInfoService;

/***
 * 房屋信息
 * 
 * @author huqi
 * @date 2015/11/29 21:19:11
 * @version1.0
 */
@Service("houseInfoService")
public class HouseInfoService implements IHouseInfoService {
	private HouseInfoDao houseInfoDao;

	public HouseInfoDao getHouseInfoDao() {
		return houseInfoDao;
	}

	@Autowired
	public void setHouseInfoDao(HouseInfoDao houseInfoDao) {
		this.houseInfoDao = houseInfoDao;
	}
	/**
	 * @param params
	 * @return
	 */
	public AABB04A retrieve(String key){
		return houseInfoDao.retrieve(key);
	}
	/**
	 * @param obj
	 */
	 public int update(AABB04A obj){
		return houseInfoDao.update(obj);
	 }
	 /**
	 * @param obj
	 */
	 public int create(AABB04A obj){
		return houseInfoDao.create(obj);
	 }
	 /**
	  * @param key
	  */
	 public int delete(String key){
		return houseInfoDao.delete(key);
	 }
	/**
	 * 
	 * @param params
	 * @return
	 */
	public List<AABB04A>  queryForList(Map<String, Object> params) {
		return houseInfoDao.queryForList(params);
	}

}
