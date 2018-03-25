package com.sail.destclerk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations={"classpath:destclerk.xml"})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DestClerkApplication {

	public static void main(String[] args) {
		SpringApplication.run(DestClerkApplication.class, args);
	}
}
