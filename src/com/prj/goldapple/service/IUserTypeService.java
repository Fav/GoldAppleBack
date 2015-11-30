package com.prj.goldapple.service;

import java.util.List;
import java.util.Map;

import com.prj.goldapple.bean.AABB01A;

/***
 * 用户类型表
 * 
 * @author huqi
 * @date 2015/11/29 11:29:39
 * @version1.0
 */
public interface IUserTypeService {
    public abstract int create(AABB01A record);
    	    
    public abstract int delete(String key);
    	    
    public abstract AABB01A retrieve(String key);
		    
    public abstract int update(AABB01A example);
    	    
    public abstract List<AABB01A> queryForList(Map<String,Object> params);
}
