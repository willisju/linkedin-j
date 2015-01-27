/* Copyright 2014   */
package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.google.code.linkedinapi.schema.Cause;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name"
})
@XmlRootElement(name = "cause")

public class CauseImpl implements Serializable, Cause{

	private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true)
    protected String name;	
	
	public String getName() {
		return name;
	}

	public void setName(String value) {
		this.name = value;
	}

}
