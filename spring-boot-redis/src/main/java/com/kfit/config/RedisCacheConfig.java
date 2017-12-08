package com.kfit.config;

import java.lang.reflect.Method;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 缓存主要有几个要实现的类：其一就是CacheManager缓存管理器；其二就是具体操作实现类；其三就是
 * CacheManager工厂类（这个可以使用配置文件配置的进行注入，也可以通过编码的方式进行实现）；其四就是缓存
 * key生产策略（当然Spring自带生成策略，但是在Redis客户端进行查看的话是系列化的key,对于我们肉眼来说就是感觉
 * 是乱码了，这里我们先使用自带的缓存策略）
 * @author Administrator
 *
 */

/**
 * redis 缓存配置;
 *
 * 注意：RedisCacheConfig这里也可以不用继承：CachingConfigurerSupport，也就是直接一个普通的Class就好了；
 *
 * 这里主要我们之后要重新实现 key的生成策略，只要这里修改KeyGenerator，其它位置不用修改就生效了。
 *
 * 普通使用普通类的方式的话，那么在使用@Cacheable的时候还需要指定KeyGenerator的名称;这样编码的时候比较麻
 * @author Administrator
 *
 */
@Configuration
@EnableCaching //启用缓存，这个注解很重要；
public class RedisCacheConfig extends CachingConfigurerSupport{
	/**
	* 缓存管理器.
	* @param redisTemplate
	* @return
	*/
	@Bean
	public CacheManager cacheManager(RedisTemplate<?,?> redisTemplate) {
		CacheManager cacheManager = new RedisCacheManager(redisTemplate);
		return cacheManager;
	}
	
	/**
	* redis模板操作类,类似于jdbcTemplate的一个类;
	* 虽然CacheManager也能获取到Cache对象，但是操作起来没有那么灵活；
	*
	* 这里在扩展下：RedisTemplate这个类不见得很好操作，我们可以在进行扩展一个我们
	*
	* 自己的缓存类，比如：RedisStorage类;
	*
	* @param factory : 通过Spring进行注入，参数在application.properties进行配置；
	* @return
	*/
	@Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
		redisTemplate.setConnectionFactory(factory);
		//key序列化方式;（不然会出现乱码;）,但是如果方法上有Long等非String类型的话，会报类型转换错误；
		//所以在没有自己定义key生成策略的时候，以下这个代码建议不要这么写，可以不配置或者自己实现
		//ObjectRedisSerializer
		//或者JdkSerializationRedisSerializer序列化方式;
		RedisSerializer<String> redisSerializer = new StringRedisSerializer();//Long类型不可以会出现异常信息;
		redisTemplate.setKeySerializer(redisSerializer);
		redisTemplate.setHashKeySerializer(redisSerializer);
		return redisTemplate;
	}
	/**
	 * RedisCacheConfig这里也可以不用继承：CachingConfigurerSupport，也就是直接一个普通的Class就好了；这
	 * 里主要我们之后要重新实现 key的生成策略，只要这里修改KeyGenerator，其它位置不用修改就生效了。普通使用普
	 * 通类的方式的话，那么在使用@Cacheable的时候还需要指定KeyGenerator的名称;这样编码的时候比较麻烦。
	 */
	
	
	/**
	  * 自定义key.
	  * 此方法将会根据类名+方法名+所有参数的值生成唯一的一个key,即使@Cacheable中的value属性一样，key也会不
	  * 一样。
	  */
	
	@Override
	public KeyGenerator keyGenerator() {

		return new KeyGenerator() {
			@Override
			public Object generate(Object o, Method method, Object... objects) {
				StringBuilder sb = new StringBuilder();
				sb.append(o.getClass().getName());
				sb.append(method.getName());
				for (Object obj : objects) {
				   sb.append(obj.toString());
				}
				System.out.println("keyGenerator=" + sb.toString());
				return sb.toString();
			}
		};
	}
	
	//这时候在redis的客户端查看key的话还是序列化的肉眼看到就是乱码了，那么我改变key的序列方式，这个很简单，
	//redis底层已经有具体的实现类了，我们只需要配置下
}
