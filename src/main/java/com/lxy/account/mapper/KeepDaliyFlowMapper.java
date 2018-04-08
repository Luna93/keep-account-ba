package com.lxy.account.mapper;

import com.lxy.account.entity.KeepDaliyFlowEntity;

public interface KeepDaliyFlowMapper {
    int deleteById(Integer id);

    int insert(KeepDaliyFlowEntity record);

    KeepDaliyFlowEntity selectById(Integer id);

    int updateById(KeepDaliyFlowEntity record);

}