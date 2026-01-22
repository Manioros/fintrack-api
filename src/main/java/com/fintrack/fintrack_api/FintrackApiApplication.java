package com.fintrack.fintrack_api;

import com.fintrack.fintrack_api.entity.Asset;
import com.fintrack.fintrack_api.repository.AssetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FintrackApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FintrackApiApplication.class, args);
	}
	@Bean
	CommandLineRunner start(AssetRepository assetRepository) {
		return args -> {
			assetRepository.save(new Asset(null, "Bitcoin", "BTC", 1.2));
			assetRepository.save(new Asset(null, "Ethereum", "ETH", 10.0));
			System.out.println(">> Assets saved to Database!");
		};
	}
}
