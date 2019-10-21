package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.pojo.RawMaterialDO;

import java.util.List;

/**
 * @author cengshuai on 2019-10-21.
 * @version 1.0
 */
public interface RawMaterialService {
    /**
     * 添加配方原料信息
     * @param list
     */
    void addRawMaterials(List<RawMaterialDO> list);
}
