package com.dxhy.invoice.dao;

import com.dxhy.invoice.entity.RcResourceTypeConfig;

public interface RcResourceTypeConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RcResourceTypeConfig record);

    int insertSelective(RcResourceTypeConfig record);

    RcResourceTypeConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RcResourceTypeConfig record);

    int updateByPrimaryKey(RcResourceTypeConfig record);
}