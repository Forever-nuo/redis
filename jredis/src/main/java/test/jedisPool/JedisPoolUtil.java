package test.jedisPool;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 获取JedisPool对象 连接池
 * 单例模式
 *
 * @author: Forever丶诺
 * @createTime: 2018-6-24.18:31
 */
public class JedisPoolUtil {

    private static volatile JedisPool jedisPool;

    //私有化构造函数
    private JedisPoolUtil() {
    }


    //提供静态方法让外界获得实例对象
    public static JedisPool getJedisPool() {
        //双重锁判断
        if (null == jedisPool) {
            synchronized (JedisPoolUtil.class) {
                if (null == jedisPool) {
                    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
                    jedisPoolConfig.setMaxTotal(2000);
                    jedisPoolConfig.setMaxIdle(30);
                    jedisPoolConfig.setMaxWaitMillis(6000);
                    jedisPool = new JedisPool(jedisPoolConfig, "192.168.0.170", 6379);
                }
            }

        }
        return jedisPool;
    }

}
