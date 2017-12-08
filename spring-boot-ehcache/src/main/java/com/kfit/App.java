package com.kfit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring-boot-ehcache
 *  （1）新建Maven Java Project
	（2）在pom.xml中加入依赖包
	（3）编写Spring Boot启动类；
	（4）配置application.properties;
	（5）编写缓存配置类以及ehcache.xml配置文件；
	（6）编写DemoInfo实体类进行测试；
	（7）编写持久类DemoInfoRepository;
	（8）编写处理类DemoInfoService;
	（9）编写DemoInfoController测试类
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
        //获取java的临时目录
    	String folder=System.getProperty("java.io.tmpdir");
    	System.out.println(folder);
    }
}
