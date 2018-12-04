package com.dxhy.invoice.dao;

import com.dxhy.invoice.entity.InvoiceWarning;

public interface InvoiceWarningMapper {
    int deleteByPrimaryKey(Long id);

    int insert(InvoiceWarning record);

    int insertSelective(InvoiceWarning record);

    InvoiceWarning selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(InvoiceWarning record);

    int updateByPrimaryKey(InvoiceWarning record);
}