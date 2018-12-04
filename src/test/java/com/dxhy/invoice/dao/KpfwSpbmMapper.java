package com.dxhy.invoice.dao;

import com.dxhy.invoice.entity.KpfwSpbm;

public interface KpfwSpbmMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(KpfwSpbm record);

    int insertSelective(KpfwSpbm record);

    KpfwSpbm selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(KpfwSpbm record);

    int updateByPrimaryKey(KpfwSpbm record);
}