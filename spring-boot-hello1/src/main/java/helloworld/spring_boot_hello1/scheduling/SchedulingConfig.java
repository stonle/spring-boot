package helloworld.spring_boot_hello1.scheduling;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
/**
 *  Spring Boot 中如何使用定时任务
 * @author Administrator
 * 其中 @EnableScheduling 注解的作用是发现注解@Scheduled的任务并后台执行。
 */
@Configuration
@EnableScheduling
public class SchedulingConfig {
   @Scheduled(cron = "0/20 * * * * ?") // 每20秒执行一次
   public void scheduler() {
	   System.out.println(">>>>>>>>> SchedulingConfig.scheduler()");
   }
}
