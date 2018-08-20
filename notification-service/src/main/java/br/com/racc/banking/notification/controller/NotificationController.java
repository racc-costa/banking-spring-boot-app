package br.com.racc.banking.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.racc.banking.notification.dto.ClientDTO;
import br.com.racc.banking.notification.service.NotificationService;

@RestController
@RefreshScope
@RequestMapping("/notifications")
public class NotificationController {

	@Autowired
	private NotificationService notificationService;

	@PostMapping("/clients")
	public HttpStatus newClient(final @RequestBody ClientDTO clientDTO) {
		notificationService.notifyNewClient(clientDTO);
		return HttpStatus.OK;
	}

	@PostMapping("/accounts")
	public HttpStatus newAccount(final @RequestBody ClientDTO clientDTO) {
		notificationService.notifyNewAccount(clientDTO);
		return HttpStatus.OK;
	}
}
