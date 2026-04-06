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
@Table(name = "row_users", uniqueConstraints = @UniqueConstraint(columnNames = {"row_id", "user_id"}))
public class RowUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(value = "id")
	@Column(name = "id", nullable = false)
	Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonProperty(value = "row_id")
	@JoinColumn(name = "row_id", nullable = false)
	Row row;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonProperty(value = "user_id")
	@JoinColumn(name = "user_id", nullable = false)
	User user;

	@Enumerated(EnumType.STRING)
	@JsonProperty(value = "role")
	@Column(name = "role", nullable = false)
	Role role;

	public enum Role {
		ROW_LEADER,
		ROW_MEMBER
	}
}