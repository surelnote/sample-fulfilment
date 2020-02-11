package com.nuri.lguplus.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.MappedInterceptor;

import com.nuri.lguplus.config.filter.SampleFilter;
import com.nuri.lguplus.config.interceptor.SampleInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
    @Bean
	public FilterRegistrationBean getFilterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean(new SampleFilter());
		registrationBean.setOrder(Integer.MIN_VALUE);
		registrationBean.addUrlPatterns("/*");
//		registrationBean.setUrlPatterns(Arrays.asList("/sample/*"));
		return registrationBean;
	}
    

    @Bean
    public MappedInterceptor testInterceptor() {
    	return new MappedInterceptor(new String[]{"/*", "/**/*"}, new String[]{"/users/login"}, new SampleInterceptor());
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SampleInterceptor())
                .addPathPatterns("/*")
                .excludePathPatterns("/test/**/")
                .excludePathPatterns("/users/login"); //로그인 쪽은 예외처리를 한다.
    }
    
}