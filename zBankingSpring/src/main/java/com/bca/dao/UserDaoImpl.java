package com.bca.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.List;
import java.util.List;

import javax.sql.DataSource;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Component;

import com.bca.model.User;

public class UserDaoImpl implements UserDao {

	private JdbcTemplate template;

	public void setTemplate(DataSource ds) {
		this.template = new JdbcTemplate(ds);
	}

	public User validateUser(User login) {
		String sql = "select * from user where username=? and pw=?";
		List<User> userlogin = template.query(sql, new Object[] { login.getUsername(), login.getPw() },
				new RowMapper<User>() {
					public User mapRow(ResultSet rs, int rowNum) throws SQLException {
						User user = new User();
						user.setUsername(rs.getString("username"));
						user.setPw(rs.getString("pw"));
						return user;
					}
				});
		if (userlogin.isEmpty()) {
			return null;
		} else { // list contains exactly 1 element
			return userlogin.get(0);
		}
	}

	@Override
	public int gantiPassword(User l) {
		String sql = "update user set pw='" + l.getPw() + "' where username='" + l.getUsername() + "'";
		return template.update(sql);
	}
}
