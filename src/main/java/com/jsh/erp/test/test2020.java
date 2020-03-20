package com.jsh.erp.test;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jsh.erp.datasource.entities.Supplier;
import com.jsh.erp.service.crm.CustSupplierService2020;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 开发者：高俊欣
 * 日期：2020/3/19
 * 微信：15000952623
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class test2020 {

    @Autowired
    private CustSupplierService2020 custSupplierService2020;




    //测试分页
    @Test
    public void testpage(){

        Page<Supplier> page= new Page<>(1,15);

        IPage<Supplier> iPage = custSupplierService2020.selectPage(page, null);

        System.out.println("总页数：\t"+iPage.getPages());
        System.out.println("总记录数：\t"+iPage.getTotal());

        List<Supplier> mpList = iPage.getRecords();

        mpList.forEach(System.out::println);


    }



}
