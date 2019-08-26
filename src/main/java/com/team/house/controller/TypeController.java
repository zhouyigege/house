package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.entity.Type;
import com.team.house.mapper.TypeMapper;
import com.team.house.service.TypeService;
import com.team.house.uitls.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller(value="typeController1")
@RequestMapping("/admin/")
public class TypeController {
    @Autowired
    private TypeService typeService;
    @ResponseBody
    @RequestMapping("getType")
    public HashMap<String, Object> getDistrict(Page page) {
        PageInfo<Type> pageInfo = typeService.getAllType(page);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }
        @RequestMapping("addType")
        @ResponseBody
    public String addType(Type type){
            int temp = -1;
            try {
                temp = typeService.addType(type);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return " {\"result\":" + temp + "}";
        }

        @RequestMapping("getOneType")
    @ResponseBody
    public Type getOneType(Integer id){
        return typeService.getType(id);
    }

    @RequestMapping("updateType")
    @ResponseBody
    public String updateType(Type type){
        int temp = -1;
        try {
            temp = typeService.updateType(type);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return " {\"result\":" + temp + "}";
    }
    @ResponseBody
    @RequestMapping("delType")
    public String delType(Integer id){
        int temp = -1;
        try {
            temp = typeService.delType(id);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return " {\"result\":" + temp + "}";
    }
    @RequestMapping("/delMoreType")  //1,2,3
    @ResponseBody
    public String delType(String ids){
        //将字符串转化为数组
        String arys[]=ids.split(",");
        Integer [] is=new Integer[arys.length];
        for (int i=0;i<arys.length;i++){
            is[i]=new Integer(arys[i]);
        }
        //调用业务
        int tmep=typeService.delMoreType(is);
        return "{\"result\":"+tmep+"}";
    }

    }


