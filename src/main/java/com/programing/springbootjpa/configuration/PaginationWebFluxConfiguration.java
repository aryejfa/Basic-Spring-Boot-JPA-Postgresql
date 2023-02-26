package com.programing.springbootjpa.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.ReactivePageableHandlerMethodArgumentResolver;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.result.method.annotation.ArgumentResolverConfigurer;

@Configuration
public class PaginationWebFluxConfiguration implements WebFluxConfigurer {

    @Override
    public  void configureArgumentResolvers(ArgumentResolverConfigurer configurer){
        configurer.addCustomResolver(new ReactivePageableHandlerMethodArgumentResolver());
    }
}
