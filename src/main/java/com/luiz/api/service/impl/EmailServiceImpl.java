package com.luiz.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.luiz.api.domain.Email;
import com.luiz.api.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	public JavaMailSender emailSender;

	
	public void sendSimpleMessage(Email email) {
		
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(email.getTo());
			message.setSubject(email.getSubject());
			message.setText(email.getText());
			message.setCc(email.getCc());
			
			emailSender.send(message);
		} catch (MailException e) {
			e.printStackTrace();
		}
	}

}
