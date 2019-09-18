package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.dao.NewsInformationDAO;
import com.dongni.dongnimall.pojo.NewsInformation;
import com.dongni.dongnimall.vo.PageData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional(propagation = Propagation.SUPPORTS)
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsInformationDAO newsInformationDAO;


    @Override
    public PageData selectAll(Integer page, Integer limit, String title, String source){
        PageData pageData = new PageData();
        if("".equals(title) && "".equals(source)) {
            PageHelper.startPage(page, limit);
            List<NewsInformation> newsInformations = newsInformationDAO.selectAll();
            PageInfo<NewsInformation> pageInfo = new PageInfo<>(newsInformations);
            pageData.setCode(0);
            pageData.setCount(pageInfo.getTotal());
            pageData.setMsg("");
            pageData.setData(newsInformations);
            return pageData;
        }else if("".equals(title) && source!=null){
            PageHelper.startPage(page, limit);
            List<NewsInformation> list = newsInformationDAO.queryBySource(source);
            PageInfo<NewsInformation> pageInfo = new PageInfo<>(list);
            pageData.setCode(0);
            pageData.setCount(pageInfo.getTotal());
            pageData.setMsg("");
            pageData.setData(list);
            return pageData;
        }else if(!"".equals(title) && "".equals(source)){
            PageHelper.startPage(page, limit);
            List<NewsInformation> newsInformations1 = newsInformationDAO.queryByTitle(title);
            PageInfo<NewsInformation> pageInfo = new PageInfo<>(newsInformations1);
            pageData.setCode(0);
            pageData.setCount(pageInfo.getTotal());
            pageData.setMsg("");
            pageData.setData(newsInformations1);
            return pageData;
        }else if(!"".equals(title) && !"".equals(source)){
            List<NewsInformation> lists = new ArrayList<>();
            NewsInformation newsInformation1 = newsInformationDAO.findByTitleAndSource(title, source);
            lists.add(newsInformation1);
            pageData.setCode(0);
            pageData.setCount(1);
            pageData.setMsg("");
            pageData.setData(lists);
            return pageData;
        }else{
            return pageData;
        }
    }


    @Override
    public void insertObject(NewsInformation newsInformation) {
        newsInformationDAO.insertObject(newsInformation);
    }

    @Override
    public NewsInformation findByID(Integer id) {
        return newsInformationDAO.findByID(id);
    }


    @Override
    public NewsInformation findByTitle(String title) {

        return newsInformationDAO.findByTitle(title);
    }

    @Override
    public void deleteNews(Integer id) {
        newsInformationDAO.deleteNewsByID(id);
    }

    @Override
    public void updateNews(NewsInformation newsInformation, Integer id) {
        newsInformationDAO.updateNews(newsInformation,id);
    }

}
