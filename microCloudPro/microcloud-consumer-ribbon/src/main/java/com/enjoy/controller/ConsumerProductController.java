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
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerProductController {

    public static final String PRODUCT_TOPIC = "MICROCLOUD-PROVIDER-PRODUCT";
    public static final String PRODUCT_LIST_URL="http://MICROCLOUD-PROVIDER-PRODUCT/product/list/";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private HttpHeaders httpHeaders;

    @Resource
    private LoadBalancerClient loadBalancerClient;


    @RequestMapping("/product/list")
    public  Object listProduct() {
        //服务提供方的实例信息
        //【*** ServiceInstance ***】host = 10.43.22.21、port = 8080、serviceId = MICROCLOUD-PROVIDER-PRODUCT
        ServiceInstance serviceInstance = this.loadBalancerClient.choose(PRODUCT_TOPIC) ;
        System.out.println(
                "【*** ServiceInstance ***】host = " + serviceInstance.getHost()
                        + "、port = " + serviceInstance.getPort()
                        + "、serviceId = " + serviceInstance.getServiceId());
        URI uri = URI.create(String.format("http://%s:%s/product/list/" ,
                serviceInstance.getHost(), serviceInstance.getPort()));

        List<Product> list = restTemplate.exchange(uri,HttpMethod.GET,
                new HttpEntity<Object>(httpHeaders), List.class).getBody();
//        List<Product> list = restTemplate.exchange(PRODUCT_LIST_URL,
//                HttpMethod.GET,new HttpEntity<Object>(httpHeaders), List.class).getBody();
        return  list;
    }


    public static void main(String[] args) {
        int arr[]= {5,2,1,3,6};
        //charu(arr, arr.length);
        //insertionSort(arr, arr.length);
        chooseSort(arr, arr.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 插入排序 采用分而治之的思想 把数据分为两部分 默认第一个数就是已排序的数据  然后把后面未排序的数据和已排序比较
     * 把小的数据放到已排序末尾
     * @param arr
     * @param len
     * @return
     */
    public static void charu(int arr[],int len){
        if(len <=1) return;

        for (int i = 1; i < len; ++i) {
            int value = arr[i];
            int j = i -1 ;
            for (; j>= 0; --j) {
                if(arr[j] > value){
                    arr[j+1] = arr[j];//数据移动
                }else {
                    break;
                }
            }
            //赋值
            arr[j+1] = value;

        }
    }

    public static void chooseSort(int arr[],int len){
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i; j < len; j++) {
                if(arr[j]  < arr[min]){
                    min = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
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
