package com.example.ExampleApp;

import com.intuit.rpas.RPASClientSDKConfiguration;
import com.intuit.rpas.config.ExternalActionMapper;
import com.intuit.rpas.model.Action;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(RPASClientSDKConfiguration.class)
public class ExampleAppApplication {

	@Bean
	ExternalActionMapper externalActionMapper()
	{
		return new ExternalActionMapper() {
			@Override
			public Action map(Action from) {
				return null;
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ExampleAppApplication.class, args);
	}
}
