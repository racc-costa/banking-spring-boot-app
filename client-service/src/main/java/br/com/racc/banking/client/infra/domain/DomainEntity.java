package br.com.racc.banking.client.infra.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "date_created", "date_updated" }, allowGetters = true)
public abstract class DomainEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "datetime_created", nullable = false, updatable = false)
	@CreatedDate
	private LocalDateTime dateCreated;

	@Column(name = "datetime_updated", nullable = false)
	@LastModifiedDate
	private LocalDateTime dateUpdated;
}
