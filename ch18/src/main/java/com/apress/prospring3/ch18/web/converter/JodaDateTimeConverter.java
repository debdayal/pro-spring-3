/**
 * Created on Dec 29, 2011
 */
package com.apress.prospring3.ch18.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

/**
 * @author Clarence
 *
 */
@FacesConverter("jodaDataTimeConverter")
public class JodaDateTimeConverter implements Converter {

	private static final String PATTERN = "yyyy-MM-dd";
	
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
		return DateTimeFormat.forPattern(PATTERN).parseDateTime(value);
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent component, Object value) {
		
		DateTime dateTime = (DateTime) value;
		
		return DateTimeFormat.forPattern(PATTERN).print(dateTime);
	}	
	
}
