package net.wangqiqi.huaqi.config.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * 全局拦截配置
 * Created by notreami on 16/8/7.
 */
@Configuration
public class FilterConfig {

    /**
     * 传入数据字符集编码
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean characterEncodingFilterRegistration() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);

        FilterRegistrationBean reg = new FilterRegistrationBean();
        reg.setFilter(filter);
        reg.addUrlPatterns("/*");
        return reg;
    }

}
