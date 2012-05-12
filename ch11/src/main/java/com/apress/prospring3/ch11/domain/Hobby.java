/**
 * Created on Oct 24, 2011
 */
package com.apress.prospring3.ch11.domain;

import java.io.Serializable;

/**
 * @author Clarence
 *
 */
public class Hobby implements Serializable {

	private String hobbyId;

	public String getHobbyId() {
		return hobbyId;
	}

	public void setHobbyId(String hobbyId) {
		this.hobbyId = hobbyId;
	}
	
	public String toString() {
		return "Hobby :" + getHobbyId();
	}
	
}
