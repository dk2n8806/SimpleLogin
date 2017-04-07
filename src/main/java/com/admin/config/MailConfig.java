package com.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.sendgrid.SendGrid;

@Configuration
@PropertySource("classpath:/sendgrid.properties")
public class MailConfig {

	@Autowired private Environment env;
	

	@Bean 
    public SendGrid sendGrid() { 
		SendGrid sendgrid = new SendGrid(env.getProperty("sendgrid.api.password"));
		return sendgrid; 
    } 
}
