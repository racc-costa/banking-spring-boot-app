package br.com.racc.banking.account.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "notification-service", path = "/notifications")
public interface NotificationClient {

	@RequestMapping(value = "/accounts", method = RequestMethod.POST)
	void notifyNewClient(@RequestBody ClientDTO client);

}
