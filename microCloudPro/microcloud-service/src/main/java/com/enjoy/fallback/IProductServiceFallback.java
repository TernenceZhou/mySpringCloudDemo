package com.enjoy.fallback;

import com.enjoy.fallback.base.BaseServiceFallback;
import com.enjoy.mode.Response;
import com.enjoy.service.IProductClientService;
import com.enjoy.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @version 1.0
 * @date 2019/3/12 18:15
 */
@Component
public class IProductServiceFallback extends BaseServiceFallback implements IProductClientService {
    @Autowired
    MessageSource messageSource;


    /**
     * 生成降级结果
     *
     * @return
     */
    private Response getResult() {
        return getDefaultResult();
    }

    @Override
    public Product getProduct(long id) {
        return null;
    }

    @Override
    public List<Product> listProduct() {
        return null;
    }

    @Override
    public boolean addPorduct(Product product) {
        return false;
    }
}
