package com.kfit.config.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* Shiro 配置
*
Apache Shiro 核心通过 Filter 来实现，就好像SpringMvc 通过DispachServlet 来主控制一样。
既然是使用 Filter 一般也就能猜到，是通过URL规则来进行过滤和权限校验，所以我们需要定义一系列关于URL的规则
和访问权限。
*
* @author Angel(QQ:412887952)
* @version v.0.1
*/
@Configuration
public class ShiroConfiguration {
	/**
	 *（a） ShiroFilterFactoryBean 处理拦截资源文件问题。
	 * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，以为在
	 * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
	 *
		Filter Chain定义说明
		1、一个URL可以配置多个Filter，使用逗号分隔
		2、当设置多个过滤器时，全部验证通过，才视为通过
		3、部分过滤器可指定参数，如perms，roles
	 * @param securityManager
	 * @return
	 */
	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager){
	
		System.out.println("ShiroConfiguration.shirFilter()");
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		// 必须设置 SecurityManager
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		//拦截器.
		Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
		//配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
		filterChainDefinitionMap.put("/logout", "logout");
		
		//配置记住我或认证通过可以访问的地址
		filterChainDefinitionMap.put("/index", "user");
		filterChainDefinitionMap.put("/", "user");
		
		//<!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
		//<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
		filterChainDefinitionMap.put("/**", "authc");
		// 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
		shiroFilterFactoryBean.setLoginUrl("/login");
		// 登录成功后要跳转的链接
		shiroFilterFactoryBean.setSuccessUrl("/index");
		//未授权界面;
		shiroFilterFactoryBean.setUnauthorizedUrl("/403");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}
	/**
	 * （b）：这个必须需要，否则会报错
	 * @return
	 * 
	 * 	/**
	 * 将 myShiroRealm 注入到 securityManager 中：
	 */
	@Bean
	public SecurityManager securityManager(){
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		//设置realm.
		securityManager.setRealm(myShiroRealm());
		
		//注入缓存管理器;
		securityManager.setCacheManager(ehCacheManager());//这个如果执行多次，也是同样的一个对象;
		
		//注入记住我管理器;
		securityManager.setRememberMeManager(rememberMeManager());
		
	    return securityManager;
	}
    
	/**
	 *（c） 身份认证
		在认证、授权内部实现机制中都有提到，最终处理都将交给 Real 进行处理。因为在 Shiro
		中，最终是通过 Realm 来获取应用程序中的用户、角色及权限信息的。通常情况下，在
		Realm 中会直接从我们的数据源中获取 Shiro 需要的验证信息。可以说， Realm 是专用于安全
		框架的 DAO.
		
		认证实现
		Shiro 的认证过程最终会交由 Realm 执行，这时会调用 Realm 的 getAuthenticationInfo(token) 方
		法。
		
		该方法主要执行以下操作 :
			1 、检查提交的进行认证的令牌信息
			2 、根据令牌信息从数据源 ( 通常为数据库 ) 中获取用户信息
			3 、对用户信息进行匹配验证。
			4 、验证通过将返回一个封装了用户信息的 AuthenticationInfo 实例。
			5 、验证失败则抛出 AuthenticationException 异常信息。
			
	    而在我们的应用程序中要做的就是自定义一个 Realm 类，继承 AuthorizingRealm 抽象类，重载
     doGetAuthenticationInfo () ，重写获取用户信息的方法。		
     
     
     
		     在权限管理系统中，有这么几个角色很重要，这个要是不清楚的话，那么就很难理
		解，我们为什么这么编码了。第一是用户表：在用户表中保存了用户的基本信息，账号、
		密码、姓名，性别等；第二是：权限表（资源 + 控制权限）：这个表中主要是保存了用户
		的 URL 地址，权限信息；第三就是角色表：在这个表重要保存了系统存在的角色；第四就
		是关联表：用户 - 角色管理表（用户在系统中都有什么角色，比如 admin ， vip 等），角色 - 权
		限关联表（每个角色都有什么权限可以进行操作）。依据这个理论，我们进行来进行编
		码，很明显的我们第一步就是要进行实体类的创建。在这里我们使用 Mysql 和 JPA 进行操作
		数据库
	 */
	
	
	/**
	 * 身份认证realm;
     * (这个需要自己写，账号密码校验；权限等)
	 * @return
	 */
	@Bean
	public MyShiroRealm myShiroRealm(){
		MyShiroRealm myShiroRealm = new MyShiroRealm();
		myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
		return myShiroRealm;
	}
	/**
	 *  * 凭证匹配器
		* （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
		* 所以我们需要修改下doGetAuthenticationInfo中的代码;
	 * @return
	 */
	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher(){
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
		hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));
		return hashedCredentialsMatcher;
	}
	
	/**
	* 开启shiro aop注解支持.
	* 使用代理方式;所以需要开启代码支持;
	* 第一就是开启 shiro aop 注解支持，这个只需要在 com.kfit.config.shiro.ShiroConfiguration加入如下方法
	* 第二就是在 controller 方法中加入相应的注解：
	* @param securityManager
	* @return
	*/
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager
	securityManager){
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new
		AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}
	
	
	/**
	* shiro缓存管理器;
	* 需要注入对应的其它的实体类中：
	* 1、安全管理器：securityManager
	* 可见securityManager是整个shiro的核心；
	* @return
	*/
	@Bean
	public EhCacheManager ehCacheManager(){
		System.out.println("ShiroConfiguration.getEhCacheManager()");
		EhCacheManager cacheManager = new EhCacheManager();
		cacheManager.setCacheManagerConfigFile("classpath:config/ehcache-shiro.xml");
		return cacheManager;
	}
	
	
	/**
	 * 6). Shiro 记住密码
     *  记住密码实现起来也是比较简单的，主要看下是如何实现的。
     *  
     *  
     *  a、 将 rememberMeManager注入到SecurityManager中
     *      //注入记住我管理器;
            securityManager.setRememberMeManager(rememberMeManager());
     *  b、在 ShiroFilterFactoryBean 添加记住我过滤器
     *      //配置记住我或认证通过可以访问的地址
			filterChainDefinitionMap.put("/index", "user");
			filterChainDefinitionMap.put("/", "user");
     *  
     *  
	 */
	@Bean
	public SimpleCookie rememberMeCookie(){
		System.out.println("ShiroConfiguration.rememberMeCookie()");
		//这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
		SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
		//<!-- 记住我cookie生效时间30天 ,单位秒;-->
		simpleCookie.setMaxAge(259200);
		return simpleCookie;
	}
	/**
	* cookie管理对象;
	* @return
	*/
	@Bean
	public CookieRememberMeManager rememberMeManager(){
		System.out.println("ShiroConfiguration.rememberMeManager()");
		CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
		cookieRememberMeManager.setCookie(rememberMeCookie());
		return cookieRememberMeManager;
	}
}
