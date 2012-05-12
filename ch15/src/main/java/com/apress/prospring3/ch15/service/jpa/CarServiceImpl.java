/**
 * Created on Nov 21, 2011
 */
package com.apress.prospring3.ch15.service.jpa;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apress.prospring3.ch15.domain.Car;
import com.apress.prospring3.ch15.repository.CarRepository;
import com.apress.prospring3.ch15.service.CarService;
import com.google.common.collect.Lists;

/**
 * @author Clarence
 *
 */
@Service("carService")
@Repository
@Transactional
public class CarServiceImpl implements CarService {

	final Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);
	
	@Autowired
	CarRepository carRepository;
	
	@Transactional(readOnly=true)
	public List<Car> findAll() {
		return Lists.newArrayList(carRepository.findAll());
	}

	public Car save(Car car) {
		return carRepository.save(car);
	}
	
	@Scheduled(fixedDelay=10000)
	//@Scheduled(fixedRate=10000)
	//@Scheduled(cron="0 * * * * *")
	public void updateCarAgeJob() {
		
		// Update age of cars
		List<Car> cars = findAll();
		
		DateTime currentDate = DateTime.now();
		int age;
		
		logger.info("");
		logger.info("Car age update job started");	
		for (Car car: cars) {
			age = new Period(car.getManufactureDate(), currentDate, PeriodType.years()).getYears();
			car.setAge(age);
			save(car);
			logger.info("Car age update--- " + car);
		}
		logger.info("Car age update job completed successfully");
		logger.info("");	
		
	}	
	
}
