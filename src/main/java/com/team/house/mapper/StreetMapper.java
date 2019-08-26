package com.team.house.mapper;

import com.team.house.entity.Street;
import com.team.house.entity.StreetExample;
import java.util.List;

public interface StreetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Street record);

    int insertSelective(Street record);
////通过任何条件查询返回结果
    List<Street> selectByExample(StreetExample example);

    Street selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Street record);

    int updateByPrimaryKey(Street record);
      public   int delStreetByDistrict(Integer distrinctId);
}