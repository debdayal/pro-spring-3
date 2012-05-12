/**
 * Created on Oct 18, 2011
 */
package com.apress.prospring3.ch10.springjpa.auditor;

import org.springframework.data.domain.AuditorAware;

/**
 * @author Clarence
 *
 */
public class AuditorAwareBean implements AuditorAware<String> {

	public String getCurrentAuditor() {
		return "prospring3";
	}

}
