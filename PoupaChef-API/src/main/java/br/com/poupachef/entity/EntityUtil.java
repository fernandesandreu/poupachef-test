package br.com.poupachef.entity;

import java.net.UnknownHostException;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class EntityUtil {

	@CreatedDate
	@Column(nullable = false)
	private LocalDateTime createDate;

	@LastModifiedDate
	@Column(nullable = false)
	private LocalDateTime lastUpdate;

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	@PrePersist
	private void getDate() throws UnknownHostException {
		this.createDate = LocalDateTime.now();
		this.lastUpdate = LocalDateTime.now();
	}

	@PreUpdate
	private void updateDate() throws UnknownHostException {
		this.lastUpdate = LocalDateTime.now();
	}

}
