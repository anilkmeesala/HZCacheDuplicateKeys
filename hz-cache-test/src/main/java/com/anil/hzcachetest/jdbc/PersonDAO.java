package com.anil.hzcachetest.jdbc;

import com.anil.hzcachetest.model.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Created by anil on 1/11/2017.
 */
@Repository
public class PersonDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Person getPerson(String id){
		String sql = "select * from person where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{Integer.valueOf(id)},
				new RowMapper<Person>() {
					@Override
					public Person mapRow(ResultSet rs, int i) throws SQLException {
						Person p = new Person();
						p.setId(rs.getString("id"));
						p.setName(rs.getString("name"));
						p.setCity(rs.getString("city"));
						p.setState(rs.getString("state"));
						return p;
					}
		});
	}

	public List<String> getIds() {
		String sql = "select id from person";
		return jdbcTemplate.query(sql, 
				new RowMapper<String>() {
					@Override
					public String mapRow(ResultSet rs, int i) throws SQLException {
						return rs.getString("id");
					}
		});
	}

}
