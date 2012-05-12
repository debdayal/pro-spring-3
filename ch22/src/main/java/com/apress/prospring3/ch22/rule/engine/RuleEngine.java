/**
 * Created on Jan 16, 2012
 */
package com.apress.prospring3.ch22.rule.engine;

import com.apress.prospring3.ch22.rule.domain.Rule;

/**
 * @author Clarence
 *
 */
public interface RuleEngine {

	public void run(Rule rule, Object object);
	
}
