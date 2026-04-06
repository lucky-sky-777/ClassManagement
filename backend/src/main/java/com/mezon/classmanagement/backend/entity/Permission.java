package com.mezon.classmanagement.backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "permissions", uniqueConstraints = @UniqueConstraint(columnNames = {"action", "permitted_user_id"}))
public class Permission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(value = "id")
	@Column(name = "id", nullable = false)
	Long id;

	@Enumerated(EnumType.STRING)
	@JsonProperty(value = "action")
	@Column(name = "action", nullable = false)
	Action action;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonProperty(value = "permitted_user_id")
	@JoinColumn(name = "permitted_user_id", nullable = false)
	User permitted;

	public enum Action {
		MANAGE_ACTIVITY, MANAGE_FUND
	}
}