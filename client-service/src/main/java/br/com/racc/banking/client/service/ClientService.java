package br.com.racc.banking.client.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.racc.banking.client.domain.Client;
import br.com.racc.banking.client.exception.ClientAlreadyExistException;
import br.com.racc.banking.client.exception.ClientNotFoundException;
import br.com.racc.banking.client.repository.ClientRepository;

@Service
public class ClientService {

	private static final Logger logger = LoggerFactory.getLogger(ClientService.class);

	@Autowired
	ClientRepository clientRepository;

	public Client add(final Client client) {
		if (this.clientRepository.existsBySin(client.getSin())) {
			throw new ClientAlreadyExistException(client.getSin());
		}

		logger.debug("Adding a new client.");
		return this.clientRepository.save(client);
	}

	public Client get(final Long id) {
		return findClientById(id);
	}

	public Client delete(final Long id) {
		Client client = findClientById(id);
		this.clientRepository.deleteById(id);
		logger.debug("Deleting a client.");
		return client;
	}

	public Client update(final Client client) {
		this.clientRepository.findBySin(client.getSin())
				.orElseThrow(() -> new ClientNotFoundException("SIN", client.getSin()));
		logger.debug("Updating a client.");
		return clientRepository.saveAndFlush(client);
	}

	public Client enable(final Long id) {
		Client client = findClientById(id);
		client.enable();
		logger.debug("Enabling a client.");
		return clientRepository.saveAndFlush(client);
	}

	public Client disable(final Long id) {
		Client client = findClientById(id);
		client.disable();
		logger.debug("Disabling a client.");
		return clientRepository.saveAndFlush(client);
	}

	private Client findClientById(final Long id) {
		logger.debug("Finding a client by ID.");
		return this.clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException("ID", id));
	}
}
