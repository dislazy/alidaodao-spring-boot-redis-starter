package com.alidaodao.app;

import com.alidaodao.app.config.RedisConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Jack
 * redis client
 */
@Configuration
@EnableConfigurationProperties(JedisProperties.class)
@ConditionalOnClass(RedisClient.class)
@ConditionalOnProperty(prefix="spring.jedis",value="enabled",matchIfMissing=true)
public class RedisServiceAutoConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisServiceAutoConfiguration.class);

    @Autowired
    private JedisProperties redisProperties;

    @Bean(value = "redisClient")
    @ConditionalOnMissingBean(RedisClient.class)
    public RedisClient redisClient() {
        if (!redisProperties.isEnable()) {
            LOGGER.error("[REDIS-CLIENT] redis enable is false");
            return null;
        }
        if (Objects.isNull(redisProperties.getIndexes()) || redisProperties.getIndexes().length <= 0) {
            LOGGER.error("[REDIS-CLIENT] redis indexes is empty");
            return null;
        }
        RedisConfig redisConfig = new RedisConfig();
        redisConfig.setRedisHost(redisProperties.getRedisHost());
        redisConfig.setRedisPort(redisProperties.getRedisPort());
        redisConfig.setRedisPwd(redisProperties.getRedisPwd());
        redisConfig.setMaxTotal(redisProperties.getMaxTotal());
        redisConfig.setMaxIdle(redisProperties.getMaxIdle());
        redisConfig.setMinIdle(redisProperties.getMinIdle());
        redisConfig.setBlockWhenExhausted(redisProperties.isBlockWhenExhausted());
        redisConfig.setMaxWaitMillis(redisProperties.getMaxWaitMillis());
        redisConfig.setTimeout(redisProperties.getTimeout());
        redisConfig.setTestOnBorrow(redisProperties.isTestOnBorrow());
        redisConfig.setTestOnReturn(redisProperties.isTestOnReturn());
        redisConfig.setTestOnCreate(redisProperties.isTestOnCreate());
        redisConfig.setTestWhileIdle(redisProperties.isTestWhileIdle());
        redisConfig.setJmxEnabled(redisProperties.isJmxEnabled());
        redisConfig.setNumTestsPerEvictionRun(redisProperties.getNumTestsPerEvictionRun());
        redisConfig.setTimeBetweenEvictionRuns(redisProperties.getTimeBetweenEvictionRuns());
        redisConfig.setMinEvictableIdleTimeMillis(redisProperties.getMinEvictableIdleTimeMillis());

        //????????????????????????redis db??????
        Set<Integer> redisDbIndex = Arrays.stream(redisProperties.getIndexes()).collect(Collectors.toSet());
        RedisClient redisClient = new RedisClient(redisConfig, redisDbIndex);
        redisClient.setDefaultIndex(redisProperties.getDefaultIndex());
        LOGGER.info("[REDIS-CLIENT]redis client init success,you can use indexes: {}", redisDbIndex);
        return redisClient;
    }
}
