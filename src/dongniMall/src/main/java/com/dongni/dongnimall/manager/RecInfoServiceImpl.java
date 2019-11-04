package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.dao.RecInfoMapper;
import com.dongni.dongnimall.pojo.RecInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cengshuai on 2019-11-02.
 * @version 1.0
 */
@Service
public class RecInfoServiceImpl implements RecInfoService {
    @Autowired
    private RecInfoMapper recInfoMapper;

    @Override
    public void addRecInfo(RecInfoDO recInfoDO) {
        recInfoMapper.insertRecInfo(recInfoDO);
    }

    @Override
    public List<RecInfoDO> queryRecInfoListByUserPhone(String user_phone) {
        return recInfoMapper.selectRecInfoListByUserPhone(user_phone);
    }

    @Override
    public RecInfoDO queryRecInfoById(String id) {
        return recInfoMapper.selectRecInfoById(id);
    }

    @Override
    public void removeRecInfoById(String id) {
        recInfoMapper.deleteRecInfoById(id);
    }

    @Override
    public void modifyRecInfoById(RecInfoDO recInfoDO) {
        if (recInfoDO.getStatus().equals(1)) {
            recInfoMapper.updateRecInfoToNoDefault();
        }
        recInfoMapper.updateRecInfoById(recInfoDO);
    }
}
