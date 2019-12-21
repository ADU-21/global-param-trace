package com.adu21.spring.boot.global.param.trace.configuration;

import com.adu21.spring.boot.global.param.trace.interceptor.MdcInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author LukeDu
 * @date 2019/12/21
 */
@Configuration
public class AppConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private MdcInterceptor mdcInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(mdcInterceptor);
    }
}
