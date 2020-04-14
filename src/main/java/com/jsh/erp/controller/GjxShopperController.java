package com.jsh.erp.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.gson.Gson;
import com.jsh.erp.datasource.bean.GjxShopper;
import com.jsh.erp.datasource.entities.MaterialProperty;
import com.jsh.erp.datasource.mappers.GjxShopperMapper;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QEncoderStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * /**
 * 开发者：高俊欣
 * 日期：2020/3/20
 * 微信：15000952623
 **/

//客户资料Controller

@Controller
@RequestMapping("/gjxShopper")
@ResponseBody
public class GjxShopperController {


    @Resource
    private GjxShopperMapper gjxShopperMapper;





    //查询所有客户信息 并分页
    @RequestMapping("/findShopperList2020")
    public Map<String,Object> findShopperList(@RequestParam Integer pageSize,@RequestParam Integer currentPage,
                                              @RequestParam String search){


        System.out.println("======= 31行 GjxShopperController findShopperList2020 这个方法执行了，传进来的参数是： 页面大小：\t"+pageSize+
                "\t 当前也是：\t"+currentPage+"\t搜索条件是：\t"+search);


        Map<String,Object> searchMap= (Map<String, Object>) JSONObject.parse(search);

        //构造查询条件
        //根据客户企业名称搜索
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.like("shopper_name",searchMap.get("supplier"));

        //根据客户联系人搜索
        queryWrapper.like("contacts_name",searchMap.get("contacts_name"));


        Page<GjxShopper> page=new Page<>(currentPage,pageSize);

        IPage iPage = gjxShopperMapper.selectPage(page, queryWrapper);

        Map<String,Object> res=new HashMap<>();

        System.out.println("=============70行 GjxShopperController 总页数：\t"+iPage.getPages());
        System.out.println("=============71行 GjxShopperController 总记录数：\t"+iPage.getTotal());

        //封装表单明细
        List<GjxShopper> myList=iPage.getRecords();


        res.put("total",iPage.getTotal());
        res.put("rows",myList);
        res.put("code",200);


        System.out.println("=============84行 GjxShopperController封装后并且准备返回给前台的表格json数据是:\t"+res);


        return res;


    }



//===================================================================================================================

    //保存客户  saveShopper2020
    @RequestMapping("/saveShopper2020")
    public int saveShopper2020(@RequestParam String info){

        System.out.println("=============84行 GjxShopperController saveShopper2020() 保存客户方法执行了。。。。。。");

        System.out.println(info);

        Gson gson=new Gson();

        GjxShopper gjxShopper = gson.fromJson(info, GjxShopper.class);

        System.out.println("强行把json转换成对象后的结果:\t"+gjxShopper);

        int i = gjxShopperMapper.insert(gjxShopper);


        return i;
    }













}






