package jbr.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jbr.springmvc.dao.UserDao;
//import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

public class UserServiceImpl implements UserService {

  @Autowired
  public UserDao userDao;

  public int register(User user) {
    return userDao.register(user);
  }

	/*
	 * public User validateUser(Login login) { return userDao.validateUser(login); }
	 */

public List<User> read() {
	
	return userDao.read();
}

public int update(User user) {
	return userDao.update(user);
}

public int delete(int userid) {
	return userDao.delete(userid);
}

 
public List<User> findUserById(int userid) {
	return userDao.findUserById(userid);
}

}
