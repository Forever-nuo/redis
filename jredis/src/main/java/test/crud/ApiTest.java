package test.crud;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @author: Forever丶诺
 * @createTime: 2018-6-24.16:00
 */
@Slf4j
public class ApiTest {
    Jedis jedis = new Jedis("192.168.0.170", 6380);
    @Test
    public void testSetString() {
        jedis.set("k1","v1");
        jedis.set("k2","v2");
        jedis.set("k3","v3");
    }


    @Test
    public void testGetValue() {
        String k3 = jedis.get("k3");
        log.info(k3);
    }


    /**
     * 类似 keys *
     */
    @Test
    public void testKeys() {
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            log.info(key);
        }
    }
}
