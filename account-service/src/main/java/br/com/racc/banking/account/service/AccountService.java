package br.com.racc.banking.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.racc.banking.account.domain.Account;
import br.com.racc.banking.account.integration.ClientClient;
import br.com.racc.banking.account.integration.ClientDTO;
import br.com.racc.banking.account.integration.NotificationClient;
import br.com.racc.banking.account.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private NotificationClient notificationClient;

	@Autowired
	private ClientClient clientClient;

	public Account add(Long clientID) {

		accountRepository.incrementAccountNumber();
		Long newAccountNumber = accountRepository.getNewAccountNumber();
		Account account = new Account(clientID, newAccountNumber);
		accountRepository.save(account);

		ClientDTO clientDTO = clientClient.getClientById(clientID);
		notificationClient.notifyNewClient(clientDTO);

		return account;
	}

	public Account getByNumber(Long number) {
		return accountRepository.findByNumber(number);
	}

	public List<Account> getByClient(Long clientID) {
		return accountRepository.findByClientID(clientID);
	}

	public List<Long> getAccountsNumberByClientID(Long clientID) {
		return accountRepository.findAccountsNumberByClientID(clientID);
	}

}
