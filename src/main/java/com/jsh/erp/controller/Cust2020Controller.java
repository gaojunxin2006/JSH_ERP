package com.jsh.erp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jsh.erp.datasource.entities.Supplier;
import com.jsh.erp.service.crm.CustSupplierService2020;
import com.jsh.erp.service.supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 开发者：高俊欣
 * 日期：2020/3/18
 * 微信：15000952623
 **/

@Controller
@RequestMapping("/cust")
@ResponseBody
public class Cust2020Controller {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private CustSupplierService2020 custSupplierService2020;




    @RequestMapping("/getCust")
    public String getCust(){


        System.out.println("22行=========Cust2020Controller getCust 这个方法已经执行了。。。。。。");

        return null;

    }



    @RequestMapping(value = "/getCust2")
    public JSONArray findBySelectSup(HttpServletRequest request) throws Exception{
        System.out.println("44行=========Cust2020Controller getCust2 这个方法已经执行了。。。。。。");
        JSONArray arr = new JSONArray();
        try {
            List<Supplier> supplierList = supplierService.findBySelectSup();
            JSONArray dataArray = new JSONArray();
            if (null != supplierList) {
                for (Supplier supplier : supplierList) {
                    JSONObject item = new JSONObject();
                    item.put("id", supplier.getId());
                    //供应商名称
                    item.put("supplier", supplier.getSupplier());
                    dataArray.add(item);
                }
            }
            arr = dataArray;
        } catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("62行=========Cust2020Controller getCust2 \t"+arr);
        return arr;
    }


    @RequestMapping("/getcust3")
    public JSONArray findAllSupplier(){

        System.out.println("78行=========Cust2020Controller getCust3   查找全部客户\t");

        List<Supplier> suppliers = custSupplierService2020.selectList(null);




        suppliers.forEach(System.out::println);

      //  System.out.println("85============================"+supplier);

        JSONArray arr = new JSONArray();

        //把集合封装到json对象中
//        arr=JSONArray.parseArray(JSON.toJSONString(suppliers));

        JSONArray dataArray = new JSONArray();
        if (null != suppliers) {
            for (Supplier supplier : suppliers) {
                JSONObject item = new JSONObject();
                item.put("id", supplier.getId());
                //供应商名称
                item.put("supplier", supplier.getSupplier());
                dataArray.add(item);
            }
        }
        arr = dataArray;

        System.out.println("====== 93==== Cust2020Controller getCust3   "+arr);


        //分页查询记录
        Page<Supplier> page=new Page<>(1,20);

        IPage<Supplier> supplierIPage = custSupplierService2020.selectPage(page, null);

        System.out.println("====== 118==== Cust2020Controller getCust3  总页数：\t"+supplierIPage.getPages());
        System.out.println("====== 119==== Cust2020Controller getCust3 总记录数："+supplierIPage.getTotal());

        List<Supplier> list = supplierIPage.getRecords();

        list.forEach(System.out::println);

        return arr;



    }










}
