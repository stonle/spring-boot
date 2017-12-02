package helloworld.spring_boot_hello1.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常捕获
 * 1、在class注解上@ControllerAdvice,
 * 2、在方法上注解上@ExceptionHandler(value = Exception.class)，具体代码如下：
 * @author Administrator
 *
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	@ExceptionHandler(value = Exception.class)
	public void defaultErrorHandler(HttpServletRequest req, Exception e) {
		e.printStackTrace();
		System.out.println("GlobalDefaultExceptionHandler.defaultErrorHandler()");
		
		/*
		* 返回json数据或者String数据：
		* 那么需要在方法上加上注解：@ResponseBody
		* 添加return即可。
		*/
		/*
		* 返回视图：
		* 定义一个ModelAndView即可，
		* 然后return;
		* 定义视图文件(比如：error.html,error.ftl,error.jsp);
		*
		*/
	}
}
