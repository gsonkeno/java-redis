package com.gsonkeno.redisserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.Jedis;

@SpringBootApplication
public class RedisServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisServerApplication.class, args);
        Jedis jedis = RedisPool.getConnection();
        System.out.println(jedis);
    }
}
