package com.jsh.erp.test;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 开发者：高俊欣
 * 日期：2020/3/26
 * 微信：15000952623
 **/


@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        //创建时插入
        setInsertFieldValByName("createTime", LocalDateTime.now(),metaObject);
    }


    @Override
    public void updateFill(MetaObject metaObject) {
        //更新是插入
//        setUpdateFieldValByName(null);
    }
}
