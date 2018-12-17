package com.api.repo;

import org.springframework.stereotype.Repository;

import com.api.models.User;
import com.api.repo.RegRepository;
@Repository
public class RegRepositoryImpl implements RegRepository{

	@Override
	public void save(User user) {
		System.out.println(user);
	}

}
