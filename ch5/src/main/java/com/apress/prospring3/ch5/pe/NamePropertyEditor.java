/*
 * Created on Sep 25, 2011
 */
package com.apress.prospring3.ch5.pe;

import java.beans.PropertyEditorSupport;

/**
 * @author clarence
 */
public class NamePropertyEditor extends PropertyEditorSupport {

    public void setAsText(String text) throws IllegalArgumentException {
        
        String[] name = text.split("\\s");
        
        Name result = new Name(name[0], name[1]); 
        
        setValue(result);   
    }
}
