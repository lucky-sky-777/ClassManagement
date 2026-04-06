package com.mezon.classmanagement.backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(value = "id")
	@Column(name = "id", nullable = false)
	Long id;

	@Enumerated(EnumType.STRING)
	@JsonProperty(value = "type")
	@Column(name = "type", nullable = false)
	Type type;

	@JsonProperty(value = "username")
	@Column(name = "username", nullable = false, unique = true)
	String username;

	@JsonProperty(value = "hashed_password")
	@Column(name = "hashed_password", nullable = true)
	String hashedPassword;

	@JsonProperty(value = "display_name")
	@Column(name = "display_name", nullable = true)
	String displayName;

	@JsonProperty(value = "avatar_url")
	@Column(name = "avatar_url", nullable = true)
	String avatarUrl;

	@JsonFormat(pattern = "HH:mm, dd/MM/yyyy", timezone = "Asia/Ho_Chi_Minh")
	@JsonProperty(value = "joined_at")
	@Column(name = "joined_at", nullable = false, insertable = false, updatable = false)
	Instant joinedAt;

	public enum Type {
		GOOGLE,
		MEZON,
		INTERNAL
	}
}