/**
 * Created on Nov 22, 2011
 */
package com.apress.prospring3.ch14.pe.editor;

import java.beans.PropertyEditorSupport;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @author Clarence
 *
 */
public class DateTimeEditor extends PropertyEditorSupport {
	
	private DateTimeFormatter dateTimeFormatter;
	
	public DateTimeEditor(String dateFormatPattern) {	
		dateTimeFormatter = DateTimeFormat.forPattern(dateFormatPattern);
	}
	
	public void setAsText(String text) throws IllegalArgumentException {		
		setValue(DateTime.parse(text, dateTimeFormatter));
	}

}
