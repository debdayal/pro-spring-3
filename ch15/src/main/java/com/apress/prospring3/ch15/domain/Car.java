/**
 * Created on Nov 21, 2011
 */
package com.apress.prospring3.ch15.domain;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 * @author Clarence
 *
 */
@Entity
@Table(name="car")
public class Car {

	private Long id;
	
	private String licensePlate;
	
	private String manufacturer;
	
	private DateTime manufactureDate;
	
	private int age;
	
	private int version;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="LICENSE_PLATE")
	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	@Column(name="MANUFACTURER")
	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Column(name="MANUFACTURE_DATE")
	@Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
	public DateTime getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(DateTime manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	@Column(name="AGE")
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	public String toString() {
		return "License: " + licensePlate + " - Manufacturer: " + manufacturer
				+ " - Manufacture Date: " + manufactureDate + " - Age: " + age;
	}
	
}
