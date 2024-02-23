package br.com.UbberTest.EmailService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.UbberTest.EmailService.entity.EmailEntity;

@Repository
public interface EmailRepository extends JpaRepository<EmailEntity, Long>{

}
