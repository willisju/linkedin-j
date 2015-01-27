package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.google.code.linkedinapi.schema.Companies;
import com.google.code.linkedinapi.schema.Industries;
import com.google.code.linkedinapi.schema.ToFollow;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "companies",
    "industries"
})
@XmlRootElement(name = "to-follow")

public class ToFollowImpl implements Serializable, ToFollow {
	
	private final static long serialVersionUID = 2461660169443089969L;
	@XmlElement(required = true, type = CompaniesImpl.class)
    protected CompaniesImpl  companies;
    @XmlElement(required = true, type = IndustriesImpl.class)
    protected IndustriesImpl industries;
    
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


}
