package com.jsh.erp.datasource.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.time.LocalDate;

/**
 * 开发者：高俊欣
 * 日期：2020/3/20
 * 微信：15000952623
 **/


//销售人员
@Data
public class SellsUser2020 {


    @TableId(type = IdType.AUTO)
    private Integer id;

    //姓名
    private String SellsName;


    //所属区域
    private String city;


    //入职时间
    private LocalDate inTime;


    //是否离职
    @TableLogic
    private Integer deleted;









}
