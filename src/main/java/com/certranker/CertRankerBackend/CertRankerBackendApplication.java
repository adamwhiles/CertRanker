package com.certranker.CertRankerBackend;

import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication
public class CertRankerBackendApplication {

    public static void main(String[] args) {
		SpringApplication.run(CertRankerBackendApplication.class, args);

	}

}
