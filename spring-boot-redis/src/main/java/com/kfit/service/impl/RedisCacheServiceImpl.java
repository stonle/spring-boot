///*package com.kfit.service.impl;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import javax.annotation.Resource;
//
//import org.springframework.data.redis.core.BoundSetOperations;
//import org.springframework.data.redis.core.HashOperations;
//import org.springframework.data.redis.core.ListOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.stereotype.Service;
//
//import com.kfit.service.RedisCacheSercie;
//@Service
//public class RedisCacheServiceImpl<T> implements RedisCacheSercie<T> {
//	@SuppressWarnings("rawtypes")
//	@Resource
//	public RedisTemplate redisTemplate;
//	@Override
//	public <T> ValueOperations<String, T> setCacheObject(String key, T value) {
//		@SuppressWarnings("unchecked")
//		ValueOperations<String, T> operation = (ValueOperations<String, T>) redisTemplate.opsForValue();
//		operation.set(key, value);
//		return null;
//	}
//
//	@Override
//	public <T> T getCacheObject(String key) {
//		return null;
//	}
//
//	@Override
//	public <T> ListOperations<String, T> setCacheList(String key, List<T> dataList) {
//		return null;
//	}
//
//	@Override
//	public <T> List<T> getCacheList(String key) {
//		return null;
//	}
//
//	@Override
//	public <T> BoundSetOperations<String, T> setCacheSet(String key, Set<T> dataSet) {
//		return null;
//	}
//
//	@Override
//	public Set<T> getCacheSet(String key) {
//		return null;
//	}
//
//	@Override
//	public <T> HashOperations<String, String, T> setCacheMap(String key, Map<String, T> dataMap) {
//		return null;
//	}
//
//	@Override
//	public <T> Map<String, T> getCacheMap(String key) {
//		return null;
//	}
//
//	@Override
//	public <T> HashOperations<String, Integer, T> setCacheIntegerMap(String key, Map<Integer, T> dataMap) {
//		return null;
//	}
//
//	@Override
//	public <T> Map<Integer, T> getCacheIntegerMap(String key) {
//		return null;
//	}
//
//}