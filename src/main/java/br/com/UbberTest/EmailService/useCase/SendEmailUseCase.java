package br.com.UbberTest.EmailService.useCase;

import org.springframework.http.ResponseEntity;

import br.com.UbberTest.EmailService.record.EmailRecord;

public interface SendEmailUseCase {
	
	ResponseEntity<String> sendEmail(EmailRecord emailRecord);

}
