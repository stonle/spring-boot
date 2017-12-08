package com.kfit.service.impl;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.stereotype.Service;

import com.kfit.bean.DemoInfo;
import com.kfit.repository.DemoInfoRepository;
import com.kfit.service.DemoInfoService;

import javassist.NotFoundException;

/**
 * 
 * @author Administrator
 *
 */
@Service
public class DemoInfoServiceImpl implements DemoInfoService {
    
	//这里的单引号不能少，否则会报错，被识别是一个对象;
	public static final String CACHE_KEY = "'demoInfo'";
	@Resource
	private DemoInfoRepository demoInfoRepository;
	/**
	 *
     * value属性表示使用哪个缓存策略，缓存策略在ehcache.xml
	 */
	public static final String DEMO_CACHE_NAME = "demo";
	/**
	 *  删除数据.
	 */
	@CacheEvict(value = DEMO_CACHE_NAME,key = "'demoInfo_'+#id")//这是清除缓存.
	@Override
	public void delete(Long id) {
		demoInfoRepository.delete(id);
	}
	/**
	 *  在支持Spring Cache的环境下，对于使用@Cacheable标注的方法，Spring在每次执行前都会检查Cache中是否存
		在相同key的缓存元素，如果存在就不再执行该方法，而是直接从缓存中获取结果进行返回，否则才会执行并将返回结
		果存入指定的缓存中。@CachePut也可以声明一个方法支持缓存功能。与@Cacheable不同的是使用@CachePut标注的方
		法在执行前不会去检查缓存中是否存在之前执行过的结果，而是每次都会执行该方法，并将执行结果以键值对的形式存
		入指定的缓存中。
         @CachePut 也可以标注在类上和方法上。使用@CachePut时我们可以指定的属性跟@Cacheable是一样的。
	 */
	@CachePut(value = DEMO_CACHE_NAME,key = "'demoInfo_'+#updated.getId()")
	//@CacheEvict(value = DEMO_CACHE_NAME,key = "'demoInfo_'+#updated.getId()")//这是清除缓存.
	@Override
	public DemoInfo update(DemoInfo updated) throws NotFoundException {
		// 需要注意的是当一个支持缓存的方法在对象内部被调用时是不会触发缓存功能的
		DemoInfo demoInfo = demoInfoRepository.findOne(updated.getId());
		if(demoInfo == null){
		 throw new NotFoundException("No find");
		}
		demoInfo.setName(updated.getName());
		demoInfo.setPwd(updated.getPwd());
		return demoInfo;
	}
	/**
	* 查询数据.
	* value属性指定Cache名称
	* @param id
	* @return
	*  在支持Spring Cache的环境下，对于使用@Cacheable标注的方法，
	*  Spring在每次执行前都会检查Cache中是否存在相同key的缓存元素，
	*  如果存在就不再执行该方法，而是直接从缓存中获取结果进行返回，否则才会执行并将返回结果存入指定的缓存中。
	*  @CachePut也可以声明一个方法支持缓存功能。
	*  与@Cacheable不同的是使用@CachePut标注的方法在执行前不会去检查缓存中是否存在之前执行过的结果，
	*  而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。
	*/
	@Cacheable(value=DEMO_CACHE_NAME,key="'demoInfo_'+#id")
	@Override
	public DemoInfo findById(Long id) {
		System.err.println("没有走缓存！"+id);
		return demoInfoRepository.findOne(id);
	}
    
	/**
	* 保存数据.
	* @param demoInfo
	* 
	* @CacheEvict是用来标注在需要清除缓存元素的方法或类上的。当标记在一个类上时表示其中所有的方法的执行都会触发缓存的清除操作。
	*/
	@CacheEvict(value=DEMO_CACHE_NAME,key=CACHE_KEY)
	@Override
	public DemoInfo save(DemoInfo demoInfo) {
		// TODO Auto-generated method stub
		return demoInfoRepository.save(demoInfo);
	}

}
