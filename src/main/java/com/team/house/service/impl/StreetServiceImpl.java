package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.Street;
import com.team.house.entity.StreetExample;
import com.team.house.entity.Type;
import com.team.house.entity.TypeExample;
import com.team.house.mapper.StreetMapper;
import com.team.house.mapper.TypeMapper;
import com.team.house.service.StreetService;
import com.team.house.service.TypeService;
import com.team.house.uitls.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StreetServiceImpl implements StreetService {

@Autowired
private  StreetMapper streetMapper;
    @Override
    public PageInfo<Street> getStreetByDistrict(Integer did, Page page) {
   //开启分页
    PageHelper.startPage(page.getPage(),page.getRows());

        //创建查询条件
        StreetExample streetExample=new StreetExample();
        StreetExample.Criteria criteria=streetExample.createCriteria();
        criteria.andDistrictIdEqualTo(did);//封装查询

        List<Street> list=  streetMapper.selectByExample(streetExample);
        return new PageInfo<Street>(list);
    }
    @Override
    public List<Street> getStreetByDistrict(Integer did) {
        //创建查询条件
        StreetExample streetExample=new StreetExample();
        StreetExample.Criteria criteria=streetExample.createCriteria();
        criteria.andDistrictIdEqualTo(did); //封装查询
        List<Street> list=  streetMapper.selectByExample(streetExample);
        return list;
    }


}

