package com.apress.prospring3.ch20.repository;

import com.apress.prospring3.ch20.domain.Contact;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Contact.class)
public interface ContactRepository {
}
