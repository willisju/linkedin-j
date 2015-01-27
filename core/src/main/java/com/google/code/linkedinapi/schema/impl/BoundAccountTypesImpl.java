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
import com.google.code.linkedinapi.schema.BoundAccountType;
import com.google.code.linkedinapi.schema.BoundAccountTypes;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "boundAccountTypesList"
})
@XmlRootElement(name = "bound-account-types")

public class BoundAccountTypesImpl implements Serializable, BoundAccountTypes {

	private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "bound-account-type", required = true, type = BoundAccountTypeImpl.class)
    protected List<BoundAccountType> boundAccountTypesList;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(Adapter1.class)
    protected Long total;
	
	public List<BoundAccountType> getBoundAccountTypesList() {
		if (boundAccountTypesList == null) {
			boundAccountTypesList = new ArrayList<BoundAccountType>();
        }
        return this.boundAccountTypesList;
	}

	public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

}
