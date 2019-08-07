package com.aaa.ysemm;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableTransactionManagement
@SpringBootApplication
@MapperScan({"com.aaa.ysemm.customer.dao","com.aaa.ysemm.manage.dao"})
public class DemoApplication {

	public static void main(String[] args) {
;		SpringApplication.run(DemoApplication.class, args);
	}

}
