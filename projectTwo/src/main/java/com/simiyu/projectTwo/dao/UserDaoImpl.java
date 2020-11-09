package com.simiyu.projectTwo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;

import com.simiyu.projectTwo.model.User;
import com.simiyu.projectTwo.utils.CommonUtils;
/**
 * 
 * @author simiyu
 *
 */
@Component
public class UserDaoImpl implements UserDao {
	 NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	 final String sql = "INSERT INTO users(first_name , last_name, dob, postal_address, national_id, gender)"
				+ " VALUES(:first_name, :last_name, :dob, :postal_address, :national_id, :gender)";
	 final String SELECT_ALL_QUERY = "SELECT first_name , last_name, dob, postal_address, national_id, gender from users";
	 @Autowired
	 public void setNamedParameterJdbcTemplate (NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
	        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	    }		
	@Override
	public void process(List<String> filesPath) {
		List<User> userDetails = new ArrayList<User>();
		
		for(String filePath: filesPath) {
			if(CommonUtils.getFileExtension(filePath).equals("csv")) {
				userDetails.addAll(CommonUtils.readCsv(filePath));
			}else {
				
			}
		}
		importData(userDetails);
	}	
	public void importData(List<User> ud) {		
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(ud.toArray());
		namedParameterJdbcTemplate.batchUpdate(sql, batch);			
	}
	@Override
	public List<User> findAll() {
		return this.namedParameterJdbcTemplate.query(SELECT_ALL_QUERY,new UserMapper());
	}	
	private static final class UserMapper implements RowMapper<User>{
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User users = new User();
			users.setFirst_name(rs.getString("first_name"));
			users.setLast_name(rs.getString("last_name"));
			users.setDob(rs.getDate("dob"));
			users.setPostal_address(rs.getString("postal_address"));
			users.setNational_id(rs.getInt("national_id"));
			users.setGender(rs.getString("gender"));
			return users;
		}
		
	}
}
