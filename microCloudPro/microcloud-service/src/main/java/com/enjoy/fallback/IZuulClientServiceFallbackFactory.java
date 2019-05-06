package com.enjoy.fallback;

import com.enjoy.service.IZuulClientService;
import com.enjoy.vo.Product;
import com.enjoy.vo.Users;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 降级处理
 */
@Component
public class IZuulClientServiceFallbackFactory implements FallbackFactory<IZuulClientService> {

    @Override
    public IZuulClientService create(Throwable throwable) {
        return  new IZuulClientService() {
            @Override
            public Product getProduct(long id) {
                Product product = new Product();
                product.setProductId(999999L);
                product.setProductName("feign-zuulName");
                product.setProductDesc("feign-zuulDesc");
                return  product;
            }

            @Override
            public List<Product> listProduct() {
                return null;
            }

            @Override
            public boolean addPorduct(Product product) {
                return false;
            }

            @Override
            public Users getUsers(String name) {
                Users user = new Users();
                user.setSex("F");
                user.setAge(17);
                user.setName("zuul-fllback："+name);
                return user;
            }
        };
    }
}
