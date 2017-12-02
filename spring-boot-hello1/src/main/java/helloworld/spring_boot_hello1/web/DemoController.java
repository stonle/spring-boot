package helloworld.spring_boot_hello1.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import helloworld.spring_boot_hello1.bean.Demo;

/**
 * 测试
 * 其实Spring Boot也是引用了JSON解析包Jackson，
 * 那么自然我们就可以在Demo对象上使用
 * Jackson提供的json属性的注解，对时间进行格式化，对一些字段进行忽略等等
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
	/**
	 * 返回demo数据:
	 * 请求地址：http://127.0.0.1:8080/demo/getDemo
	 * @return
	 */
	@RequestMapping("/getDemo")
    public Demo getDemo(){
    	Demo demo = new Demo();
    	demo.setId(1);
    	demo.setName("Angel");
    	return demo;
    }
	//地址：http://127.0.0.1:8080/demo/getFastJson
	@RequestMapping("/getFastJson")
	public String getFastJson(){
		Demo demo = new Demo();
		demo.setId(2);
		demo.setName("Angel2");
		return JSONObject.toJSONString(demo);
	}
	//地址：http://127.0.0.1:8080/demo/zeroException
	@RequestMapping("/zeroException")
	public int zeroException(){
	   return 100/0;
	}
}
