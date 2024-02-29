package br.com.UbberTest.EmailService.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;


import br.com.UbberTest.EmailService.adapter.SenderEmailAdapter;
import br.com.UbberTest.EmailService.exceptions.EmailException;
import br.com.UbberTest.EmailService.record.EmailRecord;

@Service
public class AwsSendEmail implements SenderEmailAdapter{
	
	private final AmazonSimpleEmailService client;
	
	@Autowired
	public AwsSendEmail(AmazonSimpleEmailService client) {
		this.client = client;
	}

	@Override
	public void sendEmail(EmailRecord emailRecord) {
		SendEmailRequest sendEmailRequest =  new SendEmailRequest()
		.withSource("drop1108@gmail.com")
        .withDestination(new Destination().withToAddresses(emailRecord.recipient()))
        .withMessage(new Message()
                .withSubject(new Content(emailRecord.subject()))
                .withBody(new Body().withText(new Content(emailRecord.body())))
        );

		try {
			client.sendEmail(sendEmailRequest);
			
		} catch (AmazonServiceException e) {
			throw new EmailException("Email sending failed aws", e);
		
		}
		
	}

}
