package com.jsh.erp.datasource.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDate;

/**
 * 开发者：高俊欣
 * 日期：2020/3/20
 * 微信：15000952623
 **/


//自定义合同实体类

@Data
@TableName("order2020")
public class Order2020 {


    //id，使用自增
    @TableId(type = IdType.AUTO)
    private Integer id;


    //单据编号
    @TableId(type = IdType.ID_WORKER)
    private Integer orderId;


    //客户名称
    private Shopper2020 define;


    //签约时间
    private LocalDate createTime;


    //销售人员
    private SellsUser2020 sellsUser;


    //产品名称
    private Product2020 product2020;


    //数量
    private Integer quantity;


    //单价
    private Integer product2020Price;


    //合计金额
    private Integer total;


    //总成本
    private Integer costSum;


    //毛利
    private Integer profit;

















}
