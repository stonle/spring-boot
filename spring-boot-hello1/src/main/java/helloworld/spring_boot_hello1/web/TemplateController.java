package helloworld.spring_boot_hello1.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 模板测试
 * 重点：thymeleaf 和 freemarker 是可以共存的。
 * @author Administrator
 *
 */
@Controller
public class TemplateController {
   
	/**
	* 返回html模板.
	*/
	@RequestMapping("/helloHtml")
	public String helloHtml(Map<String,Object> map){
		map.put("hello","from TemplateController.helloHtml");
		return"/helloHtml";
	}
	
	/**
	* 返回html模板.
	*/
	@RequestMapping("/helloFtl")
	public String helloFtl(Map<String,Object> map){
	  map.put("hello","from TemplateController.helloFtl");
	  return"/helloFtl";
	}
}
