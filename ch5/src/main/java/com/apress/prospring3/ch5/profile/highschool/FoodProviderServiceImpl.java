/**
 * Created on Sep 26, 2011
 */
package com.apress.prospring3.ch5.profile.highschool;

import java.util.ArrayList;
import java.util.List;

import com.apress.prospring3.ch5.profile.Food;
import com.apress.prospring3.ch5.profile.FoodProviderService;

/**
 * @author Clarence
 *
 */
public class FoodProviderServiceImpl implements FoodProviderService {

	public List<Food> provideLunchSet() {
		List<Food> lunchSet = new ArrayList<Food>();
		lunchSet.add(new Food("Coke"));
		lunchSet.add(new Food("Hamburger"));
		lunchSet.add(new Food("French Fries"));
		
		return lunchSet;
	}

}
