package com.user.service;

import com.user.model.UserAcount;

public interface UserService {
	
	boolean login( UserAcount user);
	boolean forgetPassword( UserAcount user);
	
	boolean signup(UserAcount user);
	boolean loginWithUserName(UserAcount user);
	boolean DeleatAccount(UserAcount user);

}
