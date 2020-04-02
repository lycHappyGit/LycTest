package com.mlamp.rcsc.dao;

import com.mlamp.rcsc.model.RcConfig;

public interface RcConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RcConfig record);

    int insertSelective(RcConfig record);

    RcConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RcConfig record);

    int updateByPrimaryKey(RcConfig record);
}