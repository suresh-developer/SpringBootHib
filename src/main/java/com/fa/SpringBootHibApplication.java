package com.fa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.fa.config.JpaConfiguration;
import com.fa.config.WebConfig;

@Import({JpaConfiguration.class,WebConfig.class})
@SpringBootApplication(scanBasePackages= {"com.fa"})
public class SpringBootHibApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibApplication.class, args);
	}
}
