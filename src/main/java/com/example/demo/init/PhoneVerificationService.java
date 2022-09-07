package com.example.demo.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.prop.TwilioProperties;
import com.twilio.exception.ApiException;
import com.twilio.rest.verify.v2.service.Verification;

@Service
public class PhoneVerificationService {
	@Autowired
	private final TwilioProperties twilioProperties;
	
	public PhoneVerificationService(TwilioProperties twilioProperties) {
		this.twilioProperties=twilioProperties;
	}
    
	//method to send to otp
	public VerificationResult startVerification(String phone) {
		
		try {
			Verification verification = Verification.creator(twilioProperties.getAccountSid(), phone, "sms").create();
			if("approved".equals(verification.getStatus())||"pending".equals(verification.getStatus())){
				return new VerificationResult(verification.getSid());
			}
		}catch(ApiException exception) {
			return new VerificationResult(new String[] {exception.getMessage()});
		}
		return null;
	}
 
	public VerificationResult checkverification(String phone, String otp) {
		// TODO Auto-generated method stub
		return null;
	}
}
