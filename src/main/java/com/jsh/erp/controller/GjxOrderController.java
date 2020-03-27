package com.jsh.erp.controller;


import com.alibaba.fastjson.JSONArray;
import com.jsh.erp.datasource.bean.GjxOrder;
import com.jsh.erp.service.gjx.IGjxOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 前端控制器
 * </p>
 *
 * @author gjx
 * @since 2020-03-23
 */

@Controller
@RequestMapping("/gjxOrder")
@ResponseBody
public class GjxOrderController {

    @Autowired
    private IGjxOrderService iGjxOrderService;




    //查询全部，未分页
    @RequestMapping("/getlists")
    public JSONArray selectAllOrder2020(){

        System.out.println("==========================GjxOrderController === 42行 === selectAllOrder2020（）方法 ===================================");

        JSONArray orders=new JSONArray();

        List<GjxOrder> list = iGjxOrderService.list();

        list.forEach(System.out::println);

        orders.add(list);

        return orders;
    }








}
