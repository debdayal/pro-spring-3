/**
 * Created on Oct 12, 2011
 */
package com.apress.prospring3.ch9.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Clarence
 *
 */
@Entity
@Table(name = "hobby")
public class Hobby implements Serializable {

	private String hobbyId;
	private Set<Contact> contacts = new HashSet<Contact>();

	public Hobby() {
	}

	public Hobby(String hobbyId) {
		this.hobbyId = hobbyId;
	}

	public Hobby(String hobbyId, Set<Contact> contacts) {
		this.hobbyId = hobbyId;
		this.contacts = contacts;
	}

	@Id
	@Column(name = "HOBBY_ID")
	public String getHobbyId() {
		return this.hobbyId;
	}

	public void setHobbyId(String hobbyId) {
		this.hobbyId = hobbyId;
	}

	@ManyToMany
	@JoinTable(name = "contact_hobby_detail", 
	      joinColumns = @JoinColumn(name = "HOBBY_ID"), 
	      inverseJoinColumns = @JoinColumn(name = "CONTACT_ID"))
	public Set<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	public String toString() {
		return "Hobby :" + getHobbyId();
	}
}
