package test.jedisPool;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisSentinelPool;
import sun.rmi.runtime.Log;

import java.util.HashSet;

/**
 * @author: Forever丶诺
 * @createTime: 2018-6-24.18:40
 */
@Slf4j
public class JedisPoolTest {


    @Test
    public void test() {

        JedisPool jedisPool = JedisPoolUtil.getJedisPool();
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            log.info(jedis.get("k1"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }

    }
}
