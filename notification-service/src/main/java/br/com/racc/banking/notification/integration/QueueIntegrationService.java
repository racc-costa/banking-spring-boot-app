package br.com.racc.banking.notification.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import br.com.racc.banking.notification.domain.QueueMessage;
import br.com.racc.banking.notification.domain.QueueMessageType;
import br.com.racc.banking.notification.dto.ClientDTO;

@Service
public class QueueIntegrationService {

	private static final Logger logger = LoggerFactory.getLogger(QueueIntegrationService.class);

	@Value("${queue.client.name}")
	private String clientQueueName;

	@Value("${queue.account.name}")
	private String accountQueueName;

	@Value("${exchange.notification.name}")
	private String notificationExchangeName;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Bean
	public Queue clientQueue() {
		return new Queue(clientQueueName, true);
	}

	@Bean
	public Queue accountQueue() {
		return new Queue(accountQueueName, true);
	}

	@Bean
	DirectExchange exchange() {
		return new DirectExchange(notificationExchangeName);
	}

	@Bean
	Binding bindingClientQueue(@Qualifier("clientQueue") Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(clientQueueName);
	}

	@Bean
	Binding bindingAccountQueue(@Qualifier("accountQueue") Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(accountQueueName);
	}

	public void notifyNewClient(final ClientDTO clientDTO) {
		rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
		rabbitTemplate.convertAndSend(clientQueue().getName(),
				new QueueMessage(QueueMessageType.NEW_CLIENT, clientDTO));
		logger.debug("A new client message has been sent.");
	}

	public void notifyNewAccount(final ClientDTO clientDTO) {
		rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
		rabbitTemplate.convertAndSend(accountQueue().getName(),
				new QueueMessage(QueueMessageType.NEW_ACCOUNT, clientDTO));
		logger.debug("A new account message has been sent.");
	}
}
