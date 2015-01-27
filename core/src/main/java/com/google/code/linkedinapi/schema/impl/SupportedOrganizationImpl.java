/* Copyright 2014   */
package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.google.code.linkedinapi.schema.SupportedOrganization;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name",
    "id"
})
@XmlRootElement(name = "organization")

public class SupportedOrganizationImpl implements Serializable, SupportedOrganization {

	private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true)
    protected String name;
    protected String id;	
    
	public String getId() {
		return id;
	}

	public void setId(String value) {
		this.id = value;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String value) {
		this.name = value;
	}
	

	

}
