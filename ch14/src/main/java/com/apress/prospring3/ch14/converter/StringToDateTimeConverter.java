/**
 * Created on Nov 20, 2011
 */
package com.apress.prospring3.ch14.converter;

import javax.annotation.PostConstruct;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 * @author Clarence
 *
 */
public class StringToDateTimeConverter implements Converter<String, DateTime> {

	private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";

	private DateTimeFormatter dateFormat;	
	
	private String datePattern = DEFAULT_DATE_PATTERN;	
	
	public String getDatePattern() {
		return datePattern;
	}

	@Autowired(required=false)
	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}

	@PostConstruct
	public void init() {
		dateFormat = DateTimeFormat.forPattern(datePattern);
	}
	
	public DateTime convert(String dateString) {
		return dateFormat.parseDateTime(dateString);
	}

}
