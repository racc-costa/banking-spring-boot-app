package br.com.racc.banking.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.racc.banking.notification.dto.ClientDTO;
import br.com.racc.banking.notification.integration.QueueIntegrationService;

@Service
public class NotificationService {

	@Autowired
	private QueueIntegrationService queueIntegrationService;

	public void notifyNewClient(final ClientDTO clientDTO) {
		queueIntegrationService.notifyNewClient(clientDTO);
	}

	public void notifyNewAccount(final ClientDTO clientDTO) {
		queueIntegrationService.notifyNewAccount(clientDTO);
	}
}