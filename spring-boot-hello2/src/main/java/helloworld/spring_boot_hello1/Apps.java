package helloworld.spring_boot_hello1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//入口启动不能一样，不然一直报警告
@SpringBootApplication
public class Apps 
{   
    public static void main( String[] args )
    {
    	SpringApplication.run(Apps.class, args);
    }

}

 