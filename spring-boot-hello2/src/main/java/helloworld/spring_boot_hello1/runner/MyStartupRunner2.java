package helloworld.spring_boot_hello1.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
/**
 * Spring Boot应用程序在启动后，会遍历CommandLineRunner接口的实例并运行它们的run方法。也可以利用
 * @Order注解（或者实现Order接口）来规定所有CommandLineRunner实例的运行顺序。
 * @author Administrator
 *
 */
@Component
@Order(value = 1)
public class MyStartupRunner2 implements CommandLineRunner {
    /**
     * 这里的args就是程序启动的时候进行设置的:
     * SpringApplication.run(App.class, new String[]{"hello,","林峰"});
     * 这里为了做演示，配置为固定值了，其实直接接收main中的args即可，那么在运行的时候，进行配置即可。
     */
	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作 22222222<<<<<<<<<<<<<");
	}

}
