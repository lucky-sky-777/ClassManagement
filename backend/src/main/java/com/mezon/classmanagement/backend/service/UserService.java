package com.mezon.classmanagement.backend.service;

import com.mezon.classmanagement.backend.dto.response.UserResponseDto;
import com.mezon.classmanagement.backend.entity.User;
import com.mezon.classmanagement.backend.mapper.UserMapper;
import com.mezon.classmanagement.backend.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Service
public class UserService {

	UserRepository userRepository;
	UserMapper userMapper;

	public Optional<UserResponseDto> getByUsername(String username) {
		Optional<User> userOptional = userRepository.findByUsername(username);
		return userOptional.map(userMapper::toUserResponseDto);
	}

}