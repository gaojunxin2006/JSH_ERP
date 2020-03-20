package com.jsh.erp.datasource.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 开发者：高俊欣
 * 日期：2020/3/20
 * 微信：15000952623
 **/


//产品
@Data
public class Product2020 {

    @TableId(type = IdType.AUTO)
    private Integer id;


    //名称
    private String PName;

    //规格
    private String guige;

    //型号
    private String model;

    //成本
    private Integer cost;

    //销售价
    private Integer price;

    //条码
    private String code;

    //生产商
    private String supplierName;

    //备注
    private String Premarks;



}
