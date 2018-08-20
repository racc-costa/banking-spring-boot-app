package br.com.racc.banking.account.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Table
@Getter
@NoArgsConstructor
public class Account {
	
	private static final long NUMBER_PREFIX = 60000;

	@PrimaryKey
	private UUID id;
	@NotNull(message = "{account.clientID.notNull}")
	private Long clientID;
	private Long number;
	private LocalDate creationDate;
	private BigDecimal balance;
	private BigDecimal blockedBalance;

	public Account(final Long clientID, final long newAccountNumber) {
		super();
		this.id = UUID.randomUUID();
		this.number = NUMBER_PREFIX + newAccountNumber;
		this.clientID = clientID;
		this.creationDate = LocalDate.now();
		this.balance = BigDecimal.ZERO;
		this.blockedBalance = BigDecimal.ZERO;
	}

	public BigDecimal getAvaiableBalance() {
		return this.getBalance().subtract(this.getBlockedBalance());
	}

}
