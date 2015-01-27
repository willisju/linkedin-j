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
import com.google.code.linkedinapi.schema.SupportedOrganization;
import com.google.code.linkedinapi.schema.SupportedOrganizations;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "supportedOrganizationsList"
})
@XmlRootElement(name = "supported-organizations")

public class SupportedOrganizationsImpl implements Serializable, SupportedOrganizations{

	private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "organization", required = true, type = SupportedOrganizationImpl.class)
    protected List<SupportedOrganization> supportedOrganizationsList;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long total;


    public List<SupportedOrganization> getSupportedOrganizationsList() {
    	if (supportedOrganizationsList == null) {
    		supportedOrganizationsList = new ArrayList<SupportedOrganization>();
        }
        return this.supportedOrganizationsList;
	}

	public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }


	

	

}
