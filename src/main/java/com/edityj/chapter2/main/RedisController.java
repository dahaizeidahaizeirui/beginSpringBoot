package com.edityj.chapter2.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.ranges.Range;
import redis.clients.jedis.Jedis;

import java.util.*;

@Controller
@RequestMapping("/redis")
public class RedisController {

    private RedisTemplate<String, Object> redisTemplate = null;

    private StringRedisTemplate stringRedisTemplate = null;


    @Autowired
    public RedisController(RedisTemplate redisTemplate, StringRedisTemplate stringRedisTemplate) {
        this.redisTemplate = redisTemplate;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    /**
     * 操作redis字符串和散列数据类型
     *
     * @return 操作是否成功
     */
    @RequestMapping("/stringAndHash")
    @ResponseBody
    public Map<String, Object> testStringAndHash() {
        redisTemplate.delete("key1");
        redisTemplate.delete("int_key");
        redisTemplate.delete("int");
        redisTemplate.delete("hash");
        System.out.println("清除旧数据成功");

        redisTemplate.opsForValue().set("key1", "value1");
        //注意这里使用了jdk的序列化器，所以redis保存的不是整数不能运算
        redisTemplate.opsForValue().set("int_key", "1");
        System.out.println("1==> " + redisTemplate.opsForValue().get("int_key"));
        System.out.println("2==> " + redisTemplate.opsForValue().get("key1"));


        stringRedisTemplate.opsForValue().set("int", "1");
//        不能使用redisTemplate来获取stringRedisTemplate存储的数据，
//        序列号对象生成这个字节数组的方法是否与默认的反序列化方法相对应；应该就是对称性吧 ，
//        你用A方法对B进行序列化然后用不对称的反序列化方法C进行反序列号 ， 肯定会有问题 。
//        System.out.println("3==> "+redisTemplate.opsForValue().get("int"));
        System.out.println("4==> " + stringRedisTemplate.opsForValue().get("int"));
//        使用运算+1
        stringRedisTemplate.opsForValue().increment("int", 1);
        System.out.println("5==> " + stringRedisTemplate.opsForValue().get("int"));
//        获取底层jedis连接
        Jedis jedis = (Jedis) stringRedisTemplate.getConnectionFactory().getConnection().getNativeConnection();
//        减一操作，这个命令redistemplate不支持，所以我先获取底层的连接再操作
        jedis.decr("int");
//        System.out.println("6==> "+redisTemplate.opsForValue().get("int"));
        System.out.println("7==> " + stringRedisTemplate.opsForValue().get("int"));


        Map<String, String> hash = new HashMap<>();
        hash.put("field1", "value1");
        hash.put("field2", "value2");
//        存入一个散列数据类型
        stringRedisTemplate.opsForHash().putAll("hash", hash);
//        新增一个字段
        stringRedisTemplate.opsForHash().put("hash", "field3", "value3");

        //批量获取键值实验
//        List<Object> keys = new ArrayList<>();
//        keys.add("field1");
//        keys.add("field2");
//        keys.add("field3");
//        System.out.println("8==> "+stringRedisTemplate.opsForHash().multiGet("hash", keys));


//        绑定散列操作的key,这样可以连续对同一散列数据类型进行操作
        BoundHashOperations hashOperations = stringRedisTemplate.boundHashOps("hash");
//        删除两个字段
        hashOperations.delete("field1", "field2");
//        新增一个字段
        hashOperations.put("filed4", "value5");
        System.out.println("9==> " + stringRedisTemplate.opsForHash().get("hash", "filed4"));

        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }


    /**
     * 操作(列表)链表
     *
     * @return 操作是否成功
     */
    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> testList() {
//        插入两个列表，注意他们在链表的顺序
//        链表从左到右的顺序为v10, v8, v6, v4, v2
        stringRedisTemplate.opsForList().leftPushAll("list1", "v2", "v4", "v6", "v8", "v10");
//        链表从左到右的顺序为v1, v2, v3, v4, v5, v6
        stringRedisTemplate.opsForList().rightPushAll("list2", "v1", "v2", "v3", "v4", "v5", "v6");


//        绑定list2操作
        BoundListOperations<String, String> listOperations = stringRedisTemplate.boundListOps("list2");
//        从右边弹出一个成员
        Object result1 = listOperations.rightPop();
//        获取定位元素，redis从零开始计算，这里的值为v2
        Object result2 = listOperations.index(1);
        System.out.println("1===>" + result2);
//        从左边插入链表
        listOperations.leftPush("v0");
//        求链表长度
        Long size = listOperations.size();
//        求链表下标区间成员，整个链表下标范围为0到size-1, 这里不取最后一个元素
        if (size != null && size >= 2) {
            List elements = listOperations.range(0, size - 2);
        }


        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }


    /**
     * 操作集合
     * @return 操作是否成功
     */
    @RequestMapping("/set")
    @ResponseBody
    public Map<String, Object> testSet() {
//        这里v1重复两次，因为集合不允许重复，所以只是插入五个成员到集合当中
        stringRedisTemplate.opsForSet().add("set1", "v1", "v1", "v2", "v3", "v4", "v5");
        stringRedisTemplate.opsForSet().add("set2", "v2", "v4", "v6", "v8");


//        绑定set1集合操作
        BoundSetOperations<String, String> boundSetOperations = stringRedisTemplate.boundSetOps("set1");
//        增加两个元素
        boundSetOperations.add("v6", "v7");
//        删除两个元素
        boundSetOperations.remove("v1", "v7");
//        返回所有元素
        Set set1 = boundSetOperations.members();
//        求成员数
        Long size = boundSetOperations.size();
//        求交集
        Set inter = boundSetOperations.intersect("set2");
//        求交集并且运用新集合inter保存
        boundSetOperations.intersectAndStore("set2","inter");
//        求差集
        Set diff = boundSetOperations.diff("set2");
//        求差集并且运用新集合diff保存
        boundSetOperations.diffAndStore("set2","diff");
//        求并集
        Set union = boundSetOperations.union("set2");
//        求并集并且运用新集合union保存
        boundSetOperations.unionAndStore("set2", "union");


        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }


    /**
     * 操作redis有序集合
     * @return 操作是否成功
     */
    @RequestMapping("/zset")
    @ResponseBody
    public Map<String, Object> testZset() {
        Set<ZSetOperations.TypedTuple<String>> typedTupleSet = new HashSet<>();
        for(int i=0; i<=9; i++){
            // 分数
            double score = i*0.1;
            // 创建一个TypedTuple对象用于存入值和分数
            ZSetOperations.TypedTuple<String> typedTuple = new DefaultTypedTuple<>("value"+i,score);
            typedTupleSet.add(typedTuple);
        }

        // 往有序集合插入元素
        stringRedisTemplate.opsForZSet().add("zset1", typedTupleSet);
        //绑定zset1有序集合操作
        BoundZSetOperations<String, String> zSetOperations = stringRedisTemplate.boundZSetOps("zset1");
        // 增加一个元素
        zSetOperations.add("value10", 0.26);
        // 获取范围内的元素
        Set<String> setRange = zSetOperations.range(1,6);
        // 按分数排序获取有序集合
        Set<String> setScore = zSetOperations.rangeByScore(0.2,0.6);


        // 定义值范围
        RedisZSetCommands.Range range = new RedisZSetCommands.Range();
        range.gt("value3"); //大于value3
//        range.gte("value3"); //大于等于
//        range.lt("value3"); //小于
//        range.lte("value3"); //小于等于
        // 按值排序，请注意这个排序是按照字符串排序
        Set<String> setLex = zSetOperations.rangeByLex(range);

        //删除元素
        zSetOperations.remove("value9", "value2");

        // 求分数
        Double score = zSetOperations.score("value8");

        //在下标区间下，按分数排序，同时返回value和score
        Set<ZSetOperations.TypedTuple<String>> rangeSet = zSetOperations.rangeWithScores(1,6);
        //在分数区间下，按分数排序，同时返回value和score
        Set<ZSetOperations.TypedTuple<String>> scoreSet = zSetOperations.rangeByScoreWithScores(1,6);
        //按从大到小排序
        Set<String> reverseSet = zSetOperations.reverseRange(2,8);



        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }
}
