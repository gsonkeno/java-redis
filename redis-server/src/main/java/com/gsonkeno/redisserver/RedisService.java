package com.gsonkeno.redisserver;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RedisService {
	
	public void set(String key, String value);
	
	public String vget(String key);
	
	//mget 待优化
	public List<String> vmget(Set<String> keys);
	
	/**
	 * 恒等删除
	 */
	public void delete(String key);
	
	public Long lpush(String key,String strings);
	
	public String rpop(String key);
	
	public List<String> vbrpop(String key, int timeout);
	
	public Map<String, String> hgetall(String key);
	
	public void hset(String key, String filed, String val);
	
	public String hget(String key, String field);
	
	public void hdel(String key, String field);
}
