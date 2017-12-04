package helloworld.spring_boot_hello1.servlet;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.support.http.WebStatFilter;

/**
 * 以上配置的监控方式是使用了原生的servlet，filter方式，然后通过@ServletComponentScan进行启动扫描包的方式
 * 进行处理的，你会发现我们的servlet，filter根本没有任何的编码
 * 配置Filter
 *    druid过滤器.
 * @author Administrator
 *
 */
@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
initParams={
@WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源
}
)
public class DruidStatFilter extends WebStatFilter{

}
