package com.mvcwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class UserValidationService {

	public boolean isUserValid(String name, String password) {

		if (name.equals("Ehsan") && password.equals("123456")) {
			return true;

		} else
			return false;
	}

}
