package br.com.UbberTest.EmailService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.UbberTest.EmailService.entity.EmailEntity;
import br.com.UbberTest.EmailService.record.EmailRecord;
import br.com.UbberTest.EmailService.repository.EmailRepository;

@Service
public class EmailService {
    
	@Autowired
	EmailRepository emailRepository;
	
	@Autowired
	EmailEntity emailEntity;
	public ResponseEntity<String> sendEmail(EmailRecord emailRecord) {
		try {
			emailRepository.save(emailEntity.toEntity(emailRecord));
			return ResponseEntity.status(HttpStatus.CREATED).body("Sended successful");

			// criar validação de envio posteriormente
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to Send: " + e.getMessage());
		}
	}

}
