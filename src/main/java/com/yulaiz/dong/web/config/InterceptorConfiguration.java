package com.yulaiz.dong.web.config;

import com.yulaiz.dong.web.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by YuLai on 2018/1/19.
 */
@Configuration
public class InterceptorConfiguration extends WebMvcConfigurerAdapter {

    //关键，将拦截器作为bean写入配置中
    @Bean
    public AuthInterceptor myAuthInterceptor() {
        return new AuthInterceptor();
    }

    /**
     * {@inheritDoc}
     * <p>This implementation is empty.
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        InterceptorRegistration ir = registry.addInterceptor(myAuthInterceptor());
        // 配置拦截的路径
        ir.addPathPatterns("/**");
//         配置不拦截的路径
//        ir.excludePathPatterns("**/swagger-ui.html");

        // 还可以在这里注册其它的拦截器
        //registry.addInterceptor(new OtherInterceptor()).addPathPatterns("/**");
    }
}
