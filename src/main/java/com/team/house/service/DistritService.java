package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.uitls.Page;

import java.util.List;

public interface DistritService {
    PageInfo<District>  getAllDistrict(Page page);
    public int addDistrict(District district);
    public District getDistrict(Integer id);
    public int updateD(District district);
    public int delDistrict(Integer id);
    public int delMoreDistrict(Integer [] ids);

    public List<District> getAllDistrict();

}
