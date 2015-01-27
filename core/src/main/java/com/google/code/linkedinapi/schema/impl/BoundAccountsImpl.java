/* Copyright 2014   */
package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.google.code.linkedinapi.schema.Adapter1;
import com.google.code.linkedinapi.schema.BoundAccount;
import com.google.code.linkedinapi.schema.BoundAccounts;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "boundAccountsList"
})
@XmlRootElement(name = "bound-accounts")

public class BoundAccountsImpl  implements Serializable, BoundAccounts {
	
	private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "bound-account", required = true, type = BoundAccountImpl.class)
    protected List<BoundAccount> boundAccountsList;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(Adapter1.class)
    protected Long total;
    
    public List<BoundAccount> getBoundAccountsList() {
		if (boundAccountsList == null) {
			boundAccountsList = new ArrayList<BoundAccount>();
        }
        return this.boundAccountsList;
	}

	public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

}
