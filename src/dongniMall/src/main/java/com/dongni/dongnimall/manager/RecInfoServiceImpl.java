package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.dao.RecInfoMapper;
import com.dongni.dongnimall.pojo.RecInfoDO;
import com.dongni.dongnimall.vo.RecInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<RecInfoVO> queryRecInfoListByUserPhone(String user_phone) {
        List<RecInfoDO> recInfoDOList = recInfoMapper.selectRecInfoListByUserPhone(user_phone);
        List<RecInfoVO> recInfoVOList = new ArrayList<>();
        for(RecInfoDO recInfoDO:recInfoDOList){
            RecInfoVO recInfoVO = new RecInfoVO();
            BeanUtils.copyProperties(recInfoDO,recInfoVO);
            String[] address = recInfoDO.getAddress().split("/",4);
            recInfoVO.setProvince(address[0]);
            recInfoVO.setCity(address[1]);
            recInfoVO.setArea(address[2]);
            recInfoVO.setStreet(address[3]);
            recInfoVOList.add(recInfoVO);
        }
        return recInfoVOList;
    }

    @Override
    public RecInfoDO queryRecInfoById(String id) {
        return recInfoMapper.selectRecInfoById(id);
    }

    @Override
    public void removeRecInfoById(String id) {
        recInfoMapper.deleteRecInfoById(id);
        RecInfoDO recInfoDO = recInfoMapper.selectRecInfoById(id);
        if(recInfoDO.getStatus()==1){
            List<RecInfoDO> list = recInfoMapper.selectRecInfoListByUserPhone(recInfoDO.getUser_phone());
            if(list.size()>0){
                RecInfoDO recInfoDO1 = list.get(0);
                recInfoMapper.updateRecInfoToDefault(recInfoDO1.getId());
            }
        }
    }

    @Override
    public void modifyRecInfoById(RecInfoDO recInfoDO) {
        recInfoMapper.updateRecInfoById(recInfoDO);
    }

    @Override
    public void modifyRecInfoDefaultStatus(String id) {
        recInfoMapper.updateRecInfoToNoDefault(id);
        recInfoMapper.updateRecInfoToDefault(id);
    }
}
