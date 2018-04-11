package com.lxy.account.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lxy.account.entity.KeepDaliyFlowEntity;

public interface KeepDaliyFlowMapper {
    int deleteById(Integer id);

    int insert(KeepDaliyFlowEntity record);

    KeepDaliyFlowEntity selectById(Integer id);
    
    List<KeepDaliyFlowEntity> selectByDate(@Param("userId") Integer userId
    		, @Param("accountTimeStart") String accountTimeStart
    		, @Param("accountTimeEnd") String accountTimeEnd);

    int updateById(KeepDaliyFlowEntity record);

}