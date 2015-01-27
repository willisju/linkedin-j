/* Copyright 2014   */
package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.google.code.linkedinapi.schema.PrimaryTwitterAccount;


	
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "providerAccountId",
    "providerAccountName"
})
@XmlRootElement(name = "primary-twitter-account")
public class PrimaryTwitterAccountImpl implements Serializable, PrimaryTwitterAccount{
	
	private final static long serialVersionUID = 2461660169443089969L;
	@XmlElement(name = "provider-account-id")
    protected String providerAccountId;
	@XmlElement(name = "provider-account-name")
    protected String providerAccountName;
    

	public String getId() {
		return providerAccountId;
	}

	public void setId(String value) {
		this.providerAccountId = value;
	}

	public String getName() {
		return providerAccountName;
	}

	public void setName(String value) {
		this.providerAccountName = value;
	}
	
}
