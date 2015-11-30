package com.prj.goldapple.service;

import java.util.List;
import java.util.Map;

import com.prj.goldapple.bean.AABB03A;

/***
 * 装修事件
 * 
 * @author huqi
 * @date 2015/11/29 21:19:12
 * @version1.0
 */
public interface IDecorationEventService {
    public abstract int create(AABB03A record);
    	    
    public abstract int delete(String key);
    	    
    public abstract AABB03A retrieve(String key);
		    
    public abstract int update(AABB03A example);
    	    
    public abstract List<AABB03A> queryForList(Map<String,Object> params);
}
