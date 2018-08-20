package br.com.racc.banking.mail.integration;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.racc.banking.mail.domain.QueueMessage;
import br.com.racc.banking.mail.service.MailService;

@Component
public class MessageReceiver implements MessageListener {

	private static final Logger logger = LoggerFactory.getLogger(MessageReceiver.class);

	@Autowired
	private MailService mailService;

	@Override
	public void onMessage(Message queueMessage) {

		ObjectMapper mapper = new ObjectMapper();

		try {
			QueueMessage message = mapper.readValue(queueMessage.getBody(), QueueMessage.class);
			mailService.sendMail(message);
		} catch (JsonParseException e) {
			logger.error(e.getMessage());
		} catch (JsonMappingException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}
}
