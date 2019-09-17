package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.dao.ManagerMapper;
import com.dongni.dongnimall.pojo.ManagerDO;
import com.dongni.dongnimall.vo.PageData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author cengshuai on 2019-09-09.
 * @version 1.0
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerMapper managerMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public PageData queryManagerList(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<ManagerDO> list = managerMapper.selectManageList();

        PageInfo<ManagerDO> pageInfo = new PageInfo<>(list);


        PageData pageData = new PageData();
        pageData.setCode(0);
        pageData.setCount(pageInfo.getTotal());
        pageData.setMsg("");
        pageData.setData(list);

        return pageData;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addManager(ManagerDO managerDO) {
        managerMapper.insertManager(managerDO);
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryManagerByName(String name, String id) {
        return managerMapper.selectManagerByName(name, id).size() > 0;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public ManagerDO queryManagerByNameAndPassword(String name, String password) {
        return managerMapper.selectManagerByNameAndPassword(name, password);
    }

    @Override
    public void modifyManager(ManagerDO managerDO) {
        System.out.println(managerDO);
        managerMapper.updateManager(managerDO);
    }

    @Override
    public void removeManager(String id) {
        managerMapper.deleteManager(id);
    }
}
