package com.dxhy.invoice.dao;

import com.dxhy.invoice.entity.RoleProjectRelation;

public interface RoleProjectRelationMapper {
    int deleteByPrimaryKey(Integer roleProjectId);

    int insert(RoleProjectRelation record);

    int insertSelective(RoleProjectRelation record);

    RoleProjectRelation selectByPrimaryKey(Integer roleProjectId);

    int updateByPrimaryKeySelective(RoleProjectRelation record);

    int updateByPrimaryKey(RoleProjectRelation record);
}