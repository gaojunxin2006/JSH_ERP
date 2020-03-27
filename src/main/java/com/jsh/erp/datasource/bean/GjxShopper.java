package com.jsh.erp.datasource.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * /**
 * 开发者：高俊欣
 * 日期：2020/3/20
 * 微信：15000952623
 **/


//客户
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class GjxShopper implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String shopperName;

    private String contactsName;

    private String phone;

    private String tell;

    private String email;

    private String address;

    private String remarks;


}
