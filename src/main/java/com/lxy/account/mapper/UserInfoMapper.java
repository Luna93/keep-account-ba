package com.lxy.account.mapper;

import com.lxy.account.entity.UserInfoEntity;

public interface UserInfoMapper {

    int insert(UserInfoEntity record);

    UserInfoEntity selectByOpenId(String openid);
    
    UserInfoEntity selectById(Integer id);

    int updateById(UserInfoEntity record);
}