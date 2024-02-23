package br.com.UbberTest.EmailService.entity;

import org.springframework.stereotype.Component;

import br.com.UbberTest.EmailService.record.EmailRecord;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Component
@Table(name = "TB_EMAIL", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
@Data
public class EmailEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String recipient;
	private String subject;
	private String body;

	public EmailEntity toEntity(EmailRecord emailRecord) {

		EmailEntity emailEntity = new EmailEntity();
		emailEntity.setRecipient(emailRecord.recipient());
		emailEntity.setSubject(emailRecord.subject());
		emailEntity.setBody(emailRecord.body());

		return emailEntity;

	}

}
