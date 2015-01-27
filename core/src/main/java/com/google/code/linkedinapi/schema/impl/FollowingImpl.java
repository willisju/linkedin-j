/* Copyright 2014   */
package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.google.code.linkedinapi.schema.Companies;
import com.google.code.linkedinapi.schema.Following;
import com.google.code.linkedinapi.schema.Industries;
import com.google.code.linkedinapi.schema.People;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "companies",
    "industries",
    "specialEditions",
    "people"
})
@XmlRootElement(name = "following")

public class FollowingImpl implements Serializable, Following {
	
	private final static long serialVersionUID = 2461660169443089969L;
	@XmlElement(required = true, type = CompaniesImpl.class)
    protected CompaniesImpl  companies;
    @XmlElement(required = true, type = IndustriesImpl.class)
    protected IndustriesImpl industries;
    @XmlElement(name = "special-editions")
    protected String specialEditions;
    @XmlElement(required = true, type = PeopleImpl.class)
    protected PeopleImpl people;
    
	public Industries getIndustries() {
		return industries;
	}
	public void setIndustries(Industries value) {
		this.industries = ((IndustriesImpl) value);
	}
	public Companies getCompanies() {
		return companies;
	}
	public void setCompanies(Companies value) {
		this.companies = ((CompaniesImpl) value);
	}
	public People getPeople() {
		return people;
	}
	public void setPeople(People value) {
		this.people = ((PeopleImpl) value);
		
	}

}
