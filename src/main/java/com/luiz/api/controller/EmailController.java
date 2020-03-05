package com.luiz.api.controller;

import javax.websocket.server.PathParam;

import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luiz.api.domain.Email;
import com.luiz.api.dto.EmailDTO;
import com.luiz.api.service.impl.EmailServiceImpl;

@RestController
@RequestMapping(value = "email")
public class EmailController {
	
	@Autowired
	private EmailServiceImpl emailService;
	
	@PostMapping("/sendEmail")
	public ResponseEntity<String> sendEmail(@RequestBody EmailDTO dto) {
		
		Email email = dto.convertFromTo(dto);
		
		emailService.sendSimpleMessage(email);
		
		return ResponseEntity.ok().body("Ok");
	}

}
