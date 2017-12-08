package com.kfit.repository;

import org.springframework.data.repository.CrudRepository;

import com.kfit.bean.DemoInfo;
/**
 * 操作数据库
 * @author Administrator
 *
 */
public interface DemoInfoRepository extends CrudRepository<DemoInfo, Long> {

}
