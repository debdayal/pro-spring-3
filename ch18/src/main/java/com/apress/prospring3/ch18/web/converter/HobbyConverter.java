/**
 * Created on Dec 29, 2011
 */
package com.apress.prospring3.ch18.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.apress.prospring3.ch18.domain.Hobby;

/**
 * @author Clarence
 *
 */
@FacesConverter("hobby")
public class HobbyConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
		return new Hobby(value);
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent component, Object value) {
		return (String) value;
	}

}
