/* Copyright 2014   */
package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.google.code.linkedinapi.schema.BoundAccount;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "accountType",
    "bindingStatus",
    "isPrimary",
    "providerAccountId",
    "providerAccountName"
})
@XmlRootElement(name = "bound-account")

public class BoundAccountImpl implements Serializable, BoundAccount{
	
	private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true)
    protected String id;
    @XmlElement(name = "account-type",required = true)
    protected String accountType;
    @XmlElement(name = "binding-status", required = true)
    protected String bindingStatus;
    @XmlElement(required = true)
    protected Boolean isPrimary;
    @XmlElement(name = "provider-account-id", required = true)
    protected String providerAccountId;
    @XmlElement(name = "provider-account-name", required = true)
    protected String providerAccountName;

  
	public String getId() {
		return id;
	}

	public void setId(String value) {
		this.id = value;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String value) {
		this.accountType = value;
	}

	public String getBindingStatus() {
		return bindingStatus;
	}

	public void setBindingStatus(String value) {
		this.bindingStatus = value;
	}

	public Boolean getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(Boolean value) {
		this.isPrimary = value;
	}

	public String getProviderAccountId() {
		return providerAccountId;
	}

	public void setProviderAccountId(String value) {
		this.providerAccountId = value;
	}

	public String getProviderAccountName() {
		return providerAccountName;
	}

	public void setProviderAccountName(String value) {
		this.providerAccountName = value;
	}

}
