package test.connect;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @author: Forever丶诺
 * @createTime: 2018-6-24.14:16
 */
@Slf4j
public class JedisTest {

    @Test
    public void test() {
        Jedis jedis = new Jedis("192.168.0.170", 6379);
        log.info(jedis.ping());
    }


}
