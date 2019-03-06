package com.edityj.chapter2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@SpringBootApplication
@MapperScan(
        basePackages = "com.edityj.chapter2.mapper",
        sqlSessionFactoryRef = "sqlSessionFactory",
        sqlSessionTemplateRef = "sqlSessionTemplate",
        annotationClass = Repository.class
)
public class Chapter2Application {

    @Autowired
    private RedisTemplate redisTemplate = null;

    @PostConstruct
    public void init(){
        initRedisTemplate();
    }

    private void initRedisTemplate(){
        RedisSerializer serializer = redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(serializer);
        redisTemplate.setHashKeySerializer(serializer);
    }

    public static void main(String[] args) {
        SpringApplication.run(Chapter2Application.class, args);
    }
}
