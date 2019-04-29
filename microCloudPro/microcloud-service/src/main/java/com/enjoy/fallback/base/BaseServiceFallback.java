package com.enjoy.fallback.base;

import com.enjoy.mode.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * @author kancy
 * @version 1.0
 * @date 2019/3/4 16:31
 */
public class BaseServiceFallback {
    @Autowired
    private MessageSource messageSource;

    /**
     * 生成降级结果
     *
     * @return
     */
    protected Response getDefaultResult() {
        return new Response(Response.API_NOT_AVAILABLE,
                messageSource.getMessage(Response.API_NOT_AVAILABLE, null, LocaleContextHolder.getLocale()));
    }
}
