package com.certranker.CertRanker_Backend;

import com.certranker.CertRanker_Backend.repositories.CertRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CertRankerBackendApplication {

	private final CertRepository certRepository;
	public CertRankerBackendApplication(CertRepository certRepository) {
		this.certRepository = certRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CertRankerBackendApplication.class, args);

	}

}
