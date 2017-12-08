package com.kfit.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kfit.bean.DemoInfo;
import com.kfit.service.DemoInfoService;

import javassist.NotFoundException;

@RestController
public class DemoInfoController {
	@Resource
	private DemoInfoService demoInfoService;
	@RequestMapping("/save")
	public DemoInfo save(){
		//存入两条数据.
		DemoInfo demoInfo = new DemoInfo();
		demoInfo.setName("张三");
		demoInfo.setPwd("123456");
		demoInfoService.save(demoInfo);
		
		demoInfo = new DemoInfo();
		demoInfo.setName("李四");
		demoInfo.setPwd("123456");
		DemoInfo demoInfo3 = demoInfoService.save(demoInfo);
		
		return demoInfo3;
	}
	@RequestMapping("/findById")
	public DemoInfo findById(@RequestParam("id") Long id){
		return demoInfoService.findById(id);
	}
	@RequestMapping("/update")
	public DemoInfo updated() throws Exception{
		//修改数据.
		DemoInfo updated = new DemoInfo();
		updated.setName("李四-updated");
		updated.setPwd("123456");
		updated.setId(2);
		return demoInfoService.update(updated);
	}
	@RequestMapping("/delete")
    public String delete(@RequestParam("id") Long id){
		demoInfoService.delete(id);
		return "ok";
    }
	@RequestMapping("/test")
	public String test(){
		//存入两条数据.
		DemoInfo demoInfo = new DemoInfo();
		demoInfo.setName("张三");
		demoInfo.setPwd("123456");
		DemoInfo demoInfo2 = demoInfoService.save(demoInfo);
		//不走缓存.
		System.out.println(demoInfoService.findById(demoInfo2.getId()));
		//走缓存.
		System.out.println(demoInfoService.findById(demoInfo2.getId()));
		demoInfo = new DemoInfo();
		demoInfo.setName("李四");
		demoInfo.setPwd("123456");
		DemoInfo demoInfo3 = demoInfoService.save(demoInfo);
		//不走缓存.
		System.out.println(demoInfoService.findById(demoInfo3.getId()));
		//走缓存.
		System.out.println(demoInfoService.findById(demoInfo3.getId()));
		System.out.println("============修改数据=====================");
		//修改数据.
		DemoInfo updated = new DemoInfo();
		updated.setName("李四-updated");
		updated.setPwd("123456");
		updated.setId(demoInfo3.getId());
		try {
	     	System.out.println(demoInfoService.update(updated));
		} catch (NotFoundException e) {
		    e.printStackTrace();
		}
		//不走缓存.
		System.out.println(demoInfoService.findById(updated.getId()));
		return"ok";
	}
}
