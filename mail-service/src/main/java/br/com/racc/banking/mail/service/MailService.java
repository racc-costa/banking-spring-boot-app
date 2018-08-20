package br.com.racc.banking.mail.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.racc.banking.mail.domain.QueueMessage;

@Service
public class MailService {

	private static final Logger logger = LoggerFactory.getLogger(MailService.class);

	@Autowired
	private JavaMailSender emailSender;

	public void sendMail(final String to, final String subject, final String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		logger.debug("Trying to send a new mail.");
		emailSender.send(message);
		logger.debug("New mail has been sent.");
	}

	public void sendMail(QueueMessage message) {
		switch (message.getType()) {
		case NEW_CLIENT:
			this.sendMail(message.getClientDTO().getEmail(), "New Client", "Congrats!");
			break;
		case NEW_ACCOUNT:
			this.sendMail(message.getClientDTO().getEmail(), "New Account", "Congrats!");
			break;
		default:
			break;
		}
	}
}
