package com.luiz.api.service;

import com.luiz.api.domain.Email;

public interface EmailService  {
	void sendSimpleMessage(Email email);
}
