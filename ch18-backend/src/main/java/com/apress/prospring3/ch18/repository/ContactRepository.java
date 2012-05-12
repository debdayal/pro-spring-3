/**
 * Created on Dec 28, 2011
 */
package com.apress.prospring3.ch18.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.apress.prospring3.ch18.domain.Contact;

/**
 * @author Clarence
 *
 */
public interface ContactRepository extends CrudRepository<Contact, Long> {

	@Query("select c from Contact c left join fetch c.hobbies h where c.id = :id")
	public Contact findByIdWithDetail(@Param("id") Long id);
	
}
