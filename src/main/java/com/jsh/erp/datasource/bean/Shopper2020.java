package com.jsh.erp.datasource.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 开发者：高俊欣
 * 日期：2020/3/20
 * 微信：15000952623
 **/

//客户信息
@Data
public class Shopper2020 {

    //客户id
    @TableId(type = IdType.AUTO)
    private Integer id;


    //客户名称
    private String Shopper_name;


    //联系人
    private String Contacts_name;


    //手机
    private Integer phone;


    //固定电话
    private Integer tell;


    //邮箱
    private String email;


    //地址
    private String address;


    //备注
    private String remarks;












}
