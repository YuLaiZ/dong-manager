package com.yulaiz.dong.web;

import com.yulaiz.dong.web.common.annotation.CurrentUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by YuLai on 2018/1/19.
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yulaiz.dong.web"))
                .paths(PathSelectors.any())
                .build()
                .ignoredParameterTypes(CurrentUser.class);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("dong-manager")
                .description("董师傅的妖孽人生后台管理接口")
                .termsOfServiceUrl("http://yulaiz.com/dong/")
                .contact("YuLaiZ")
                .version("1.0")
                .build();
    }
}
