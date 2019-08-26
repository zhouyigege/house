package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Type;
import com.team.house.entity.Users;
import com.team.house.uitls.Page;
import com.team.house.uitls.UserCondition;

public interface UsersService {
    //
    //跟据条件 查询所有
    PageInfo<Users> getAllUsers(UserCondition userCondition);

//实现用户注册
    public int addUser(Users users);
    //检查用户名是否存在
    //name 用户名
    // return 总行数 返回1 存在 返回0不存在
    public int idUserNameExists(String name );
    public  Users login(String username,String password);

}
