package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.dao.BaseImageMapper;
import com.dongni.dongnimall.pojo.BaseImageDO;
import com.dongni.dongnimall.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseImageServiceImpl implements BaseImageService {

    @Autowired
    private BaseImageMapper baseImageMapper;

    @Override
    public JsonResult findAllbyID(String id) {
        List<BaseImageDO> baseImageDOS = baseImageMapper.findByID(id);
//        List<String> lists = new ArrayList<>();
//        for (BaseImageDO baseImageDO : baseImageDOS) {
//            lists.add(baseImageDO.getImageURL());
//        }
       return JsonResult.ok(baseImageDOS);
    }

    @Override
    public void insertImageURL(BaseImageDO baseImageDO) {
        baseImageMapper.insert(baseImageDO);
    }

    @Override
    public BaseImageDO findByURL(String url) {
        return baseImageMapper.findByurl(url);
    }

    @Override
    public BaseImageDO findID(String imageId) {
        return baseImageMapper.finbyID(imageId);
    }

    @Override
    public void updateMessage(BaseImageDO baseImageDO) {
        baseImageMapper.updateMessage(baseImageDO);
    }

    @Override
    public JsonResult deleteByID(String[] ids) {
        for (String id : ids) {
            baseImageMapper.deleteByID(id);
        }
        return JsonResult.ok();
    }
}
