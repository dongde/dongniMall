package com.dongni.dongnimall.common;

/**
 * @author cengshuai on 2019-09-05.
 * @version 1.0
 */
public enum BannerUsedEnum {
    USED(1),
    UNUSED(0);

    public final int value;

    BannerUsedEnum(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

}
