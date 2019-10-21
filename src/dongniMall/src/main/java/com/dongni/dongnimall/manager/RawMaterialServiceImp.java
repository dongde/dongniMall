package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.dao.RawMaterialMapper;
import com.dongni.dongnimall.pojo.RawMaterialDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cengshuai on 2019-10-21.
 * @version 1.0
 */
@Service
public class RawMaterialServiceImp implements RawMaterialService {
    @Autowired
    private RawMaterialMapper rawMaterialMapper;

    @Override
    public void addRawMaterials(List<RawMaterialDO> list) {
        rawMaterialMapper.insertRawMaterial(list);
    }
}
