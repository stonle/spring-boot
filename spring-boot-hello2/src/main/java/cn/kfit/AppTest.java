package cn.kfit;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/**
 * 这时候你会发现，在 App.java 同包下的都没有被扫描了，所以如果也希望 App.java 包下的也同
 * 时被扫描的话，那么在进行指定包扫描的时候一定要进行指定配置：
 * @author Administrator
 *
 */
@SpringBootApplication//这个必不能少
@ComponentScan(basePackages={"cn.kfit","org.kfit"})
public class AppTest {
   public static void main(String[] args) {
	   //第一种方式：修改的时候，进行设置,在Application的main方法中
	  // SpringApplication.run(AppTest.class, args);
	   SpringApplication application = new SpringApplication(AppTest.class);
	   /*
	   * Banner.Mode.OFF:关闭;
	   * Banner.Mode.CONSOLE:控制台输出，默认方式;
	   * Banner.Mode.LOG:日志输出方式;
	   */
	   application.setBannerMode(Mode.OFF);
	   application.run(args);
	   /**
	    *   在application.properties进行配置
		*	在application.proerpties进行banner的显示和关闭：
		*	### 是否显示banner，可选值[true|false]
		*	spring.main.show-banner=false
	    */
   }
}
