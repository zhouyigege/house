package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.entity.DistrictExample;
import com.team.house.entity.House;
import com.team.house.mapper.DistrictMapper;
import com.team.house.mapper.StreetMapper;
import com.team.house.service.DistritService;
import com.team.house.uitls.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DistritServiceImpl implements DistritService {
@Autowired
  private DistrictMapper districtMapper;
    @Autowired
    private StreetMapper streetMapper;
    @Override
    public PageInfo<District> getAllDistrict(Page page) {
        //开启分页 startPage
        PageHelper.startPage(page.getPage(),page.getRows());
        DistrictExample districtExample = new DistrictExample();
        List list = districtMapper.selectByExample(districtExample);
        PageInfo districtPageInfo = new PageInfo(list);

        return districtPageInfo;
    }

    @Override
    public int addDistrict(District district) {
        return districtMapper.insertSelective(district);
    }

    @Override
    public District getDistrict(Integer id) {
        return districtMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateD(District district) {
        return districtMapper.updateByPrimaryKeySelective(district);
    }
    @Transactional
    //加上事务注释 要么都执行 要么都失败
    @Override
    public int delDistrict(Integer id) {
       //删除区域的同时，删除街道   先删除外键 街道 再删除主键 区域
        // 删除区域

        districtMapper.deleteByPrimaryKey(id);
        //删除街道
       streetMapper.deleteByPrimaryKey(id);

       return 1;
    }

    @Override
    public int delMoreDistrict(Integer[] ids) {
        return districtMapper.delMoreDistrict(ids);
    }

    @Override
    public List<District> getAllDistrict() {
        return districtMapper.selectByExample(new DistrictExample());
    }

}
