/**
 * Created on Dec 29, 2011
 */
package com.apress.prospring3.ch20.service;

import java.util.List;

import com.apress.prospring3.ch20.domain.Hobby;

/**
 * @author Clarence
 *
 */
public interface HobbyService {

	public List<Hobby> findAll();
	
}
