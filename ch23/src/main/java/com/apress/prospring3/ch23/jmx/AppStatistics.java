/**
 * Created on Jan 20, 2012
 */
package com.apress.prospring3.ch23.jmx;

import java.util.List;

/**
 * @author Clarence
 *
 */
public interface AppStatistics {

	public int getTotalContactCount();
	
	public int getLoggedInUserCount();
	
	public List<Object> getLoggedInUsers();	
	
}
