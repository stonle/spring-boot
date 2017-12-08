package com.kfit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 (1)新建一个工程;
（2）在App.java类编写HelloService2;
（3）在App.java类无法扫描的包下编写HelloService;
（4）编写application-bean.xml注入HelloService;
（5）编写ConfigClass注入配置文件application-bean.xml;
（6）编写App.java启动类进行测试；
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}
