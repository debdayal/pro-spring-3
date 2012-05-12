/**
 * Created on Jan 16, 2012
 */
package com.apress.prospring3.ch22.rule.engine.impl

import org.springframework.stereotype.Component

import com.apress.prospring3.ch22.rule.domain.Rule
import com.apress.prospring3.ch22.rule.engine.RuleEngine

/**
 * @author Clarence
 *
 */
@Component("ruleEngine")
class RuleEngineImpl implements RuleEngine {

	public void run(Rule rule, Object object) {

		println "Executing rule"

		def exit=false // Exit flag for singlehit mode

		// Iterate over the parameter sets
		rule.parameters.each{ArrayList params ->
			def paramIndex=0 // Points to the current parameter
			def success=true

			if(!exit){
				// Check all conditions
				rule.conditions.each{
					println "Condition Param index: " + paramIndex
					success = success && it(object,params[paramIndex])
					println "Condition success: " + success
					paramIndex++
				}

				// If all conditions true, perform actions
				if(success && !exit){
					rule.actions.each{
						println "Action Param index: " + paramIndex
						it(object,params[paramIndex])
						paramIndex++
					}
					// If single hit, exit after first condition match
					if (rule.singlehit){
						exit=true
					}
				}
			}
		}

	}

}
