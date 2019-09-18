package com.dongni.dongnimall.dao;

import com.dongni.dongnimall.pojo.LogisticsDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cengshuai on 2019-09-17.
 * @version 1.0
 */
@Repository
public interface LogisticsMapper {
    void insertLogistics(LogisticsDO logisticsDO);

    void deleteLogistics(String order_number);

    LogisticsDO selectLogistics(String order_number);
}
