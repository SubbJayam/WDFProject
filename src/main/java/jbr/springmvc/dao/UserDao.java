package jbr.springmvc.dao;

import java.util.List;

//import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

public interface UserDao {

  int register(User user);

 // User validateUser(Login login);
  
  public List<User> read();
  
  public List<User> findUserById(int userid);
  
  public int update(User user);

  public int delete(int userid);
  
}
