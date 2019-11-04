package com.dongni.dongnimall.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author cengshuai on 2019-11-04.
 * @version 1.0
 */
@Component
@Data
public class SearchRecordDO {
    //id
    private String id;
    //热搜词
    private String word;
}
