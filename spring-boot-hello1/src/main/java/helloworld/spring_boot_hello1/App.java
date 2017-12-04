package helloworld.spring_boot_hello1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import simple.plugin.spring.SpringUtil;

/**
 * Hello world!
 * @SpringBootApplication:申明让spring boot自动给程序进行必要的配置，等价于以默认属性使用
 *                        @Configuration，@EnableAutoConfiguration和@ComponentScan
 *                        
 * 第二種運行方式：project – Run as – Maven build – 在Goals里输入spring-boot:run ,然后Apply,最后点击Run。                        
 */
@SpringBootApplication
//@ServletComponentScan  //@ServletComponentScan是的spring能够扫描到我们自己编写的servlet和filter。

//不在 Spring Boot 的扫描包下方式二,而且在 SpringUtil 是不需要添加 @Component 注解   
//@Import(value={SpringUtil.class})
public class App 
{   
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
    /**
     * 注册Spring Util
     * 这里为了和上一个冲突，所以方面名为：springUtil2
     * 实际中使用springUtil 
     * @return
     */
    @Bean
    public SpringUtil springUtil2(){
    	return new SpringUtil();
    }
}

/**
 * 静态资源访问默认配置的
 * 优先级顺序
 * 为：META/resources > resources > static > public (已进行测试)
 */
 