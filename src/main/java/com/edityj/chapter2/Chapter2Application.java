package com.edityj.chapter2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

@SpringBootApplication
@MapperScan(
        basePackages = "com.edityj.chapter2.mapper.*",
        sqlSessionFactoryRef = "sqlSessionFactory",
        sqlSessionTemplateRef = "sqlSessionTemplate",
        annotationClass = Repository.class
)
public class Chapter2Application {
    public static void main(String[] args) {
        SpringApplication.run(Chapter2Application.class, args);
    }
}
