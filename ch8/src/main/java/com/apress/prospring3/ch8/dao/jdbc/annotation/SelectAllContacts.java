/**
 * Created on Nov 16, 2011
 */
package com.apress.prospring3.ch8.dao.jdbc.annotation;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.object.MappingSqlQuery;

import com.apress.prospring3.ch8.domain.Contact;

/**
 * @author Clarence
 *
 */
public class SelectAllContacts extends MappingSqlQuery<Contact> {

	private static final String SQL_SELECT_ALL_CONTACT = "select id, first_name, last_name, birth_date from contact";

	public SelectAllContacts(DataSource dataSource) {
		super(dataSource, SQL_SELECT_ALL_CONTACT);
	}
	
	protected Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contact contact = new Contact();

		contact.setId(rs.getLong("id"));
		contact.setFirstName(rs.getString("first_name"));
		contact.setLastName(rs.getString("last_name"));	
		contact.setBirthDate(rs.getDate("birth_date"));

		return contact;
	}
	
}
