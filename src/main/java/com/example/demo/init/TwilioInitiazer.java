package com.example.demo.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.example.demo.prop.TwilioProperties;
import com.twilio.Twilio;
@Configuration
public class TwilioInitiazer {
	
	private final TwilioProperties twilioproperties;
	@Autowired
	public TwilioInitiazer(TwilioProperties twilioproperties) {
		this.twilioproperties=twilioproperties;
		Twilio.init(twilioproperties.getAccountSid(),twilioproperties.getAuthToken());
		System.out.println("Twilio Initialized with Account:"+twilioproperties.getAccountSid());
		
	}
	
	

}
