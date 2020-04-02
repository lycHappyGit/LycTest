package com.dxhy.invoice.dao;

import com.dxhy.invoice.entity.AuthInfoUser;

public interface AuthInfoUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthInfoUser record);

    int insertSelective(AuthInfoUser record);

    AuthInfoUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuthInfoUser record);

    int updateByPrimaryKey(AuthInfoUser record);
}