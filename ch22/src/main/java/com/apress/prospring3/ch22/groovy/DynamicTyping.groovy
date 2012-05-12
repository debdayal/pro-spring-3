/**
 * Created on Jan 16, 2012
 */
package com.apress.prospring3.ch22.groovy

class Contact {
	def firstName
	def lastName
	def birthDate
	
	String toString() { "($firstName,$lastName,$birthDate)" }
}

Contact contact = new Contact(firstName: 'Clarence', lastName: 'Ho', birthDate: new Date())
Contact anotherContact = new Contact(firstName: 20, lastName: 'Ho', birthDate: new Date())

println contact
println anotherContact

println contact.firstName + 20
println anotherContact.firstName + 20