/**
 * Created on Jan 16, 2012
 */
package com.apress.prospring3.ch22.rule.factory;

import com.apress.prospring3.ch22.rule.domain.Rule;

/**
 * @author Clarence
 *
 */
public interface RuleFactory {

	public Rule getAgeCategoryRule();
	
}
