package com.example.sestutorial.config;

import org.springframework.cloud.aws.mail.simplemail.SimpleEmailServiceMailSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;

@Configuration
public class AmazonSesConfig {

	@Bean
	public AWSCredentialsProvider awsCreadentialsProvider(){
		//
		return new EnvironmentVariableCredentialsProvider();
	}

	@Bean
	public AmazonSimpleEmailService amazonSimpleEmailService() {
		//
		return AmazonSimpleEmailServiceClientBuilder.standard().withCredentials(awsCreadentialsProvider())
				.withRegion(Regions.AP_NORTHEAST_1).build();
	}

	@Bean
	public MailSender mailSender(AmazonSimpleEmailService ses){
		//
		return new SimpleEmailServiceMailSender(ses);
	}
}
