package helloworld.spring_boot_hello1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import helloworld.spring_boot_hello1.interceptor.MyInterceptor1;
import helloworld.spring_boot_hello1.interceptor.MyInterceptor2;
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
    @Override
	public void addInterceptors(InterceptorRegistry registry) {
    	// 多个拦截器组成一个拦截器链
    	// addPathPatterns 用于添加拦截规则
    	// excludePathPatterns 用户排除拦截
    	registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/**");
    	registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**");
    	super.addInterceptors(registry);
	}
}
