package com.zy.springboottest.config.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RedisClusterProperties {
    @Value("${spring.redis.cluster.nodes}")
    private List<String> nodes;
    @Value("${spring.redis.cluster.max-redirects:8}")
    private Integer maxRedirects;
    @Value("${spring.redis.jedis.pool.max-active:8}")
    private int maxActive;
    @Value("${spring.redis.jedis.pool.max-idle:8}")
    private int maxIdle;
    @Value("${spring.redis.jedis.pool.min-idle:8}")
    private int minIdle;
    @Value("${spring.redis.jedis.pool.max-wait:10000}")
    private int maxWait;

    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }

    public Integer getMaxRedirects() {
        return maxRedirects;
    }

    public void setMaxRedirects(Integer maxRedirects) {
        this.maxRedirects = maxRedirects;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public int getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(int maxWait) {
        this.maxWait = maxWait;
    }
}
