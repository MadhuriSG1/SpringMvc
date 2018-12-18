package com.api.repo;

import com.api.models.Login;
import com.api.models.User;

public interface RegRepository {

	void save(User user);
	boolean validateUser(Login login); 

}
