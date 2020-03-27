package com.jsh.erp.datasource.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * /**
 * 开发者：高俊欣
 * 日期：2020/3/20
 * 微信：15000952623
 **/


//销售员工
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("gjx_sellsUser")
public class GjxSellsuser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private int id;

    private String city;

    @TableField("inTime")
    private LocalDateTime inTime;

    private Integer deleted;

    private String name;


}
