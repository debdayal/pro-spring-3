/**
 * Created on Nov 21, 2011
 */
package com.apress.prospring3.ch15.repository;

import org.springframework.data.repository.CrudRepository;

import com.apress.prospring3.ch15.domain.Car;

/**
 * @author Clarence
 *
 */
public interface CarRepository extends CrudRepository<Car, Long> {

}
