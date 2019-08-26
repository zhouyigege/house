package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.entity.Type;
import com.team.house.entity.House;
import com.team.house.uitls.Page;

import java.util.List;

public interface TypeService {
    PageInfo<Type> getAllType(Page page);
    public int addType(Type type);
    public Type getType(Integer id);
    public int updateType(Type type);
    public int delType(Integer id );
    public int delMoreType(Integer [] ids);

    /**
     * 查询所有类型
     * @return
     */
    public List<Type> getAllType();


}
