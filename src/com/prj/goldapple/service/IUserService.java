package com.prj.goldapple.service;

import java.util.List;
import java.util.Map;

import com.prj.goldapple.bean.AABB02A;

/***
 * 用户
 * 
 * @author huqi
 * @date 2015/11/26 17:02:36
 * @version1.0
 */
public interface IUserService {
    public abstract int create(AABB02A record);
    	    
    public abstract int delete(String key);
    	    
    public abstract AABB02A retrieve(String key);
		    
    public abstract int update(AABB02A example);
    	    
    public abstract List<AABB02A> queryForList(Map<String,Object> params);
}
