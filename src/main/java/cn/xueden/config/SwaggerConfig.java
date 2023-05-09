package cn.xueden.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author wuxuewei
 * @version 1.0
 * @time 2022/9/6
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {

    /**
     * 创建API
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                // 是否启用swagger
                .enable(true)
                //用来创建该API的基本信息，展示在文档的页面中（自定义展示的信息）
                .apiInfo(apiInfo())
                // 设置哪些接口暴露给Swagger展示
                .select()
                // 扫描所有有注解的api，用这种方式更灵活
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // 扫描所有包中的swagger注解
                .paths(PathSelectors.any())
                .build();

    }

    /**
     * 添加摘要信息
     */
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 设置标题
                .title("标题：尹稳健管理系统_Swagger3接口文档")
                // 描述
                .description("尹稳健无敌第一帅~")
                .contact(new Contact("yinwenjian", null, null))
                // 作者信息
                .version("v1.0")
                // 版本
                .build();
    }
}

