package com.cn.test;

import com.enjoy.ProductApp;
import com.enjoy.service.IProductService;
import com.enjoy.vo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest(classes = ProductApp.class)
@RunWith(SpringRunner.class)
public class TestConnect {

    @Resource
    private IProductService iProductService;

    @Test
    public void testGet() {
        Product product = iProductService.get(1);
        System.out.println(product);
    }

    @Test
    public void testAdd() {
        Product product = new Product();
        product.setProductName("小狗爸爸");
        product.setProductDesc("爱萝莉的放款");
        boolean add = iProductService.add(product);
        System.out.println("[新增结果： ]" + add);
    }

    @Test
    public void testList() {
        System.out.println(iProductService.list());
    }
}
