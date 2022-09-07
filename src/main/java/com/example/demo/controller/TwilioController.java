package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.init.PhoneVerificationService;
import com.example.demo.init.VerificationResult;

@Controller
public class TwilioController {
	@Autowired
	
	PhoneVerificationService phonesmsservice;
	@RequestMapping("/home")
	public String homePage(ModelAndView model) {
		return "index";
		
	}
	@PostMapping("/verifyotp")
	public ResponseEntity<String> sendotp(@RequestParam("phone") String phone,@RequestParam("otp") String otp) {
		
		VerificationResult result=phonesmsservice.checkverification(phone,otp);
		if(result.isValid()) {
			return new ResponseEntity<>("your number is verified.",HttpStatus.OK);
		}
		return new ResponseEntity<>("something wrong/otp incoorect",HttpStatus.BAD_REQUEST);
		
	}

}
