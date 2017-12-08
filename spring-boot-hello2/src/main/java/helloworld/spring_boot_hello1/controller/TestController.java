package helloworld.spring_boot_hello1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import helloworld.spring_boot_hello1.config.Wisely2Settings;
import helloworld.spring_boot_hello1.config.WiselySettings;

/**
 * 使用定义的properties
 * @author Administrator
 * 在Controller类上加@RestController表示将此类中的所有视图都以JSON方式显示，类似于在视图方法上加@ResponseBody
 */
@Controller
public class TestController {
	@Autowired
	WiselySettings wiselySettings;
	@Autowired
	Wisely2Settings wisely2Settings;
	@RequestMapping("/test")
	public @ResponseBody String test(){
		System.out.println(wiselySettings.getGender()+"---"+wiselySettings.getName());
		System.out.println(wisely2Settings.getGender()+"==="+wisely2Settings.getGender());
		return "ok";
	}
}
