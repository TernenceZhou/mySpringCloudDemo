package com.enjoy.controller;

import com.enjoy.vo.Product;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerProductController {

    /*public static final String PRODUCT_GET_URL = "http://localhost:8080/prodcut/get/";
    public static final String PRODUCT_LIST_URL="http://localhost:8080/prodcut/list/";
    public static final String PRODUCT_ADD_URL = "http://localhost:8080/prodcut/add/";*/
    public static final String PRODUCT_GET_URL = "http://MICROCLOUD-PROVIDER-PRODUCT/product/get/";
    public static final String PRODUCT_LIST_URL="http://MICROCLOUD-PROVIDER-PRODUCT/product/list/";
    public static final String PRODUCT_ADD_URL = "http://MICROCLOUD-PROVIDER-PRODUCT/product/add/";
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private HttpHeaders httpHeaders;

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/product/get")
    public Object getProduct(long id) {
        Product product = restTemplate.exchange(PRODUCT_GET_URL + id,
                HttpMethod.GET,new HttpEntity<Object>(httpHeaders), Product.class).getBody();
        return  product;
    }

    @RequestMapping("/product/list")
    public  Object listProduct() {
        //服务提供方的实例信息
        //【*** ServiceInstance ***】host = 10.43.22.21、port = 8080、serviceId = MICROCLOUD-PROVIDER-PRODUCT
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("MICROCLOUD-PROVIDER-PRODUCT") ;
        System.out.println(
                "【*** ServiceInstance ***】host = " + serviceInstance.getHost()
                        + "、port = " + serviceInstance.getPort()
                        + "、serviceId = " + serviceInstance.getServiceId());
        List<Product> list = restTemplate.exchange(PRODUCT_LIST_URL,
                HttpMethod.GET,new HttpEntity<Object>(httpHeaders), List.class).getBody();
        return  list;
    }

    @RequestMapping("/product/add")
    public Object addPorduct(Product product) {
        Boolean result = restTemplate.exchange(PRODUCT_ADD_URL,
                HttpMethod.POST,new HttpEntity<Object>(product,httpHeaders), Boolean.class).getBody();
        return  result;
    }

   /* @RequestMapping("/product/get")
    public Object getProduct(long id) {
        Product product = restTemplate.getForObject(PRODUCT_GET_URL + id, Product.class);
        return  product;
    }

    @RequestMapping("/product/list")
    public  Object listProduct() {
        List<Product> list = restTemplate.getForObject(PRODUCT_LIST_URL, List.class);
        return  list;
    }

    @RequestMapping("/product/add")
    public Object addPorduct(Product product) {
        Boolean result = restTemplate.postForObject(PRODUCT_ADD_URL, product, Boolean.class);
        return  result;
    }*/
}
