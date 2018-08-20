package br.com.racc.banking.client.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.racc.banking.client.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	boolean existsBySin(final  Long sin);

	Optional<Client> findBySin(final Long sin);
}
