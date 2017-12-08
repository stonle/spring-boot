package com.kfit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *spring boot启动类
 * 
 * 
 *  配置application.properties;
 *  这里主要是配置两个资源，第一就是数据库基本信息；第二就是redis配置；第三就是JPA的配置；
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    	//getRedisConnection();
    }
    
/*    //連接redis測試
    public static void getRedisConnection(){
    	   Jedis jedis = RedisUtil.getJedis();
    	    //-----添加数据----------  
    	   jedis.set("name","xinxin");//向key-->name中放入了value-->xinxin  
    	   System.out.println(jedis.get("name"));//执行结果：xinxin 
    }*/
}
