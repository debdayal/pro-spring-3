/**
 * Created on Nov 25, 2011
 */
package com.apress.prospring3.ch18.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * @author Clarence
 *
 */
@Entity
@Table(name = "contact")
public class Contact implements Serializable {

	private Long id;
	private int version;
	private String firstName;
	private String lastName;
	private DateTime birthDate;
	private Set<Hobby> hobbies = new HashSet<Hobby>();
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Version
	@Column(name = "VERSION")
	public int getVersion() {
		return version;
	}
	
	public void setVersion(int version) {
		this.version = version;
	}
	
	@NotEmpty(message="{validation.firstname.NotEmpty.message}")
	@Size(min=3, max=60, message="{validation.firstname.Size.message}")
	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@NotEmpty(message="{validation.lastname.NotEmpty.message}")
	@Size(min=1, max=40, message="{validation.firstname.Size.message}")
	@Column(name = "LAST_NAME")
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "BIRTH_DATE")
	@Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
	@DateTimeFormat(iso=ISO.DATE)
	public DateTime getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(DateTime birthDate) {
		this.birthDate = birthDate;
	}	
	
	@ManyToMany
	@JoinTable(name = "contact_hobby_detail", 
	      joinColumns = @JoinColumn(name = "CONTACT_ID"), 
	      inverseJoinColumns = @JoinColumn(name = "HOBBY_ID"))
	public Set<Hobby> getHobbies() {
		return this.hobbies;
	}

	public void setHobbies(Set<Hobby> hobbies) {
		this.hobbies = hobbies;
	}
	
	@Transient
	public List<Hobby> getHobbiesAsList() {
		return new ArrayList<Hobby>(hobbies);
	}
	
	public String toString() {		
		return "Contact - Id: " + id + ", First name: " + firstName 
				+ ", Last name: " + lastName + ", Birthday: " + birthDate;
	}		
	
}
