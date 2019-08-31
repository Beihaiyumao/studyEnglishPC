package com.neusoft.studyEnglish;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.neusoft.studyEnglish.dao")
@ComponentScan("com.neusoft.studyEnglish")
public class StudyEnglishApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyEnglishApplication.class, args);
    }

    //     继承SpringBootServletInitializer 实现configure 方便打war 外部服务器部署。

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StudyEnglishApplication.class);
    }
}
