/**
 * Created on Nov 16, 2011
 */
package com.apress.prospring3.ch8.dao.jdbc.annotation;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

/**
 * @author Clarence
 *
 */
public class UpdateContact extends SqlUpdate {

	private static final String SQL_UPDATE_CONTACT = "update contact set first_name=:first_name, last_name=:last_name, birth_date=:birth_date where id=:id";
	
	public UpdateContact(DataSource dataSource) {
		super(dataSource, SQL_UPDATE_CONTACT);
		super.declareParameter(new SqlParameter("first_name", Types.VARCHAR));
		super.declareParameter(new SqlParameter("last_name", Types.VARCHAR));
		super.declareParameter(new SqlParameter("birth_date", Types.DATE));
		super.declareParameter(new SqlParameter("id", Types.INTEGER));
	}	
	
}
