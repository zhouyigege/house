package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.TypeExample;
import com.team.house.entity.Type;
import com.team.house.entity.TypeExample;
import com.team.house.entity.House;
import com.team.house.mapper.TypeMapper;
import com.team.house.mapper.StreetMapper;
import com.team.house.service.DistritService;
import com.team.house.service.TypeService;
import com.team.house.uitls.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private  StreetMapper streetMapper;
    @Override
    public PageInfo<Type> getAllType(Page page) {
        //开启分页 startPage
        PageHelper.startPage(page.getPage(),page.getRows());
        TypeExample typeExample = new TypeExample();
        List list = typeMapper.selectByExample(typeExample);
        PageInfo typePageInfo = new PageInfo(list);

        return typePageInfo;
    }

    @Override
    public int addType(Type type) {
        return typeMapper.insertSelective(type);
    }

    @Override
    public Type getType(Integer id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int  updateType(Type type) {
        return typeMapper.updateByPrimaryKeySelective(type);
    }

        @Override
        @Transactional
        public int delType(Integer id) {
            //删除区域的同时，删除街道   先删除外键 街道 再删除主键 区域
            // 删除区域

            typeMapper.deleteByPrimaryKey(id);
            //删除街道
            streetMapper.deleteByPrimaryKey(id);

            return 1;
}

    @Override
    public int delMoreType(Integer[] ids) {

            return typeMapper.delMoreType(ids);


    }
    @Override
    public List<Type> getAllType() {
        return typeMapper.selectByExample(new TypeExample());
    }



}
