package com.prj.goldapple.service;

import java.util.List;
import java.util.Map;

import com.prj.goldapple.bean.AABB05A;

/***
 * create table  AABB05A
 * 
 * @author huqi
 * @date 2015/11/29 21:19:12
 * @version1.0
 */
public interface IReservationInfoService {
    public abstract int create(AABB05A record);
    	    
    public abstract int delete(String key);
    	    
    public abstract AABB05A retrieve(String key);
		    
    public abstract int update(AABB05A example);
    	    
    public abstract List<AABB05A> queryForList(Map<String,Object> params);
}
