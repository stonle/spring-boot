package helloworld.spring_boot_hello1.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import helloworld.spring_boot_hello1.bean.Demo;
import helloworld.spring_boot_hello1.dao.DemoDao;
import helloworld.spring_boot_hello1.dao.DemoRepository;

/**
 *  提供Demo服务类.
 * @author Administrator
 *
 */
@Service
public class DemoService {
    @Resource
	private DemoRepository demoRepository;
    
    @Resource
    private DemoDao demoDao;
    
    @Transactional
    public void save(Demo demo){
    	demoRepository.save(demo);
    }
    
    public Demo getById(long id){
    	//demoRepository.findOne(id);
    	//在demoRepository可以直接使用findOne进行获取.
    	return demoDao.getById(id);
    }
}
