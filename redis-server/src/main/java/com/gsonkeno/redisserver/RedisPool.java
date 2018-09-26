package com.gsonkeno.redisserver;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {

	private static JedisPool pool = null;

	public static Jedis getConnection() {
		if(pool==null){
			synchronized (RedisPool.class) {
				if(pool==null){
					try {
                        System.out.println("开始初始化redis连接池");
                        RedisConfig bean = SpringUtils.getBean(RedisConfig.class);
                        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
						jedisPoolConfig.setMinIdle(bean.getRedisMinIdle());
						jedisPoolConfig.setMaxIdle(bean.getRedisMaxIdle());
						jedisPoolConfig.setMaxTotal(bean.getRedisMaxTotal());
						pool = new JedisPool(jedisPoolConfig, bean.getRedisHost(),
                                bean.getRedisPort(), bean.getRedisTimeout(),
                                bean.getRedisPass(), bean.getRedisDb());
                        System.out.println("初始化redis连接池成功");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		Jedis resource = pool.getResource();
		return resource;
	}
}
