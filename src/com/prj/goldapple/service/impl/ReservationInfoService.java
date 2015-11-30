package com.prj.goldapple.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.goldapple.bean.AABB05A;
import com.prj.goldapple.dao.ReservationInfoDao;
import com.prj.goldapple.service.IReservationInfoService;

/***
 * create table  AABB05A
 * 
 * @author huqi
 * @date 2015/11/29 21:19:12
 * @version1.0
 */
@Service("reservationInfoService")
public class ReservationInfoService implements IReservationInfoService {
	private ReservationInfoDao reservationInfoDao;

	public ReservationInfoDao getReservationInfoDao() {
		return reservationInfoDao;
	}

	@Autowired
	public void setReservationInfoDao(ReservationInfoDao reservationInfoDao) {
		this.reservationInfoDao = reservationInfoDao;
	}
	/**
	 * @param params
	 * @return
	 */
	public AABB05A retrieve(String key){
		return reservationInfoDao.retrieve(key);
	}
	/**
	 * @param obj
	 */
	 public int update(AABB05A obj){
		return reservationInfoDao.update(obj);
	 }
	 /**
	 * @param obj
	 */
	 public int create(AABB05A obj){
		return reservationInfoDao.create(obj);
	 }
	 /**
	  * @param key
	  */
	 public int delete(String key){
		return reservationInfoDao.delete(key);
	 }
	/**
	 * 
	 * @param params
	 * @return
	 */
	public List<AABB05A>  queryForList(Map<String, Object> params) {
		return reservationInfoDao.queryForList(params);
	}

}
