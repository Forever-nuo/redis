package test.ms;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;

/**
 * @author: Forever丶诺
 * @createTime: 2018-6-24.19:05
 */
public class JedisMS2Test {


    @Test
    public void test() throws InterruptedException {
        String ip = "192.168.0.170:";
        HashSet<String> hosts = new HashSet<>();
        hosts.add(ip+"26379");
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(1000);
        config.setMaxIdle(10);
        config.setMinIdle(1);
        config.setMaxWaitMillis(30000);
        config.setTestOnBorrow(true);

        config.setTestOnReturn(true);
        config.setTestWhileIdle(true);
        JedisSentinelPool jedisSentinelPool = new JedisSentinelPool("host6379", hosts,config);


        Jedis jedis = null;
        while (true) {
            try {
                jedis = jedisSentinelPool.getResource();
                jedis.set("k1","v1");
                String key1 = jedis.get("k1");
                System.out.println(key1);
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }
}
