package com.enjoy.service;

import com.enjoy.fallback.IProductClientServiceFallbackFactory;
import com.enjoy.feign.FeignClientConfig;
import com.enjoy.vo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "MICROCLOUD-PROVIDER-PRODUCT",configuration = FeignClientConfig.class,
        fallbackFactory = IProductClientServiceFallbackFactory.class)
public interface IProductClientService {


    @RequestMapping("product/get/{id}")
    Product getProduct(@PathVariable("id") long id);

    @RequestMapping("/product/list")
    public List<Product> listProduct() ;

    @RequestMapping("/product/add")
    public boolean addPorduct(Product product) ;
}
