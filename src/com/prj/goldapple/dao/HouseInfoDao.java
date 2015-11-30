package com.prj.goldapple.dao;

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
public interface HouseInfoDao {
    public int create(AABB04A record);
    
    public int delete(String key);
    
    public AABB04A retrieve(String key);

    public int update(AABB04A example);
    
    public List<AABB04A> queryForList(Map<String,Object> params);
}
