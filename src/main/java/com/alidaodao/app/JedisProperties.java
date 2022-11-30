package com.alidaodao.app;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jack
 * redis client
 */
@Configuration
@ConfigurationProperties(prefix = Constants.PROP_SUFFIX)
public class JedisProperties {
    /**
     * need open
     */
    private boolean enable;

    /**
     * host地址
     */
    private String redisHost = "127.0.0.1";

    /**
     * 端口号
     */
    private int redisPort = 6379;
    /**
     * 密码
     */
    private String redisPwd;
    /**
     * 资源池中的最大连接数
     *
     * maxTotal（最大连接数）
     *
     * 想合理设置maxTotal（最大连接数）需要考虑的因素较多，如：
     *
     * 业务希望的Redis并发量；
     * 客户端执行命令时间；
     * Redis资源，例如nodes （如应用节点个数等） * maxTotal不能超过Redis的最大连接数（可在实例详情页面查看）；
     * 资源开销，例如虽然希望控制空闲连接，但又不希望因为连接池中频繁地释放和创建连接造成不必要的开销。
     * 假设一次命令时间，即borrow|return resource加上Jedis执行命令 （ 含网络耗时）的平均耗时约为1ms，一个连接的QPS大约是1s/1ms = 1000，而业务期望的单个Redis的QPS是50000（业务总的QPS/Redis分片个数），那么理论上需要的资源池大小（即MaxTotal）是50000 / 1000 = 50。
     *
     * 但事实上这只是个理论值，除此之外还要预留一些资源，所以maxTotal可以比理论值大一些。这个值不是越大越好，一方面连接太多会占用客户端和服务端资源，另一方面对于Redis这种高QPS的服务器，如果出现大命令的阻塞，即使设置再大的资源池也无济于事。
     *
     */
    private int maxTotal = 8;
    /**
     * 资源池允许的最大空闲连接数
     *
     * maxIdle与minIdle
     *
     * maxIdle实际上才是业务需要的最大连接数，maxTotal 是为了给出余量，所以 maxIdle 不要设置得过小，否则会有new Jedis（新连接）开销，而minIdle是为了控制空闲资源检测。
     *
     * 连接池的最佳性能是maxTotal=maxIdle，这样就避免了连接池伸缩带来的性能干扰。如果您的业务存在突峰访问，建议设置这两个参数的值相等；如果并发量不大或者maxIdle设置过高，则会导致不必要的连接资源浪费。
     *
     * 您可以根据实际总QPS和调用Redis的客户端规模整体评估每个节点所使用的连接池大小。
     */
    private int maxIdle = 8;
    /**
     * 资源池确保的最少空闲连接数
     */
    private int minIdle = 0;
    /**
     * 当资源池用尽后，调用者是否要等待。只有当值为true时，下面的maxWaitMillis才会生效。
     */
    private boolean blockWhenExhausted = true;

    /**
     * 当资源池连接用尽后，调用者的最大等待时间（单位为毫秒）。-1 代表永不过时直到获取链接;默认为10S
     */
    private int maxWaitMillis = 10000;
    /**
     * 连接超时又是读写超时
     */
    private int timeout = 20000;
    /**
     * 向资源池借用连接时是否做连接有效性检测（ping）。检测到的无效连接将会被移除。	 业务量很大时候建议设置为false，减少一次ping的开销。
     */
    private boolean testOnBorrow = false;
    /**
     * 向资源池归还连接时是否做连接有效性检测（ping）。检测到无效连接将会被移除。	业务量很大时候建议设置为false，减少一次ping的开销。
     */
    private boolean testOnReturn = false;

    /**
     * need init redis index db,example: 1,2,3,4,5
     */
    private Integer[] indexes;
    /**
     * default index
     */
    private int defaultIndex;

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

    public String getRedisPwd() {
        return redisPwd;
    }

    public void setRedisPwd(String redisPwd) {
        this.redisPwd = redisPwd;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
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

    public boolean isBlockWhenExhausted() {
        return blockWhenExhausted;
    }

    public void setBlockWhenExhausted(boolean blockWhenExhausted) {
        this.blockWhenExhausted = blockWhenExhausted;
    }

    public int getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public void setMaxWaitMillis(int maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public boolean isTestOnReturn() {
        return testOnReturn;
    }

    public void setTestOnReturn(boolean testOnReturn) {
        this.testOnReturn = testOnReturn;
    }

    public Integer[] getIndexes() {
        return indexes;
    }

    public void setIndexes(Integer[] indexes) {
        this.indexes = indexes;
    }

    public int getDefaultIndex() {
        return defaultIndex;
    }

    public void setDefaultIndex(int defaultIndex) {
        this.defaultIndex = defaultIndex;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
