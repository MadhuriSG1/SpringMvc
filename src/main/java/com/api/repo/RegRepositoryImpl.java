package com.api.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.api.models.Login;
import com.api.models.User;
import com.api.repo.RegRepository;

@Repository
public class RegRepositoryImpl implements RegRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	public void save(User user) {
		String sql = "insert into users values(?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getFirstname(),
				user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone() });		
}

public boolean validateUser(Login login) {
String sql = "select * from users where username='" + login.getUsername() + "' and password='" + login.getPassword()
+ "'";
List<User> users = jdbcTemplate.query(sql, new UserMapper());
return users.size() > 0 ? true : false;

}
}


class UserMapper implements RowMapper<User> {

public User mapRow(ResultSet rs, int arg1) throws SQLException {

  User user = new User();
  user.setUsername(rs.getString("username"));
  user.setPassword(rs.getString("password"));
  user.setFirstname(rs.getString("firstname"));
  user.setLastname(rs.getString("lastname"));
  user.setEmail(rs.getString("email"));
  user.setAddress(rs.getString("address"));
  user.setPhone(rs.getInt("phone"));
  return user;

}
}


