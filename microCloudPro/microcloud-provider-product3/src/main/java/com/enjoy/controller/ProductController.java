package com.enjoy.controller;

import com.enjoy.vo.Product;
import com.enjoy.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    @RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;
    @Autowired
    private DiscoveryClient discoveryClient; // 进行Eureka的发现服务


    @RequestMapping(value="/get/{id}")
    public Object get(@PathVariable("id") long id) {
        return this.iProductService.get(id) ;
    }
    @RequestMapping(value="/add")
    public Object add(@RequestBody Product product) {
        return this.iProductService.add(product) ;
    }
    @RequestMapping(value="/list")
    public Object list() {
        return this.iProductService.list() ;
    }

    @RequestMapping("/discover")
    public Object discover() { // 直接返回发现服务信息
        return this.discoveryClient;
    }
}
