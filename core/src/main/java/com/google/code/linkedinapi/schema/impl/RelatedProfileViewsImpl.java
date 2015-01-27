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
import com.google.code.linkedinapi.schema.Person;
import com.google.code.linkedinapi.schema.RelatedProfileViews;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "personList"
})
@XmlRootElement(name = "related-profile-views")

public class RelatedProfileViewsImpl implements Serializable, RelatedProfileViews{
	
	private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "person", required = true, type = PersonImpl.class)
    protected List<Person> personList;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long total;
    
	public List<Person> getPersonList() {
		if (personList == null) {
			personList = new ArrayList<Person>();
        }
		return personList;
	}
	
	public Long getTotal() {
		return total;
	}
	
	public void setTotal(Long value) {
		this.total = value;
	}

}
