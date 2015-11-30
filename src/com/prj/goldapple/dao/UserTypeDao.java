package com.prj.goldapple.dao;

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
public interface UserTypeDao {
    public int create(AABB01A record);
    
    public int delete(String key);
    
    public AABB01A retrieve(String key);

    public int update(AABB01A example);
    
    public List<AABB01A> queryForList(Map<String,Object> params);
}
