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
import com.google.code.linkedinapi.schema.Cause;
import com.google.code.linkedinapi.schema.Causes;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "causesList"
})
@XmlRootElement(name = "causes")

public class CausesImpl implements Serializable, Causes{

	private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "cause", required = true, type = CauseImpl.class)
    protected List<Cause> causesList;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long total;
    
    
    public List<Cause> getCausesList() {
		if (causesList == null) {
			causesList = new ArrayList<Cause>();
        }
        return this.causesList;
	}

	public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

}
