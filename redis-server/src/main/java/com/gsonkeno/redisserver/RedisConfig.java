package com.gsonkeno.redisserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RedisConfig {

    @Value("${redis.host}")
    private String redisHost;

    @Value("${redis.port}")
    private int redisPort;

    @Value("${redis.pass}")
    private String redisPass;

    @Value("${redis.db}")
    private int redisDb;

    @Value("${redis.min-idle}")
    private int redisMinIdle;

    @Value("${redis.max-idle}")
    private int redisMaxIdle;

    @Value("${redis.max-total}")
    private int redisMaxTotal;

    @Value("${redis.timeout}")
    private int redisTimeout;


    public String getRedisHost() {
        return redisHost;
    }

    public void setRedisHost(String redisHost) {
        this.redisHost = redisHost;
    }

    public int getRedisPort() {
        return redisPort;
    }

    public void setRedisPort(int redisPort) {
        this.redisPort = redisPort;
    }

    public String getRedisPass() {
        return redisPass;
    }

    public void setRedisPass(String redisPass) {
        this.redisPass = redisPass;
    }

    public int getRedisDb() {
        return redisDb;
    }

    public void setRedisDb(int redisDb) {
        this.redisDb = redisDb;
    }

    public int getRedisMinIdle() {
        return redisMinIdle;
    }

    public void setRedisMinIdle(int redisMinIdle) {
        this.redisMinIdle = redisMinIdle;
    }

    public int getRedisMaxIdle() {
        return redisMaxIdle;
    }

    public void setRedisMaxIdle(int redisMaxIdle) {
        this.redisMaxIdle = redisMaxIdle;
    }

    public int getRedisMaxTotal() {
        return redisMaxTotal;
    }

    public void setRedisMaxTotal(int redisMaxTotal) {
        this.redisMaxTotal = redisMaxTotal;
    }

    public int getRedisTimeout() {
        return redisTimeout;
    }

    public void setRedisTimeout(int redisTimeout) {
        this.redisTimeout = redisTimeout;
    }
}
