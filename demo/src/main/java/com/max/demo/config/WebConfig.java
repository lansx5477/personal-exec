package com.max.demo.config;

import com.max.demo.converters.SpecialStructuredDataMessageConverter;
import com.max.demo.interceptors.LoggingInterceptor;
import jakarta.annotation.Resource;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Project demo
 * @Author: xiaoyinglan
 * @Date: 2024/01/31/14:20
 * @Description: web 自定义配置
 * @Version 1.0
 */
@Configuration
public class WebConfig {

    @Resource
    private LoggingInterceptor loggingInterceptor;

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {

            /**
             * 添加自定义的消息转换器
             * @param converters the list of configured converters to be extended
             */
            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                converters.add(new SpecialStructuredDataMessageConverter()
                );
            }


            /**
             * 自定义内容协商策略
             * @param configurer
             */
            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                Map<String, MediaType> mediaTypes = new HashMap<>(8);
                mediaTypes.put("json", MediaType.APPLICATION_JSON);
                mediaTypes.put("xml", MediaType.APPLICATION_XML);
                // 自定义媒体类型
                mediaTypes.put("special", MediaType.parseMediaType("application/x-special"));
                // 从查询参数解析请求的内容类型的策略。默认查询参数名称为“format”
                ParameterContentNegotiationStrategy parameterContentNegotiationStrategy = new ParameterContentNegotiationStrategy(mediaTypes);
                parameterContentNegotiationStrategy.setParameterName("protocol-type");
                HeaderContentNegotiationStrategy headerContentNegotiationStrategy = new HeaderContentNegotiationStrategy();
                configurer.strategies(Arrays.asList(parameterContentNegotiationStrategy, headerContentNegotiationStrategy));
            }


            // @Override
            // public void addInterceptors(InterceptorRegistry registry) {
            //     registry.addInterceptor(loggingInterceptor)
            //             .addPathPatterns("/**");
            // }
        };

    }



}
