package com.payment.api.config;

import com.paypal.base.rest.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.modelmapper.ModelMapper;

@Configuration
public class PaymentConfiguration
{

   @Value("${payment.client-id}")
	private String clientId;
   @Value("${payment.client-secret}")
	private String clientSecret;
   @Value("${payment.mode}")
	private String mode;
	
  @Bean
	public APIContext apiContext() {
	    return new APIContext(clientId,clientSecret,mode);
	}

   @Bean
   public ModelMapper getModelMapper() {
       return new ModelMapper();
    }
}
