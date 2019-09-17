package com.dongni.dongnimall;

//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.dongni.dongnimall.entity.BillShop;
//import com.dongni.dongnimall.mapper.BillShopMapper;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.sql.ClientInfoStatus;
//import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class DongniMallApplicationTests {
//
//    @Autowired
//    private BillShopMapper billShopMapper;
//
//    @Test
//    public void contextLoads() {
////        List<BillShop> list = billShopMapper.selectList(null);
////        list.forEach(shop -> {
////            System.out.println(shop.getId() + "," + shop.getName() + "," + shop.getCreateDate());
////        });
//
//        Page<BillShop> page = new Page<>(1,2);
//        IPage<BillShop> billShopIPage = billShopMapper.selectPageVo(page, "1");
//        List<BillShop> records = billShopIPage.getRecords();
//        records.forEach(billShop -> System.out.println(billShop.getId()));
//    }
//
//}
