package com.api.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.models.User;
import com.api.repo.RegRepository;
//@Service
public class RegistrationServiceImpl implements RegistationService {
	@Autowired
	private RegRepository regRepository;
	public void save(User user) {
		regRepository.save(user);
	}

}
