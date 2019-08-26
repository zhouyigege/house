package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.uitls.HouseCondition;
import com.team.house.uitls.Page;

public interface HouseService {

    public int addHouse(House house);
    /**
     * 查询用户发布的出租房
     * @param page  分页
     * @param userid 用户编号
     * @return 出租房信息
     */
    public PageInfo<House> getHouseByUser(Integer userid,Page page);
        //查询单条
    public House getHouse(String id);
    /**
     * 修改出租房信息
     * @param house 实体
     * @return 影响行数
     */
    public int updateHouse(House house);
    public  int delHouse(String id,Integer statel);

    /**
     * 通过审核状态查询出租房信息
     *  状态传1 表示已审核
     * 状态传0 表示未审核
     * @return 影响行数
     */
    public PageInfo<House>  getHouseByIsPass(Page page,Integer state);


    /**
 * 修改出租房的审核状态
 * 通过审核  状态传1
 * 消息审核  状态传0
 * @param id  出租房编号
 * @param state  状态信息
 * @return 影响行数
 */
public int PassHouse(String id,Integer state);


/**
 * 浏览出租房信息
 * @param condition  查询条件
 * @return  所有出租房
 */
public PageInfo<House> getHouseBySearch(HouseCondition condition);


}


