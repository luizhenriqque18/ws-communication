package com.luiz.api.dto;

import com.luiz.api.domain.Email;

public class EmailDTO {
	private String to;
	private String subject;
	private String text;
	private String[] cc;
	
	public Email convertFromTo(EmailDTO dto) {
		return new Email(dto.to, dto.subject, dto.text, dto.cc);
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String[] getCc() {
		return cc;
	}

	public void setCc(String[] cc) {
		this.cc = cc;
	}
	
	
}
