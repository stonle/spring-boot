package helloworld.spring_boot_hello1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import helloworld.spring_boot_hello1.config.Wisely2Settings;
import helloworld.spring_boot_hello1.config.WiselySettings;
import helloworld.spring_boot_hello1.servlet.MyServlet1;

//入口启动不能一样，不然一直报警告
@SpringBootApplication
@ServletComponentScan//这个就是扫描相应的Servlet包;
@EnableConfigurationProperties({WiselySettings.class,Wisely2Settings.class})//最后注意在spring Boot入口类加上@EnableConfigurationProperties
public class Apps 
{   
    public static void main( String[] args )
    {
    	SpringApplication.run(Apps.class, args);
    }
    @Bean
    public ServletRegistrationBean myServlet1(){
       return new ServletRegistrationBean(new MyServlet1(),"/myServlet/*");
    }

}

 