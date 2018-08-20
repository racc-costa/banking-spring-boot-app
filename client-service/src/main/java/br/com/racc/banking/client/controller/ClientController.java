package br.com.racc.banking.client.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.racc.banking.client.domain.Client;
import br.com.racc.banking.client.service.ClientService;

@RestController
@RefreshScope
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@PostMapping
	public Client add(final @Valid @RequestBody Client client) {
		return clientService.add(client);
	}

	@GetMapping("/{id}")
	public Client get(final @PathVariable Long id) {
		return this.clientService.get(id);
	}

	@PutMapping
	public Client update(final @Valid @RequestBody Client client) {
		return clientService.update(client);
	}

	@DeleteMapping("/{id}")
	public Client delete(final @PathVariable Long id) {
		return this.clientService.delete(id);
	}

	@PostMapping("/{id}:enable")
	public Client enable(final @PathVariable Long id) {
		return this.clientService.enable(id);
	}

	@PostMapping("/{id}:disable")
	public Client disable(final @PathVariable Long id) {
		return this.clientService.disable(id);
	}
}
