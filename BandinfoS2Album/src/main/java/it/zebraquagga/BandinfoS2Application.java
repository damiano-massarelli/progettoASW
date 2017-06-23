package it.zebraquagga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BandinfoS2Application {

	public static void main(String[] args) {
		SpringApplication.run(BandinfoS2Application.class, args);
	}
}
