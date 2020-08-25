package com.bca.dao;

import com.bca.model.User;

public interface UserDao {

	public User validateUser(User login);
	public int gantiPassword(User login);

}
