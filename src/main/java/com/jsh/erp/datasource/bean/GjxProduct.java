package com.jsh.erp.datasource.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * /**
 * 开发者：高俊欣
 * 日期：2020/3/20
 * 微信：15000952623
 **/


//产品
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class GjxProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private int id;

    @TableField("pName")
    private String pName;

    private String guige;

    private String model;

    //成本
    private BigDecimal cost;

    //零售价
    private BigDecimal price;

    //条码
    private String code;

    @TableField("supplieerName")
    private String supplieerName;

    //备注
    private String premarks;




}
