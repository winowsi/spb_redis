package com.winy.controller;

import com.winy.entity.My;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class MyHandler {
    //注意这里用的是redisTemplate
    //而不是@Qualifier("stringRedisTemplate")是它就会报错is in unnamed module of loader"app"
    @Qualifier("redisTemplate")

    @Autowired
    RedisTemplate template;

    @PostMapping("/sev")
    private void set(@RequestBody My my) {
        template.opsForValue().set("my", my);
    }

    @GetMapping("/get/{key}")
    private My get(@PathVariable("key") String key) {
        return (My) template.opsForValue().get(key);
    }
    @DeleteMapping("/delete/{key}")
    private  boolean delete(@PathVariable("key") String key){
        //通过key删除
        template.delete(key);
        //查询key是否存在，存在返回true不存在返会false
        return template.hasKey(key);
    }

    //基本数据
    @GetMapping("/string/{key}")
    private  String string (@PathVariable("key")String key){
        template.opsForValue().set("str","hello word");
        return (String) template.opsForValue().get(key);
    }
    //列表
    @GetMapping("/listTest")
    private List<String> listTest(){
        ListOperations<String,String> listOperations = template.opsForList();
        //注意此处是后进先出类似站
        //次管道双向
        listOperations.leftPush("list","hello");
        listOperations.leftPush("list","word");
        listOperations.leftPush("list","java");
        //需要取的key用下标截取0到2
        List<String> list = listOperations.range("list", 0, 2);
        return list;
    }
    //Set集合数据唯一
    @GetMapping("/set")
    private Set<String> set(){
        SetOperations<String,String> setOperations = template.opsForSet();
        setOperations.add("set","hello");
        setOperations.add("set","hello");
        setOperations.add("set","word");
        setOperations.add("set","word");
        //通过key直接取出集合
        Set<String> set = setOperations.members("set");
        return set;
    }
    //有序集合
    @GetMapping("/zset")
    private Set<String> zset() {
        ZSetOperations<String, String> zSetOperations = template.opsForZSet();
        zSetOperations.add("zset", "hello", 1);
        zSetOperations.add("zset", "ya", 2);
        zSetOperations.add("zset", "winy", 3);
        Set<String> set = zSetOperations.range("zset", 0, 2);
        return set;
    }
    //hashmap哈希
    @GetMapping("/hash")
    private Map<String, String> hashmap(){
        HashOperations<String,String,String> hashOperations = template.opsForHash();
        Map<String,String> map=new HashMap<>();
        map.put("1","张三");
        map.put("2","张");
        map.put("3","张莫得");
        hashOperations.putAll("Map1",map);
        Map<String, String> map1 = hashOperations.entries("Map1");
        return map1;

    }


}
