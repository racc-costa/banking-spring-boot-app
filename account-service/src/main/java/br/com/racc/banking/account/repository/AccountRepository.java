package br.com.racc.banking.account.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.racc.banking.account.domain.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

	@Query("Select * from account where clientID=?0")
	List<Account> findByClientID(Long clientID);

	@Query("Select * from account where number=?0")
	Account findByNumber(Long number);

	@Query("Update sequence set number = number + 1 where id = 'accountSequence';")
	Object incrementAccountNumber();

	@Query("Select number from sequence where id = 'accountSequence';")
	Long getNewAccountNumber();

	@Query("Select number from account where clientID=?0")
	List<Long> findAccountsNumberByClientID(Long clientID);

}
