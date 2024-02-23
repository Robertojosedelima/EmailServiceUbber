package br.com.UbberTest.EmailService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.UbberTest.EmailService.record.EmailRecord;
import br.com.UbberTest.EmailService.service.EmailService;

@RestController
@RequestMapping(value = "/send")
public class EmailController {

	@Autowired
	EmailService emailService;
    @PostMapping
	public ResponseEntity<String> sendEmail(@Validated @RequestBody EmailRecord emailRecord) {
		return emailService.sendEmail(emailRecord);

	}

}
