package com.jsh.erp.datasource.bean;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.ibatis.annotations.Result;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.JDBCType;
import java.time.LocalDateTime;

/**

 * @author gjx
 * @since 2020-03-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "gjx_order",resultMap = "BaseResultMap")
public class GjxOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private int id;

    //合约id
    @TableField("orderId")
    private String orderId;

    //合约名称
    @TableField("orderName")
    private String orderName;


    //客户外键
    @TableField(el = "define.id,jdbcType=INTEGER")
    private GjxShopper define;



    @TableField(value = "createTime",fill = FieldFill.INSERT)
    private LocalDateTime createTime;



    //销售人员外键
    @TableField(value = "sellsUsers",el = "sellsUsers.id,jdbcType=INTEGER")
    private GjxSellsuser sellsUsers;



    //商品外键
    @TableField(el = "product.id")
    private GjxProduct product;



    //数量
    private Integer quantity;

    //单价
    @TableField(value = "productPrice")
    private BigDecimal productPrice;


    //总价
    private BigDecimal total;

    //成本
    @TableField("costSum")
    private BigDecimal costSum;

    //毛利
    private BigDecimal profit;



}
