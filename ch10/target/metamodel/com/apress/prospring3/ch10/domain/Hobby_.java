package com.apress.prospring3.ch10.domain;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Hobby.class)
public abstract class Hobby_ {

	public static volatile SingularAttribute<Hobby, String> hobbyId;
	public static volatile SetAttribute<Hobby, Contact> contacts;

}

