package vn.iotstar.service;

import vn.iotstar.model.User;

public interface UserService {
	User Login(String username, String password);
	User get(String username);
}
