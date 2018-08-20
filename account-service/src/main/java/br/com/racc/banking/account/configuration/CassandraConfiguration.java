package br.com.racc.banking.account.configuration;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;

@Configuration
public class CassandraConfiguration extends AbstractCassandraConfiguration {

	@Value("${spring.data.cassandra.keyspace-name}")
	private String keySpaceName;

	@Override
	protected String getKeyspaceName() {
		return keySpaceName;
	}

	@Override
	protected List<String> getStartupScripts() {

		String scriptCreateKeySpace = "CREATE KEYSPACE IF NOT EXISTS " + getKeyspaceName() + " WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };";
		String scriptUseKeySpace = "USE " + getKeyspaceName();
		String scriptCreateAccountTable = "CREATE TABLE IF NOT EXISTS account (id UUID PRIMARY KEY, number bigint, clientID bigint, creationDate date, balance decimal, blockedBalance decimal);";
		String scriptCreateAccountNumberIndex = "CREATE INDEX IF NOT EXISTS accountNumberIndex ON account (number);";
		String scriptCreateAccountClientIdIndex = "CREATE INDEX IF NOT EXISTS accountClientIdIndex ON account (clientID);";
		String scriptCreateSequenceTable = "CREATE TABLE IF NOT EXISTS Sequence (id text PRIMARY KEY, number counter);";

		return Arrays.asList(scriptCreateKeySpace, scriptUseKeySpace, scriptCreateAccountTable,
				scriptCreateAccountNumberIndex, scriptCreateAccountClientIdIndex, scriptCreateSequenceTable);
	}
}