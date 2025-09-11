package com.user.service;

import com.user.model.UserAcount;

public interface UserService {
	
	boolean login( UserAcount user);
	
	boolean signup(UserAcount user);
	boolean DeleatAccount(UserAcount user);

}
