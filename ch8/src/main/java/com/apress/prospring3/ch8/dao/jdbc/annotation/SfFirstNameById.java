/**
 * Created on Nov 16, 2011
 */
package com.apress.prospring3.ch8.dao.jdbc.annotation;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlFunction;

/**
 * @author Clarence
 * 
 */
public class SfFirstNameById extends SqlFunction<String> {

	private static final String SQL = "select getfirstnamebyid(?)";

	public SfFirstNameById(DataSource dataSource) {
		super(dataSource, SQL);
		declareParameter(new SqlParameter(Types.INTEGER));
		compile();
	}

}
