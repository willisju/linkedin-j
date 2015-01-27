/* Copyright 2014   */
package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.google.code.linkedinapi.schema.HonorAward;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "name",
    "issuer"
})
@XmlRootElement(name = "honor-award")

public class HonorAwardImpl implements Serializable, HonorAward{
	
	private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String issuer;
	
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

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String value) {
		this.issuer = value;
	}

}
