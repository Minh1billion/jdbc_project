package vn.iotstar.service.impl;
import vn.iotstar.dao.UserDao;
import vn.iotstar.service.UserService;
import vn.iotstar.model.User;

public class UserServiceImpl implements UserService{
	UserDao userDao = new UserDaoImpl();
	
	@Override
	public User login(String username, String password) {
	User user = this.get(username);
	if (user != null && password.equals(user.getPassWord())) {
	return user;
	}
	return null;
	}
	@Override
	public User get(String username) {
	return userDao.get(username);
	}
}
