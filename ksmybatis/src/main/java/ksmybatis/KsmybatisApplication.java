package ksmybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableAspectJAutoProxy
@Slf4j
public class KsmybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(KsmybatisApplication.class, args);
//		System.out.println("로깅작업");
//		log.debug("로깅작업-debug");
//		log.info("로깅작업-info");
//		log.warn("로깅작업-warn");
	}

}





