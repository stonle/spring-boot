package helloworld.spring_boot_hello1.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import helloworld.spring_boot_hello1.bean.Demo;
import helloworld.spring_boot_hello1.service.DemoService;

@RestController
@RequestMapping("/demo2")
public class Demo2Controller {
	@Resource
	private DemoService demoService;
    /**
     * 测试保存数据方法.
     * 请求地址：http://127.0.0.1:8080/demo2/save
     * @return
     */
	@RequestMapping("/save")
	public String save() {
		Demo d = new Demo();
		d.setName("Angel");
		demoService.save(d);// 保存数据.
		return "ok.Demo2Controller.save";
	}
	
	/**
	 * //地址：http://127.0.0.1:8080/demo2/getById?id=1
	 * @param id
	 * @return
	 */
	@RequestMapping("/getById")
	public Demo getById(@RequestParam long id){
	  return demoService.getById(id);
	}
}
