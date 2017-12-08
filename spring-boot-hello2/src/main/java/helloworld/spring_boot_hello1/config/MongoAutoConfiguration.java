package helloworld.spring_boot_hello1.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
/*@ConditionOnClass表明该@Configuration仅仅在一定条件下才会被加载，这里的条件是Mongo.class位于类
 *路径上  
 *@EnableConfigurationProperties将Spring Boot的配置文件（application.properties）中的
 *spring.data.mongodb.*属性映射为MongoProperties并注入到MongoAutoConfiguration中。 
 */
@Configuration
//@ConditionalOnClass(Mongo.class)
@EnableConfigurationProperties(MongoProperties.class)
public class MongoAutoConfiguration {

}
