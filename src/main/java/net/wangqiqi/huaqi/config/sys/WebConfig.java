package net.wangqiqi.huaqi.config.sys;

import lombok.val;
import net.wangqiqi.huaqi.util.JsonBinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by notreami on 16/8/7.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 返回字符编码
     *
     * @return
     */
    private StringHttpMessageConverter customStringHttpMessageConverter() {
        //添加application/json;charset=UTF-8 编码，默认是text/html 编码
        val supportedMediaTypes = new ArrayList<MediaType>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
        supportedMediaTypes.add(MediaType.TEXT_PLAIN);
        supportedMediaTypes.add(MediaType.ALL);

        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
        stringConverter.setDefaultCharset(StandardCharsets.UTF_8);
        stringConverter.setSupportedMediaTypes(supportedMediaTypes);
        stringConverter.setWriteAcceptCharset(false);
        return stringConverter;
    }

    /**
     * 扩展现有的消息转换器链表,会被系统后续添加的消息转换器替换
     *
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
    }

    /**
     * 扩展现有的消息转换器链表,会替换后续系统添加的消息转换器替换
     *
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        val httpMessageConverters = new ArrayList<HttpMessageConverter<?>>();
        for (HttpMessageConverter<?> httpMessageConverter : converters) {
            if (httpMessageConverter instanceof StringHttpMessageConverter ||
                    httpMessageConverter instanceof MappingJackson2HttpMessageConverter) {
                continue;
            }
            httpMessageConverters.add(httpMessageConverter);
        }
        httpMessageConverters.add(customStringHttpMessageConverter());
        httpMessageConverters.add(JsonBinder.getFastJsonHttpMessageConverter());//使用FastJson

        converters.clear();
        converters.addAll(httpMessageConverters);
    }

    /**
     * 同源策略-CORS跨域
     *
     * @return
     */
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*"); // 允许所有的外域发起跨域请求
        corsConfiguration.addAllowedHeader("Origin, X-Requested-With, Content-Type, Accept, Location, Authorization, userId, token"); // 允许跨域请求包含的头信息
        corsConfiguration.addAllowedMethod("GET, POST, PUT, OPTIONS, DELETE"); // 允许外域发起请求HTTP Method
        corsConfiguration.setMaxAge(3600L);
        corsConfiguration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    }

}
