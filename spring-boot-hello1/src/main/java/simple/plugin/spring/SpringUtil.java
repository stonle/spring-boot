package simple.plugin.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 不在 Spring Boot 的扫描包下方式一
 * 
 * 之后这一步才是关键， 使用@Bean注解，在App.java类中将SpringUtil 注解进来
 * @author Administrator
 *
 */
public class SpringUtil implements ApplicationContextAware{
	private static ApplicationContext applicationContext = null;
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub
		if(SpringUtil.applicationContext == null){
			SpringUtil.applicationContext = applicationContext;
		}
		System.out.println("---------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("---------------simple.plugin.spring.SpringUtil------------------------------------------------------");
		System.out.println("========ApplicationContext配置成功,在普通类可以通过调用SpringUtils.getAppContext()获取applicationContext对象,applicationContext="+SpringUtil.applicationContext+"========");
		System.out.println("---------------------------------------------------------------------");
   }
	//获取applicationContext
	public static ApplicationContext getApplicationContext() {
	    return applicationContext;
	}
	//通过name获取 Bean.
	public static Object getBean(String name){
	    return getApplicationContext().getBean(name);
	}
	
	//通过class获取Bean.
	public static <T> T getBean(Class<T> clazz){
	   return getApplicationContext().getBean(clazz);
	}
	//通过name,以及Clazz返回指定的Bean
	public static <T> T getBean(String name,Class<T> clazz){
	    return getApplicationContext().getBean(name, clazz);
	}
}
