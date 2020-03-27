package com.jsh.erp.datasource.mappers;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jsh.erp.datasource.bean.GjxOrder;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;


public interface GjxOrderMapper extends BaseMapper<GjxOrder> {


    //自定义sql5 xml方式
    List<GjxOrder> selectOrder2021(@Param("orderName") String orderName);


    //自定义sql
    @Select("SELECT * FROM gjx_order ${ew.customSqlSegment}")
    List<GjxOrder> selectMyOrder2020(@Param(Constants.WRAPPER) Wrapper<GjxOrder> userWrapper);



    //自定义sql2
    @Select("SELECT * FROM gjx_order where orderName = #{orderName}")
    List<GjxOrder> selectMyOrder2020_2(@Param("orderName") String orderName);


    //自定义sql3多表联查
    @Select(" select o.*,s.* from gjx_order o inner join gjx_shopper s on o.define=s.id\n" +
            "        where\n" +
            "        o.orderName=#{orderName}")
    @Results({
            //查询关联
           @Result(
                   property = "define",
                   column = "define",
                   one = @One(select = "com.jsh.erp.datasource.mappers.GjxShopperMapper.selectById")
           )
    })
    List<GjxOrder> selectMyOrder2020_3(@Param("orderName") String orderName);



    //自定义sql6
    @Select("select * from gjx_order")
    List<Map<String,Object>> queryGjxOrder2020();



    //自定义sql7多表联查
    @Select(" select o.*,s.* from gjx_order o inner join gjx_shopper s on o.define=s.id\n" +
            "        where\n" +
            "        o.orderName=#{orderName}")

    List<GjxOrder> selectMyOrder2020_7(@Param("orderName") String orderName);



//=====================================================================================================================

    //自定义xml插入记录
    int inserOrder1(GjxOrder gjxOrder);




    //自定义sql插入记录
    @Insert("INSERT INTO gjx_order(orderId,define,createTime,product,quantity,productPrice,total,costSum,profit,orderName)\n" +
            "values (#{orderId},#{define.id},#{createTime},#{product.id},#{quantity},#{productPrice},#{total},#{costSum},#{profit},#{orderName})\n")
    int inserOrder2(GjxOrder gjxOrder);









}
