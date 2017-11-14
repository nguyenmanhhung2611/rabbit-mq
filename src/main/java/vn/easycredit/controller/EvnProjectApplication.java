package vn.easycredit.controller;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author HienNT
 *
 */

@SpringBootApplication
@ComponentScan(value = "vn.easycredit")
@EnableAutoConfiguration
public class EvnProjectApplication {

	public final static String queueName = "spring-boot-api";

	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}

	public static void main(String[] args) {
		SpringApplication.run(EvnProjectApplication.class, args);
	}
}
