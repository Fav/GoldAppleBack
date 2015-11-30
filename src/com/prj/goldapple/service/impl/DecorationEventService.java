package com.prj.goldapple.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.goldapple.bean.AABB03A;
import com.prj.goldapple.dao.DecorationEventDao;
import com.prj.goldapple.service.IDecorationEventService;

/***
 * 装修事件
 * 
 * @author huqi
 * @date 2015/11/29 21:19:12
 * @version1.0
 */
@Service("decorationEventService")
public class DecorationEventService implements IDecorationEventService {
	private DecorationEventDao decorationEventDao;

	public DecorationEventDao getDecorationEventDao() {
		return decorationEventDao;
	}

	@Autowired
	public void setDecorationEventDao(DecorationEventDao decorationEventDao) {
		this.decorationEventDao = decorationEventDao;
	}
	/**
	 * @param params
	 * @return
	 */
	public AABB03A retrieve(String key){
		return decorationEventDao.retrieve(key);
	}
	/**
	 * @param obj
	 */
	 public int update(AABB03A obj){
		return decorationEventDao.update(obj);
	 }
	 /**
	 * @param obj
	 */
	 public int create(AABB03A obj){
		return decorationEventDao.create(obj);
	 }
	 /**
	  * @param key
	  */
	 public int delete(String key){
		return decorationEventDao.delete(key);
	 }
	/**
	 * 
	 * @param params
	 * @return
	 */
	public List<AABB03A>  queryForList(Map<String, Object> params) {
		return decorationEventDao.queryForList(params);
	}

}
