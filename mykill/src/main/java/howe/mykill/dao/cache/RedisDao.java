package howe.mykill.dao.cache;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

import howe.mykill.entity.Mykill;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by codingBoy on 17/2/17.
 */
public class RedisDao {
    private final JedisPool jedisPool;

    public RedisDao(String ip, int port) {
        jedisPool = new JedisPool(ip, port);
    }

    private RuntimeSchema<Mykill> schema = RuntimeSchema.createFrom(Mykill.class);


    public Mykill getMykill(long mykillId) {
        //redis操作逻辑
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "mykill:" + mykillId;
                //并没有实现哪部序列化操作
                //采用自定义序列化
                //protostuff: pojo.
                byte[] bytes = jedis.get(key.getBytes());
                //缓存重获取到
                if (bytes != null) {
                    Mykill mykill=schema.newMessage();
                    ProtostuffIOUtil.mergeFrom(bytes,mykill,schema);
                    //mykill被反序列化

                    return mykill;
                }
            }finally {
                jedis.close();
            }
        }catch (Exception e) {

        }
        return null;
    }

    public String putMykill(Mykill mykill) {
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "mykill:" + mykill.getMykillId();
                byte[] bytes = ProtostuffIOUtil.toByteArray(mykill, schema,
                        LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                //超时缓存
                int timeout = 60 * 60;//1小时
                String result = jedis.setex(key.getBytes(),timeout,bytes);

                return result;
            }finally {
                jedis.close();
            }
        }catch (Exception e) {

        }

        return null;
    }
}
