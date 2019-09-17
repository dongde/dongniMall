package com.dongni.dongnimall.common;

/**
 * @author cengshuai on 2019-09-09.
 * @version 1.0
 */
public enum ManagerPermissionEnum {
    LEVEL1(1),LEVEL2(2);

    private int value;

    ManagerPermissionEnum(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
