package com.dongni.dongnimall.dao;

import com.dongni.dongnimall.pojo.RawMaterialDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cengshuai on 2019-10-21.
 * @version 1.0
 */
@Repository
public interface RawMaterialMapper {
    void insertRawMaterial(List<RawMaterialDO> list);

    List<RawMaterialDO> selectRawMaterialList(String formula_upload_id);
}
