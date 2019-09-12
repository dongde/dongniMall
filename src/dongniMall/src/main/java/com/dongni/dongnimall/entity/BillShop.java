package com.dongni.dongnimall.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BillShop implements Serializable {
    private Long id;
    private String name;
    private Date createDate;
}
