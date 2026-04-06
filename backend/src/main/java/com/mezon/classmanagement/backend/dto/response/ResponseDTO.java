package com.mezon.classmanagement.backend.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public record ResponseDTO<Data>(
		@JsonProperty(value = "success")
		boolean success,

		@JsonProperty(value = "message")
		String message,

		@JsonProperty(value = "data")
		Data data,

		@JsonFormat(pattern = "HH:mm, dd/MM/yyyy", timezone = "Asia/Ho_Chi_Minh")
		@JsonProperty(value = "time")
		Instant timestamp
) {
	public ResponseDTO(boolean success, String message, Data data) {
		this(success, message, data, Instant.now());
	}
}