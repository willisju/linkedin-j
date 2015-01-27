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
import com.google.code.linkedinapi.schema.Seniorities;
import com.google.code.linkedinapi.schema.Seniority;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "seniorityList"
})
@XmlRootElement(name = "seniorities")

public class SenioritiesImpl implements Serializable, Seniorities{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4345388614456471465L;
	@XmlElement(name = "seniority", required = true, type = SeniorityImpl.class)
    protected List<Seniority> seniorityList;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long total;

	@Override
	public List<Seniority> getSeniorityList() {
		if(seniorityList == null){
			seniorityList = new ArrayList<Seniority>();
		}
		return seniorityList;
	}

	@Override
	public Long getTotal() {
		return total;
	}

	@Override
	public void setTotal(Long value) {
		this.total = value;
	}

}
