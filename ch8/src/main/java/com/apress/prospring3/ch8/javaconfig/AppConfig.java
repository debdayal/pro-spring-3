/**
 * Created on Oct 9, 2011
 */
package com.apress.prospring3.ch8.javaconfig;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * @author Clarence
 *
 */
@Configuration
@ComponentScan(basePackages="com.apress.prospring3.ch8.dao.jdbc.annotation")
public class AppConfig {

	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.H2).addScript("schema.sql").addScript("test-data.sql").build();
		return db;
	}
	
}
