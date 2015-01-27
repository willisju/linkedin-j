/* Copyright 2014   */
package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.google.code.linkedinapi.schema.Adapter1;
import com.google.code.linkedinapi.schema.BoundAccountType;
import com.google.code.linkedinapi.schema.BoundAccounts;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "boundAccounts",
    "numAccounts"
    
})
@XmlRootElement(name = "bound-account-type")

public class BoundAccountTypeImpl  implements Serializable, BoundAccountType{
	
	 private final static long serialVersionUID = 2461660169443089969L;
	 @XmlElement(name = "bound-accounts", type = BoundAccountsImpl.class )
	 protected  BoundAccountsImpl boundAccounts;	
	 @XmlElement(name = "num-accounts", required= true)
	 @XmlJavaTypeAdapter(Adapter1 .class)
	 protected Long numAccounts;
	 

	public Long getNumAccounts() {
		return numAccounts;
	}

	public void setNumAccounts(Long value) {
		this.numAccounts = value;
	}

	public BoundAccounts getBoundAccounts() {
		return boundAccounts;
	}

	public void setBoundAccounts(BoundAccounts value) {
		this.boundAccounts = ((BoundAccountsImpl) value);
	}

}
