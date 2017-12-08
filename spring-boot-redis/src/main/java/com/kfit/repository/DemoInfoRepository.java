package com.kfit.repository;

import org.springframework.data.repository.CrudRepository;

import com.kfit.bean.DemoInfo;
/**
 * DemoInfo持久化类
 * @author Administrator
 *
 */
public interface DemoInfoRepository extends CrudRepository<DemoInfo, Long>{

}
