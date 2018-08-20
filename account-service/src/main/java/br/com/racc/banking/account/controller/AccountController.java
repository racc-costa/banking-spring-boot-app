package br.com.racc.banking.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.racc.banking.account.domain.Account;
import br.com.racc.banking.account.service.AccountService;

@RestController
@RefreshScope
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	AccountService accountService;

	@PostMapping
	public Account add(final @RequestBody Long clientID) {
		return accountService.add(clientID);
	}

	@GetMapping("/{number}")
	public Account getByNumber(final @PathVariable Long number) {
		return accountService.getByNumber(number);
	}

	@GetMapping("/client/{clientID}")
	public List<Long> getAccountsNumberByClientID(final @PathVariable Long clientID) {
		return accountService.getAccountsNumberByClientID(clientID);
	}
}
