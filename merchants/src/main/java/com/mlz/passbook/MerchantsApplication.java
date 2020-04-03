package com.mlz.passbook;

import com.mlz.passbook.security.AuthCheckInteceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

@SpringBootApplication
public class MerchantsApplication extends WebMvcConfigurerAdapter {


    @Resource
    private AuthCheckInteceptor authCheckInteceptor;
    public static void main(String[] args) {
        SpringApplication.run(MerchantsApplication.class, args);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){

        registry.addInterceptor(authCheckInteceptor).addPathPatterns("/merchants/**");
        super.addInterceptors(registry);

    }



}
