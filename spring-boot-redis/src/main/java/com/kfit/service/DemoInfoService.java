package com.kfit.service;

import com.kfit.bean.DemoInfo;

public interface DemoInfoService {
	public DemoInfo findById(long id);
	public void deleteFromCache(long id);
	void test();
	public String ObjectByKey(String key);
}
