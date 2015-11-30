package com.prj.goldapple.dao;

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
public interface DecorationEventDao {
    public int create(AABB03A record);
    
    public int delete(String key);
    
    public AABB03A retrieve(String key);

    public int update(AABB03A example);
    
    public List<AABB03A> queryForList(Map<String,Object> params);
}
