package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


import java.util.Date;

@SpringBootApplication
public class DemoApplication {
	private static final Logger LOGGER=  LoggerFactory.getLogger(DemoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Scheduled(initialDelay = 1000L,fixedDelayString = "${someJob.delay}")
	void someJob() throws InterruptedException{
		LOGGER.info("Now is"+new Date());
		Thread.sleep(100L);
	}
	@Scheduled(fixedRate = 1000L)
	void someJob2() throws InterruptedException{
		LOGGER.info("Now job2  is"+new Date());

	}


}
@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "scheduling.enabled",matchIfMissing = true)
class SchedulingConfiguration{

}