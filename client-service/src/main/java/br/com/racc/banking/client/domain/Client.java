package br.com.racc.banking.client.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.racc.banking.client.infra.domain.DomainEntity;
import lombok.Getter;

@Entity
@Table(name = "client", uniqueConstraints = {
		@UniqueConstraint(columnNames = "sin", name = "uk_client_sin") }, indexes = {
				@Index(name = "idx_client_sin", columnList = "sin"),
				@Index(name = "idx_client_state", columnList = "state") })
@Getter
@JsonIgnoreProperties(value = { "enabled" })
public class Client extends DomainEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "client_id_generator", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "client_id_generator", sequenceName = "client_sequence", initialValue = 1000, allocationSize = 1)
	@Column(name = "id", columnDefinition = "NUMERIC(14)")
	private Long id;

	@NotNull(message = "{client.sin.notNull}")
	@Column(name = "sin", columnDefinition = "NUMERIC(14)", nullable = false)
	private Long sin;

	@NotBlank(message = "{client.name.notBlank}")
	@Size(min = 3, max = 100, message = "{client.name.size}")
	@Column(name = "name", length = 100, columnDefinition = "VARCHAR(100)", nullable = false)
	private String name;

	@NotBlank(message = "{client.email.notBlank}")
	@Size(min = 10, max = 200, message = "{client.email.size}")
	@Column(name = "email", length = 200, columnDefinition = "VARCHAR(200)", nullable = false)
	private String email;

	@NotNull(message = "{client.birthday.notNull}")
	@Column(name = "birthday")
	private LocalDate birthday;

	@NotBlank(message = "{client.address.notBlank}")
	@Size(min = 5, max = 200, message = "{client.address.size}")
	@Column(name = "address", length = 200, columnDefinition = "VARCHAR(200)", nullable = false)
	private String address;

	@NotBlank(message = "{client.city.notBlank}")
	@Size(min = 2, max = 50, message = "{client.city.size}")
	@Column(name = "city", length = 50, columnDefinition = "VARCHAR(50)", nullable = false)
	private String city;

	@NotBlank(message = "{client.state.notBlank}")
	@Size(min = 2, max = 50, message = "{client.city.size}")
	@Column(name = "state", length = 50, columnDefinition = "VARCHAR(50)", nullable = false)
	private String state;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "status", columnDefinition = "NUMERIC(1)", nullable = false)
	private ClientStatus status;

	public Client() {
		this(null, null, null, null, null, null, null);
	}

	public Client(final Long sin, final String name, final String email, final LocalDate birthday, final String address,
			final String city, final String state) {
		super();
		this.sin = sin;
		this.name = name;
		this.email = email;
		this.birthday = birthday;
		this.address = address;
		this.city = city;
		this.state = state;
		this.status = ClientStatus.DISABLED;
	}

	public void enable() {
		this.status = ClientStatus.ENABLED;
	}

	public void disable() {
		this.status = ClientStatus.DISABLED;
	}

	public boolean isEnabled() {
		return this.status == ClientStatus.ENABLED;
	}
}
