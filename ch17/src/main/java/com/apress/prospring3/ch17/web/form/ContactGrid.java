/**
 * Created on Dec 22, 2011
 */
package com.apress.prospring3.ch17.web.form;

import java.util.List;

import com.apress.prospring3.ch17.domain.Contact;

/**
 * @author Clarence
 *
 */
public class ContactGrid {

	private int totalPages;
	
	private int currentPage;
	
	private long totalRecords;
	
	private List<Contact> contactData;

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}

	public List<Contact> getContactData() {
		return contactData;
	}

	public void setContactData(List<Contact> contactData) {
		this.contactData = contactData;
	}
	
}
