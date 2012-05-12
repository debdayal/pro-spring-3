/**
 * Created on Oct 12, 2011
 */
package com.apress.prospring3.ch10.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * @author Clarence
 *
 */
@Entity
@Table(name = "contact_tel_detail")
public class ContactTelDetail implements Serializable {

	private Long id;
	private int version;
	private Contact contact;
	private String telType;
	private String telNumber;

	public ContactTelDetail() {
	}

	public ContactTelDetail(String telType, String telNumber) {
		this.telType = telType;
		this.telNumber = telNumber;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Version
	@Column(name = "VERSION")
	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@ManyToOne
	@JoinColumn(name = "CONTACT_ID")
	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@Column(name = "TEL_TYPE")
	public String getTelType() {
		return this.telType;
	}

	public void setTelType(String telType) {
		this.telType = telType;
	}

	@Column(name = "TEL_NUMBER")
	public String getTelNumber() {
		return this.telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public String toString() {
		return "Contact Tel Detail - Id: " + id + ", Contact id: " + getContact().getId()
				+ ", Type: " + telType + ", Number: " + telNumber;
	}	
}
