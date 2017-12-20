package com.kunlun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author by kunlun
 * @version <0.1>
 * @created on 2017/12/14.
 */
@Configuration
public class RibbonConfig extends WebMvcConfigurerAdapter {


    @Bean
    public RibbonInterceptor getInterceptor() {
        return new RibbonInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getInterceptor());
        super.addInterceptors(registry);
    }

    /**
     * 解决跨域
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*");
        super.addCorsMappings(registry);
    }

}
