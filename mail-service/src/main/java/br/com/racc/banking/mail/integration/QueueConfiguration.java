package br.com.racc.banking.mail.integration;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class QueueConfiguration {

	@Value("${queue.client.name}")
	private String clientQueueName;

	@Value("${queue.account.name}")
	private String accountQueueName;

	@Value("${queue.onmessage.method}")
	private String onMessageMethodName;

	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(clientQueueName, accountQueueName);
		container.setMessageListener(listenerAdapter);
		return container;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(MessageReceiver receiver) {
		return new MessageListenerAdapter(receiver, onMessageMethodName);
	}

}
