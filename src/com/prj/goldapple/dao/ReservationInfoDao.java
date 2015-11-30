package com.prj.goldapple.dao;

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
public interface ReservationInfoDao {
    public int create(AABB05A record);
    
    public int delete(String key);
    
    public AABB05A retrieve(String key);

    public int update(AABB05A example);
    
    public List<AABB05A> queryForList(Map<String,Object> params);
}
