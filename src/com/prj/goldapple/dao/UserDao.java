package com.prj.goldapple.dao;

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
public interface UserDao {
    public int create(AABB02A record);
    
    public int delete(String key);
    
    public AABB02A retrieve(String key);

    public int update(AABB02A example);
    
    public List<AABB02A> queryForList(Map<String,Object> params);
}
