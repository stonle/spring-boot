package helloworld.spring_boot_hello1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 默认的静态映射目录有
 *  /** 映射到 /static （或/public、/resources、/META-INF/resources
 *  
 * 自定义映射目录 
 * 
 * 实现类继承 WebMvcConfigurerAdapter 并重写方法 addResourceHandlers 
 * @author Administrator
 * 
 * 以增加 /myres/* 映射到 classpath:/myres/* 为例的代码处理为
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	//自定义目录
    	registry.addResourceHandler("/myres/**").addResourceLocations("classpath:/myres/");
    	
    	//使用外部目录,映射目录不能写错
        registry.addResourceHandler("/api_files/**").addResourceLocations("file:D:/tp/ss/");
    	super.addResourceHandlers(registry);
    }
}
