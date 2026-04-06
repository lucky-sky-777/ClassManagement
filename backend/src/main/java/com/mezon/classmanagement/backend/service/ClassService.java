package com.mezon.classmanagement.backend.service;

import com.mezon.classmanagement.backend.dto.ClassMemberDto;
import com.mezon.classmanagement.backend.repository.ClassRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Service
public class ClassService {

	ClassRepository classRepository;

	public List<ClassMemberDto> getClassMembers(Long classId) {
		return classRepository.getClassMembers(classId);
	}

}