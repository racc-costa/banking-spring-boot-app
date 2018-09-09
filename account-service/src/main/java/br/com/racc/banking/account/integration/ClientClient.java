package br.com.racc.banking.account.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "client-service", path = "/clients")
public interface ClientClient {

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ClientDTO getClientById(@PathVariable("id") Long id);

}
