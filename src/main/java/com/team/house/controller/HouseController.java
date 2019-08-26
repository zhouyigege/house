package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.service.HouseService;
import com.team.house.uitls.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王建兵
 * @Classname HouseController
 * @Description TODO
 * @Date 2019/8/20 15:40
 * @Created by Administrator
 */
@Controller(value = "houseController2")
@RequestMapping("/admin")
public class HouseController {

    @Autowired
    private HouseService houseService;

    //查询未审核出租房信息
    @RequestMapping("/getNoPassHouse")
    @ResponseBody
    public Map<String,Object> getNoPassHouse(Page page){  //page只为接收页码
        PageInfo<House> pageInfo=houseService.getHouseByIsPass(page,0); //0未审核
        //封装返回的数据
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }


    //查询已审核出租房信息
    @RequestMapping("/getYesPassHouse")
    @ResponseBody
    public Map<String,Object> getYesPassHouse(Page page){  //page只为接收页码
        PageInfo<House> pageInfo=houseService.getHouseByIsPass(page,1); //0未审核
        //封装返回的数据
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    //修改审核的状态:通过审核
    @RequestMapping("/goYesPassHouse")
    @ResponseBody
    public Map<String,Object> goYesPassHouse(String id){  //page只为接收页码
        int temp=houseService.PassHouse(id,1);//1通过审核
        //封装返回的数据
        Map<String,Object> map=new HashMap<>();
        map.put("result",temp);
        return map;
    }

    //修改审核的状态:通过审核
    @RequestMapping("/goNoPassHouse")
    @ResponseBody
    public Map<String,Object> goNoPassHouse(String id){  //page只为接收页码
        int temp=houseService.PassHouse(id,0);//1通过审核
        //封装返回的数据
        Map<String,Object> map=new HashMap<>();
        map.put("result",temp);
        return map;
    }
}
