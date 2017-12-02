package helloworld.spring_boot_hello1.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 返回JSON之步骤
 *   1、编写一个实体类Demo
 *   2、编写DemoController
 *   3、在DemoController加上@RestController和@RequestMapping注解；
 *   4、测试
 * @author Administrator
 *
 */
@RestController  //标记为：restfull
public class HelloControoler {
    @RequestMapping("/")
	public String hello(){
	   return "Hello World!";
   }
}
