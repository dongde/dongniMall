package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.dao.ArticleMapper;
import com.dongni.dongnimall.pojo.ActicleDO;
import com.dongni.dongnimall.vo.PageData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.SUPPORTS)
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;


    @Override
    public PageData selectAll(Integer page, Integer limit, String title, String source){
        PageData pageData = new PageData();
        if(page==null){
            page = 1;
        }
        if(limit==null){
            limit = 10;
        }
        if(StringUtils.isBlank(title) && StringUtils.isBlank(source)) {
            PageHelper.startPage(page, limit);
            List<ActicleDO> acticleDOS = articleMapper.selectAll();
            PageInfo<ActicleDO> pageInfo = new PageInfo<>(acticleDOS);
            pageData.setCode(0);
            pageData.setCount(pageInfo.getTotal());
            pageData.setMsg("");
            pageData.setData(acticleDOS);
            return pageData;
        }else if(StringUtils.isBlank(title) && !StringUtils.isBlank(source)){
            PageHelper.startPage(page, limit);
            List<ActicleDO> list = articleMapper.queryBySource(source);
            PageInfo<ActicleDO> pageInfo = new PageInfo<>(list);
            pageData.setCode(0);
            pageData.setCount(pageInfo.getTotal());
            pageData.setMsg("");
            pageData.setData(list);
            return pageData;
        }else if(!StringUtils.isBlank(title) && StringUtils.isBlank(source)){
            PageHelper.startPage(page, limit);
            List<ActicleDO> newsInformations1 = articleMapper.queryByTitle(title);
            PageInfo<ActicleDO> pageInfo = new PageInfo<>(newsInformations1);
            pageData.setCode(0);
            pageData.setCount(pageInfo.getTotal());
            pageData.setMsg("");
            pageData.setData(newsInformations1);
            return pageData;
        }else if(!"".equals(title) && !"".equals(source)){
            PageHelper.startPage(page, limit);
            List<ActicleDO> lists =  articleMapper.findByTitleAndSource(title, source);
            PageInfo<ActicleDO> pageInfo = new PageInfo<>(lists);
            pageData.setCode(0);
            pageData.setCount(pageInfo.getTotal());
            pageData.setMsg("");
            pageData.setData(lists);
            return pageData;
        }else{
            return pageData;
        }
    }


    @Override
    public void insertObject(ActicleDO acticleDO) {
        articleMapper.insertObject(acticleDO);
    }

    @Override
    public ActicleDO findByID(String id) {
        return articleMapper.findByID(id);
    }


    @Override
    public ActicleDO findByTitle(String title) {

        return articleMapper.findByTitle(title);
    }

    @Override
    public void deleteNews(String id) {
        articleMapper.deleteNewsByID(id);
    }

    @Override
    public void updateNews(ActicleDO acticleDO, String id) {
        articleMapper.updateNews(acticleDO,id);
    }

}
