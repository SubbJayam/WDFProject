package jbr.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

//import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

public class UserDaoImpl implements UserDao {

  //@Autowired
  //DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  public int register(User user) {
    String sql = "insert into users1 values(null,?,?,?,?,?,?,?)";

    return jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getFirstname(),
        user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone() });
  }

	/*
	 * public User validateUser(Login login) { String sql =
	 * "select * from users1 where username='" + login.getUsername() +
	 * "' and password='" + login.getPassword() + "'"; List<User> users =
	 * jdbcTemplate.query(sql, new UserMapper());
	 * 
	 * return users.size() > 0 ? users.get(0) : null; }
	 */
 

class UserMapper implements RowMapper<User> {

  public User mapRow(ResultSet rs, int arg1) throws SQLException {
    User user = new User();

    user.setUsername(rs.getString("username"));
    user.setPassword(rs.getString("password"));
    user.setFirstname(rs.getString("firstname"));
    user.setLastname(rs.getString("lastname"));
    user.setEmail(rs.getString("email"));
    user.setAddress(rs.getString("address"));
    user.setPhone(rs.getString("phone"));

    return user;
  }
  
}
 
public int update(User user) {
	String sql = "update users1 set username=?, password=?, firstname=?,lastname=?,email=?,address=?,phone=? where id=?";

	try {

		int counter = jdbcTemplate.update(sql,
				new Object[] { user.getUsername(), user.getPassword(),user.getFirstname(),
						user.getLastname(),  user.getEmail(),user.getAddress(),user.getPhone(),user.getId() });

		return counter;

	} catch (Exception e) {
		e.printStackTrace();
		return 0;
	}
}

 
public int delete(int userid) {
	String sql = "delete from users1 where id=?";

	try {

		int counter = jdbcTemplate.update(sql, new Object[] { userid });

		return counter;

	} catch (Exception e) {
		e.printStackTrace();
		return 0;
	}
}

public List<User> read() {
	List<User> userList = jdbcTemplate.query("SELECT * FROM users1", new RowMapper<User>() {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();

			user.setId(rs.getString("id"));
			user.setUsername(rs.getString( "username"));
			user.setPassword(rs.getString( "password"));
			user.setFirstname(rs.getString("firstname"));
			user.setLastname(rs.getString("lastname"));
			user.setEmail(rs.getString("email"));
			user.setAddress(rs.getString("address"));
		    user.setPhone(rs.getString("phone"));
			
			return user;
		}

	});

	return userList;
}

 
public List<User> findUserById(int userid) {
	List<User> userList = jdbcTemplate.query("SELECT * FROM users1 where id=?",
			new Object[] { userid }, new RowMapper<User>() {

				 
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					User user  = new User();

					user.setId(rs.getString("id"));
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					user.setFirstname(rs.getString("firstname"));
					user.setLastname (rs.getString("lastname"));
					user.setEmail(rs.getString("email"));
					user.setAddress(rs.getString("address"));
                    user.setPhone(rs.getString("phone"));
					return user;
				}
				 
	});
	return userList; 
}
 

}
 


//https://www.websparrow.org/spring/spring-mvc-crud-example-using-jdbctemplate-mysql

//https://dzone.com/articles/spring-mvc-example-for-user-registration-and-login-1