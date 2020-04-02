package com.mlamp.rcsc.dao;

import com.mlamp.rcsc.model.RcGxmlTemplate;

public interface RcGxmlTemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RcGxmlTemplate record);

    int insertSelective(RcGxmlTemplate record);

    RcGxmlTemplate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RcGxmlTemplate record);

    int updateByPrimaryKey(RcGxmlTemplate record);
}