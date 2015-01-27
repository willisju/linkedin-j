/* Copyright 2014   */
package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.google.code.linkedinapi.schema.SupportedOrganization;
import com.google.code.linkedinapi.schema.VolunteerExperience;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "role",
    "supportedOrganization"
})
@XmlRootElement(name = "volunteer-experience")

public class VolunteerExperienceImpl implements Serializable, VolunteerExperience {

	private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true)
    protected String id;	
    @XmlElement(required = true)
    protected String role;	
    @XmlElement(name = "organization", type = SupportedOrganizationImpl.class )
    protected SupportedOrganizationImpl supportedOrganization;	
	
	public String getId() {
		return id;
	}

	public void setId(String value) {
		this.id = value;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String value) {
		this.role = value;
	}

	public SupportedOrganization getOrganization() {
		return supportedOrganization;
	}

	public void setOrganization(SupportedOrganization value) {
		this.supportedOrganization = ((SupportedOrganizationImpl) value);
		
	}

}
