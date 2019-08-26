package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.entity.House;
import com.team.house.service.DistritService;
import com.team.house.uitls.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/admin/")
public class DistritController {
    @Autowired
    private DistritService distritService;

    @ResponseBody
    @RequestMapping("getDistrict")
    public HashMap<String, Object> getDistrict(Page page) {
        PageInfo<District> pageInfo = distritService.getAllDistrict(page);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }


    @RequestMapping("addDistrict")
    @ResponseBody
    public String addDistrict(District district) {
        int temp = -1;
        try {
            temp = distritService.addDistrict(district);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return " {\"result\":" + temp + "}";
    }

    //通过主键查询单 条
    @RequestMapping("/getOneDistrict")
    @ResponseBody
    public District getDistrict(Integer id) {
        return distritService.getDistrict(id);
    }

    @RequestMapping("updDistrict")
    @ResponseBody
    public String updDistrict(District district) {
        int temp = -1;
        try {
            temp = distritService.updateD(district);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return " {\"result\":" + temp + "}";
    }

    @RequestMapping("delDistrict")
    @ResponseBody
    public String delDistrict(Integer id) {
        int temp=-1;
        try{
            temp=distritService.delDistrict(id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "{\"result\":"+temp+"}" ;
    }
    //批量删除区域
//delMoreDistrict?id=1&id=2&id=3  = public String delDistrict(Integer []id)
    @RequestMapping("/delMoreDistrict")  //1,2,3
    @ResponseBody
    public String delDistrict(String ids){
        //将字符串转化为数组
        String arys[]=ids.split(",");
        Integer [] is=new Integer[arys.length];
        for (int i=0;i<arys.length;i++){
            is[i]=new Integer(arys[i]);
        }
        //调用业务
        int tmep=distritService.delMoreDistrict(is);
        return "{\"result\":"+tmep+"}";
    }

    @Controller( value ="districtController2" )
    @RequestMapping(value = "/page")
    public class DistrictController {
        @Autowired
        private DistritService distritService;

        @RequestMapping("/getAllDistrict")
        @ResponseBody
        public List<District> getAllType() {

            return distritService.getAllDistrict();
        }
    }

}
