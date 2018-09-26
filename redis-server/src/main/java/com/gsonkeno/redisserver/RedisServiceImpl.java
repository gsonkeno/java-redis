package com.gsonkeno.redisserver;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import redis.clients.jedis.Jedis;


@Service
public class RedisServiceImpl implements RedisService {
	

	@Override
	public void set(String key, String value) {
		Jedis jedis = RedisPool.getConnection();
		jedis.set(key, value);
		jedis.close();
	}

	@Override
	public String vget(String key) {
		Jedis jedis = RedisPool.getConnection();
		String val = jedis.get(key);
		jedis.close();
		return val;
	}
	
	//mget 待优化
	@Override
	public List<String> vmget(Set<String> keys) {
		List<String> list = Lists.newArrayList();
		Jedis jedis = RedisPool.getConnection();
		for (String key : keys) {
			String val = jedis.get(key);
			if(val!=null)
			list.add(val);
		}
		jedis.close();
		return list;
	}

	@Override
	public void delete(String key) {
		Jedis jedis = RedisPool.getConnection();
		jedis.del(key);
		jedis.close();
	}
	
	/**
	 * 将一个或多个值 value 插入到列表 key 的表头
	 * 用这个插入
	 */
	@Override
	public Long lpush(String key,String strings){
		Jedis jedis = RedisPool.getConnection();
		Long number = jedis.lpush(key, strings);
		jedis.close();
		return number;
	}
	
	/**
	 * 移除并返回列表 key 的尾元素
	 * 当 key 不存在时，返回 nil
	 */
	@Override
	public String rpop(String key){
		Jedis jedis = RedisPool.getConnection();
		String rpop = jedis.rpop(key);
		jedis.close();
		return rpop;
	}

	@Override
	public List<String> vbrpop(String key, int timeout){
		Jedis jedis = RedisPool.getConnection();
		List<String> brpop = jedis.brpop(timeout, key);
		jedis.close();
		return brpop;
	}
	
	@Override
	public Map<String, String> hgetall(String key){
		Jedis jedis = RedisPool.getConnection();
		Map<String, String> map = jedis.hgetAll(key);
		jedis.close();
		return map;
	}
	
	@Override
	public void hset(String key, String field, String value){
		Jedis jedis = RedisPool.getConnection();
		jedis.hset(key, field, value);
		jedis.close();
	}
	
	@Override
	public String hget(String key, String field){
		Jedis jedis = RedisPool.getConnection();
		String hget = jedis.hget(key, field);
		jedis.close();
		return hget;
	}
	
	@Override
	public void hdel(String key, String field){
		Jedis jedis = RedisPool.getConnection();
		jedis.hdel(key, field);
		jedis.close();
	}
}
