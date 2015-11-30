package com.prj.goldapple.service;

import java.util.List;
import java.util.Map;

import com.prj.goldapple.bean.AABB04A;

/***
 * 房屋信息
 * 
 * @author huqi
 * @date 2015/11/29 21:19:11
 * @version1.0
 */
public interface IHouseInfoService {
    public abstract int create(AABB04A record);
    	    
    public abstract int delete(String key);
    	    
    public abstract AABB04A retrieve(String key);
		    
    public abstract int update(AABB04A example);
    	    
    public abstract List<AABB04A> queryForList(Map<String,Object> params);
}
