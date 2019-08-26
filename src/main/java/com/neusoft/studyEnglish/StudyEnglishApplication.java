package com.neusoft.studyEnglish;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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

}
