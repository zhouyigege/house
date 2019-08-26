package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.Type;
import com.team.house.entity.TypeExample;
import com.team.house.entity.Users;
import com.team.house.entity.UsersExample;
import com.team.house.mapper.StreetMapper;
import com.team.house.mapper.TypeMapper;
import com.team.house.mapper.UsersMapper;
import com.team.house.service.TypeService;
import com.team.house.service.UsersService;
import com.team.house.uitls.MD5Utils;
import com.team.house.uitls.Page;
import com.team.house.uitls.UserCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UsersService {
        @Autowired
        private UsersMapper usersMapper;
    @Override
    public PageInfo<Users> getAllUsers(UserCondition userCondition) {

        //开启分页
        PageHelper.startPage(userCondition.getPage(),userCondition.getRows());
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria=usersExample.createCriteria();
        criteria.andIsadminEqualTo(0); //注册用户
        //传入查询条件
        if (userCondition.getName()!=null){
            criteria.andNameLike("%"+userCondition.getName()+"%");
}
            if (userCondition.getTelephone()!=null){
                    criteria.andTelephoneLike("%"+userCondition.getTelephone()+"%");
                    }
                    //执行
                    List<Users> list = usersMapper.selectByExample(usersExample);
        PageInfo<Users> pageInfo=new PageInfo<>(list);
        return pageInfo;
        }

    @Override
    public int addUser(Users users) {
        //设置注册用户
        users.setIsadmin(new Integer("0"));

        //采用MD5加密数据库
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
        return usersMapper.insertSelective(users);
    }

    @Override
    public int idUserNameExists(String name) {
        return usersMapper.getUserCount(name);

    }

    @Override
    public Users login(String username,String password) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria=usersExample.createCriteria();
        criteria.andNameEqualTo(username);
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));
        List<Users> list=usersMapper.selectByExample(usersExample);
        if (list.size()==0)
            return null;
            else
                return list.get(0);
    }


}
