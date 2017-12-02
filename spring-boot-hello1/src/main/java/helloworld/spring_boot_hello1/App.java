package helloworld.spring_boot_hello1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 * @SpringBootApplication:申明让spring boot自动给程序进行必要的配置，等价于以默认属性使用
 *                        @Configuration，@EnableAutoConfiguration和@ComponentScan
 *                        
 * 第二種運行方式：project – Run as – Maven build – 在Goals里输入spring-boot:run ,然后Apply,最后点击Run。                        
 */
@SpringBootApplication
public class App 
{   
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}

/**
 * 静态资源访问默认配置的
 * 优先级顺序
 * 为：META/resources > resources > static > public (已进行测试)
 */
 