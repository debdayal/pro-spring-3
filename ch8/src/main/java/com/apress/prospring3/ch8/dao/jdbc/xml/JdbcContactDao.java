/**
 * Created on Oct 7, 2011
 */
package com.apress.prospring3.ch8.dao.jdbc.xml;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.apress.prospring3.ch8.dao.ContactDao;
import com.apress.prospring3.ch8.domain.Contact;
import com.apress.prospring3.ch8.domain.ContactTelDetail;

/**
 * @author Clarence
 *
 */
public class JdbcContactDao implements ContactDao, InitializingBean {

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public void afterPropertiesSet() throws Exception {
		if (dataSource == null) {
			throw new BeanCreationException("Must set dataSource on ContactDao");
		}
	}

	public List<Contact> findAll() {
		String sql = "select id, first_name, last_name, birth_date from contact";
		return jdbcTemplate.query(sql, new ContactMapper());	
	}

	public List<Contact> findAllWithDetail() {
		String sql = "select c.id, c.first_name, c.last_name, c.birth_date" + 
		             ", t.id as contact_tel_id, t.tel_type, t.tel_number from contact c " + 
			         "left join contact_tel_detail t on c.id = t.contact_id";
		return jdbcTemplate.query(sql, new ContactWithDetailExtractor());
	}

	public String findFirstNameById(Long id) {
		String firstName = jdbcTemplate.queryForObject(
				"select first_name from contact where id = ?",
				new Object[]{id}, String.class);
		return firstName;
	}

	public String findLastNameById(Long id) {
		String sql = "select last_name from contact where id = :contactId";
		
		SqlParameterSource namedParameters = new MapSqlParameterSource("contactId", id);
		//Map<String, Object> namedParameters = new HashMap<String, Object>();
		//namedParameters.put("contactId", id);
		return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, String.class);
	}

	public List<Contact> findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insert(Contact contact) {
		// TODO Auto-generated method stub
		
	}

	public void update(Contact contact) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Long contactId) {
		// TODO Auto-generated method stub
		
	}	
	
	public void insertWithDetail(Contact contact) {
		// TODO Auto-generated method stub
		
	}

	protected void retrieveIdentity(final Contact contact) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource()); 
		contact.setId(jdbcTemplate.queryForLong("select last_insert_id()")); 
	}
	
	private static final class ContactMapper implements RowMapper<Contact> {

		public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {

			Contact contact = new Contact();
			contact.setId(rs.getLong("id"));
			contact.setFirstName(rs.getString("first_name"));
			contact.setLastName(rs.getString("last_name"));
			contact.setBirthDate(rs.getDate("birth_date"));
			return contact;
		}
		
	}	
	
	private static final class ContactWithDetailExtractor implements ResultSetExtractor<List<Contact>> {

		public List<Contact> extractData(ResultSet rs) throws SQLException,
				DataAccessException {

			Map<Long, Contact> map = new HashMap<Long, Contact>();
			Contact contact = null;
			while (rs.next()) {
				Long id = rs.getLong("id");
				contact = map.get(id);
				if (contact == null) {  // new contact record
					contact = new Contact();
					contact.setId(id);
					contact.setFirstName(rs.getString("first_name"));
					contact.setLastName(rs.getString("last_name"));
					contact.setBirthDate(rs.getDate("birth_date"));
					contact.setContactTelDetails(new ArrayList<ContactTelDetail>());
					map.put(id, contact);
				}
				// Process contact tel. detail (if exists)
				Long contactTelDetailId = rs.getLong("contact_tel_id");
				if (contactTelDetailId > 0) {
					ContactTelDetail contactTelDetail = new ContactTelDetail();
					contactTelDetail.setId(contactTelDetailId);
					contactTelDetail.setContactId(id);
					contactTelDetail.setTelType(rs.getString("tel_type"));
					contactTelDetail.setTelNumber(rs.getString("tel_number"));
					contact.getContactTelDetails().add(contactTelDetail);
				}
			}
			
			return new ArrayList<Contact> (map.values());
		}
		
	}
}
