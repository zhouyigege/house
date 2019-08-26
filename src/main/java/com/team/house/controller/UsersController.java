package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Type;
import com.team.house.entity.Users;
import com.team.house.service.TypeService;
import com.team.house.service.UsersService;
import com.team.house.uitls.Page;
import com.team.house.uitls.UserCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/page/")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @RequestMapping("getUser")
    @ResponseBody
    public Map<String,Object> getUser(UserCondition condition){
        PageInfo<Users> pageInfo = usersService.getAllUsers(condition);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }
    @RequestMapping("checkUserNmae")
    @ResponseBody

    public  Map<String,Object> checkUserName(String username){
        int temp=usersService.idUserNameExists(username);
        //返回数据
        Map<String,Object> map=new HashMap<>();
        map.put("result",temp);
        return map;

    }

    }



