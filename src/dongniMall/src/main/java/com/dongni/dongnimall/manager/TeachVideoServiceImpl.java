package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.dao.TeachVideoMapper;
import com.dongni.dongnimall.pojo.TeachVideoDO;
import com.dongni.dongnimall.vo.PageData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author cengshuai on 2019-09-11.
 * @version 1.0
 */
@Service
public class TeachVideoServiceImpl implements TeachVideoService {
    @Autowired
    private TeachVideoMapper teachVideoMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public PageData queryTeachVideoList(Integer page, Integer pageSize, String title) {
        PageHelper.startPage(page,pageSize);
        List<TeachVideoDO> list = teachVideoMapper.selectTeachVideoList(title);

        PageInfo<TeachVideoDO> pageInfo = new PageInfo<>(list);
        PageData pageData = new PageData();
        pageData.setMsg("");
        pageData.setData(list);
        pageData.setCode(0);
        pageData.setCount(pageInfo.getTotal());
        return pageData;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void removeTeachVideo(String id) {
        teachVideoMapper.deleteTeachVideo(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addTeachVideo(TeachVideoDO teachVideoDO) {
        teachVideoMapper.insertTeachVideo(teachVideoDO);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void modifyTeachVideo(TeachVideoDO teachVideoDO) {
        teachVideoMapper.updateTeachVideo(teachVideoDO);
    }
}
