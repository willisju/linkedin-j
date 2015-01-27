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
import com.google.code.linkedinapi.schema.HonorAward;
import com.google.code.linkedinapi.schema.HonorsAwards;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "honorsAwardsList"
})
@XmlRootElement(name = "honors-awards")

public class HonorsAwardsImpl  implements Serializable, HonorsAwards{
	
	private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "honor-award", required = true, type = HonorAwardImpl.class)
    protected List<HonorAward> honorsAwardsList;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long total;
    
	public List<HonorAward> getHonorAwardsList() {
		if (honorsAwardsList == null) {
			honorsAwardsList = new ArrayList<HonorAward>();
        }
		return honorsAwardsList;
	}
	
	public Long getTotal() {
		return total;
	}
	
	public void setTotal(Long value) {
		this.total = value;
	}

}
