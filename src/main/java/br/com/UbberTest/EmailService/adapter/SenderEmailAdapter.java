package br.com.UbberTest.EmailService.adapter;

import org.springframework.http.ResponseEntity;

import br.com.UbberTest.EmailService.record.EmailRecord;

public interface SenderEmailAdapter {
	void sendEmail(EmailRecord emailRecord);

}
