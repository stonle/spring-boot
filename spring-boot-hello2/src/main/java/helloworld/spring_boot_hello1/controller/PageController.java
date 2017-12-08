package helloworld.spring_boot_hello1.controller;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;

/**
 * @Controller @Service 等被Spring管理的类都支持，注意重写的方法 setEnvironment 是在系统启动的时候被执行。
 * 或者如下Controller：
 * @author Administrator
 *
 */
@Controller
public class PageController implements EnvironmentAware {

	@Override
	public void setEnvironment(Environment environment) {
		// TODO Auto-generated method stub
		String s = environment.getProperty("JAVA_HOME");
		System.out.println(s);
	}

}
