package com.capgemini;

import org.slf4j.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GtdBackendApplication {
	private static final Logger logger = LoggerFactory.getLogger(GtdBackendApplication.class);
	public static void main(String[] args) {
		logger.info("Arrancando la app");
		SpringApplication.run(GtdBackendApplication.class, args);
	}

}
