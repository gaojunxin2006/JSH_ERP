package com.jsh.erp.test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jsh.erp.datasource.bean.GjxOrder;
import com.jsh.erp.datasource.bean.GjxProduct;
import com.jsh.erp.datasource.bean.GjxShopper;
import com.jsh.erp.datasource.entities.Supplier;
import com.jsh.erp.datasource.mappers.GjxOrderMapper;
import com.jsh.erp.service.crm.CustSupplierService2020;
import com.jsh.erp.service.functions.FunctionsService;
import com.jsh.erp.service.gjx.IGjxOrderService;
import com.jsh.erp.service.gjx.IGjxProductService;
import com.jsh.erp.service.gjx.IGjxShopperService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 开发者：高俊欣
 * 日期：2020/3/19
 * 微信：15000952623
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class test2020 {

    @Autowired
    private CustSupplierService2020 custSupplierService2020;

    @Autowired
    private GjxOrderMapper gjxOrderMapper;

    @Autowired
    private IGjxOrderService iGjxOrderService2;

    @Autowired
    private IGjxShopperService iGjxShopperService;

    @Autowired
    private IGjxProductService iGjxProductService;



    //测试分页
    @Test
    public void testpage(){

        Page<Supplier> page= new Page<>(1,15);

        IPage<Supplier> iPage = custSupplierService2020.selectPage(page, null);

        System.out.println("总页数：\t"+iPage.getPages());
        System.out.println("总记录数：\t"+iPage.getTotal());

        List<Supplier> mpList = iPage.getRecords();

        mpList.forEach(System.out::println);


    }



    //===============================================================
    //测试自定义的合同管理
    @Test
    public void testOrder(){

        List<GjxOrder> gjxOrders = gjxOrderMapper.selectList(null);

        gjxOrders.forEach(System.out::println);

    }




    //===============================================================
    //测试自定义的合同管理2
    @Test
    public void testOrder2(){

        List<GjxOrder> gjxOrderList = gjxOrderMapper.selectMyOrder2020_2("日本索尼采购合同");

        gjxOrderList.forEach(System.out::println);

    }

    //===============================================================
    //测试自定义的合同管理3
    @Test
    public void testOrder3() {

        QueryWrapper<GjxOrder> wrapper=new QueryWrapper<>();
        wrapper.eq("orderName","韩国三星公司采购合同");
        List<GjxOrder> gjxOrders = gjxOrderMapper.selectMyOrder2020(wrapper);
        gjxOrders.forEach(System.out::println);



    }
    //===============================================================

    //测试自定义的合同管理4
    @Test
    public void testOrder4(){

        List<GjxOrder> gjxOrderList = gjxOrderMapper.selectMyOrder2020_3("日本索尼采购合同");

        gjxOrderList.forEach(System.out::println);

    }



    //===============================================================
    //测试自定义的合同管理5
    @Test
    public void testOrder5(){


        List<GjxOrder> gjxOrders = gjxOrderMapper.selectOrder2021("日本索尼采购合同");

        gjxOrders.forEach(System.out::println);



    }

    //===============================================================




    //测试自定义的合同管理5
    @Test
    public void testOrder6(){


        List<Map<String, Object>> maps = gjxOrderMapper.queryGjxOrder2020();

        maps.forEach(System.out::println);



    }

    //===============================================================

    //测试自定义的合同管理7
    @Test
    public void testOrder7(){

        List<GjxOrder> gjxOrders = gjxOrderMapper.selectMyOrder2020_7("日本索尼采购合同");
        gjxOrders.forEach(System.out::println);


    }

    //===============================================================


    //测试自定义的合同管理7
    @Test
    public void testOrder8(){

        GjxOrder gjxOrder = gjxOrderMapper.selectById("1");

        System.out.println(gjxOrder);


    }

    //===============================================================
    //测试自定义的合同管理8  自定义搜索条件
    @Test
    public void testOrder9(){


        List<GjxOrder> gjxOrders = gjxOrderMapper.selectList(null);

        gjxOrders.forEach(System.out::println);

        System.out.println("===============================================================================");

        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.like("orderName","格罗方德");
        gjxOrders=gjxOrderMapper.selectList(queryWrapper);
        gjxOrders.forEach(System.out::println);

    }



    //===============================================================
    //测试自定义的合同管理10   自定义搜索条件 使用Service接口
    @Test
    public void testOrder10(){

        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.like("orderName","英特尔");

        List list = iGjxOrderService2.list(queryWrapper);

        list.forEach(System.out::println);

    }


    //===============================================================
    //测试自定义的合同管理10   自定义搜索条件 使用Service接口
    @Test
    public void testOrder10_1(){

        //自定义查询条件
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.like("id","1");

        //查询商品
        List list = iGjxShopperService.list(queryWrapper);
        list.forEach(System.out::println);

        //查询客户
        GjxShopper gjxShopper = iGjxShopperService.getById(1);
        System.out.println(gjxShopper);

        //查询商品
        GjxProduct product = iGjxProductService.getById(1);
        System.out.println(product);


    }


    //===============================================================
    //测试自定义的合同管理11    使用Service接口 ,编写xml方式插入记录
    @Test
    public void testOrder11(){


        GjxOrder gjxOrder=new GjxOrder();
        gjxOrder.setOrderName("日本东芝采购协议22");
        gjxOrder.setOrderId(UUID.randomUUID().toString());

        //关联客户
        GjxShopper gjxShopper = iGjxShopperService.getById(1);
        gjxOrder.setDefine(gjxShopper);

        //关联商品
        GjxProduct product = iGjxProductService.getById(1);
        gjxOrder.setProduct(product);


        gjxOrder.setQuantity(10);
        gjxOrder.setProductPrice(new BigDecimal(67));


        //计算总价 数量*单价
        gjxOrder.setTotal((BigDecimal.valueOf((int)gjxOrder.getQuantity())).multiply(gjxOrder.getProductPrice()));


        //计算总成本 数量*成本价格
        gjxOrder.setCostSum((BigDecimal.valueOf((int)gjxOrder.getQuantity())).multiply(product.getCost()));


        //利润 总价减总成本
        gjxOrder.setProfit(gjxOrder.getTotal().subtract(gjxOrder.getCostSum()));

        //全部封装完毕

        System.out.println("对象封装完毕 准备写入数据库。。。。。。"+gjxOrder);


        int b = gjxOrderMapper.inserOrder1(gjxOrder);



        if (b!=0){

            System.out.println("数据写入成功！");
        }else {

            System.out.println("数据写入失败！");
        }


    }



    //===============================================================
    //测试自定义的合同管理12    使用Service接口 , mapper中自定义sql方式插入记录
    @Test
    public void testOrder12() {

        GjxProduct product = iGjxProductService.getById(1);

        GjxShopper shopper = iGjxShopperService.getById(2);

        GjxOrder gjxOrder=new GjxOrder();
        gjxOrder.setOrderName("格罗方德采购协议");
        gjxOrder.setOrderId(UUID.randomUUID().toString());

        //关联客户
        gjxOrder.setDefine(shopper);

        //关联商品
        gjxOrder.setProduct(product);

        gjxOrder.setQuantity(30);
        gjxOrder.setProductPrice(new BigDecimal(25));


        //计算总价 数量*单价
        gjxOrder.setTotal((BigDecimal.valueOf((int)gjxOrder.getQuantity())).multiply(gjxOrder.getProductPrice()));


        //计算总成本 数量*成本价格
        gjxOrder.setCostSum((BigDecimal.valueOf((int)gjxOrder.getQuantity())).multiply(product.getCost()));


        //利润 总价减总成本
        gjxOrder.setProfit(gjxOrder.getTotal().subtract(gjxOrder.getCostSum()));

        //全部封装完毕

        System.out.println("对象封装完毕 准备写入数据库。。。。。。"+gjxOrder);


        int i = gjxOrderMapper.inserOrder2(gjxOrder);

        if (i>0){
            System.out.println("数据写入成功！");
        }else {
            System.out.println("数据写入失败！");
        }



    }







    //===============================================================


    //===============================================================
    //测试自定义的合同管理13    使用Service接口 ,使用mp方式
    @Test
    public void testOrder13() {

        GjxProduct product = iGjxProductService.getById(1);

        GjxShopper shopper = iGjxShopperService.getById(2);

        GjxOrder gjxOrder=new GjxOrder();
        gjxOrder.setOrderName("英特尔");
        gjxOrder.setOrderId(UUID.randomUUID().toString());

        //关联客户
        gjxOrder.setDefine(shopper);

        //关联商品
        gjxOrder.setProduct(product);

        gjxOrder.setQuantity(30);
        gjxOrder.setProductPrice(new BigDecimal(25));


        //计算总价 数量*单价
        gjxOrder.setTotal((BigDecimal.valueOf((int)gjxOrder.getQuantity())).multiply(gjxOrder.getProductPrice()));


        //计算总成本 数量*成本价格
        gjxOrder.setCostSum((BigDecimal.valueOf((int)gjxOrder.getQuantity())).multiply(product.getCost()));


        //利润 总价减总成本
        gjxOrder.setProfit(gjxOrder.getTotal().subtract(gjxOrder.getCostSum()));

        //全部封装完毕

        System.out.println("对象封装完毕 准备写入数据库。。。。。。"+gjxOrder);


        int i = gjxOrderMapper.insert(gjxOrder);

        if (i>0){
            System.out.println("数据写入成功！");
        }else {
            System.out.println("数据写入失败！");
        }



    }







    //===============================================================

















    //===============================================================
}
