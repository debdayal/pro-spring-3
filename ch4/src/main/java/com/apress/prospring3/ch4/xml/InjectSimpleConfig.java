/**
 * Created on Sep 21, 2011
 */
package com.apress.prospring3.ch4.xml;



/**
 * @author Clarence
 *
 */
public class InjectSimpleConfig {

    private String name = "John Smith";

    private int age = 35;

    private float height = 1.78f;

    private boolean programmer = true;

    private Long ageInSeconds = 1103760000L;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public boolean isProgrammer() {
		return programmer;
	}

	public void setProgrammer(boolean programmer) {
		this.programmer = programmer;
	}

	public Long getAgeInSeconds() {
		return ageInSeconds;
	}

	public void setAgeInSeconds(Long ageInSeconds) {
		this.ageInSeconds = ageInSeconds;
	}	
	
}
