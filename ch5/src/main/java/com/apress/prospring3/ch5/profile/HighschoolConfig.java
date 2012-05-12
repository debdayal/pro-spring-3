/**
 * Created on Sep 26, 2011
 */
package com.apress.prospring3.ch5.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.apress.prospring3.ch5.profile.highschool.FoodProviderServiceImpl;

/**
 * @author Clarence
 *
 */
@Configuration
@Profile(value="highschool")
public class HighschoolConfig {

	@Bean
	public FoodProviderService foodProviderService() {
		return new FoodProviderServiceImpl();
	}
	
}
