import org.joda.time.DateTime
import org.joda.time.Years;

import com.apress.prospring3.ch22.rule.domain.Rule
import com.apress.prospring3.ch22.rule.factory.RuleFactory

class RuleFactoryImpl implements RuleFactory {

	Closure age = { birthDate -> return Years.yearsBetween(birthDate, new DateTime()).getYears() }
	
	public Rule getAgeCategoryRule() {

		// Rule definition
		Rule rule = new Rule()
		
		// ****************** CONFIGURATION ******************
		rule.singlehit=true
		
		// ***************************************************
		rule.conditions=[
		// ****************** CONDITIONS *********************
		{object, param -> age(object.birthDate) >= param}, {object, param -> age(object.birthDate) <= param}
		// ***************************************************
		]
		rule.actions=[
		// ******************* ACTIONS ***********************
		{object, param -> object.ageCategory = param}
		// ***************************************************
		]
		rule.parameters=[
		// **************** PARAMETERSETS ********************
		// Min age, Max age, ageCategory
		[0,10,'Kid'],
		[11,20,'Youth'],
		[21,40,'Adult'],
		[41,60,'Middle-aged'],
		[61,120,'Old']
		// ***************************************************
		]
		
		return rule
				
	}
	
}
