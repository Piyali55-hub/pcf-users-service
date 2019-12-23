package com.example.pcfdemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@EnableDiscoveryClient
public class PcfDemoApplication {

	public static void main(String[] args) {
		run(PcfDemoApplication.class, args);
	}

}
