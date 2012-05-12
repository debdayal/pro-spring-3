package com.apress.prospring3.ch10.domain;

import java.util.Date;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.joda.time.DateTime;

@StaticMetamodel(ContactAudit.class)
public abstract class ContactAudit_ {

	public static volatile SingularAttribute<ContactAudit, Long> id;
	public static volatile SetAttribute<ContactAudit, ContactTelDetail> contactTelDetails;
	public static volatile SingularAttribute<ContactAudit, String> lastName;
	public static volatile SingularAttribute<ContactAudit, String> createdBy;
	public static volatile SingularAttribute<ContactAudit, String> lastModifiedBy;
	public static volatile SingularAttribute<ContactAudit, DateTime> lastModifiedDate;
	public static volatile SingularAttribute<ContactAudit, Date> birthDate;
	public static volatile SetAttribute<ContactAudit, Hobby> hobbies;
	public static volatile SingularAttribute<ContactAudit, String> firstName;
	public static volatile SingularAttribute<ContactAudit, DateTime> createdDate;
	public static volatile SingularAttribute<ContactAudit, Integer> version;

}

