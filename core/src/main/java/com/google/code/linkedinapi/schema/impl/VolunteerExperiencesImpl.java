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
import com.google.code.linkedinapi.schema.VolunteerExperience;
import com.google.code.linkedinapi.schema.VolunteerExperiences;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "volunteerList"
})
@XmlRootElement(name = "volunteer-experiences")

public class VolunteerExperiencesImpl implements Serializable, VolunteerExperiences{
	
	private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "volunteer-experience", required = true, type = VolunteerExperienceImpl.class)
    protected List<VolunteerExperience> volunteerList;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long total;


	public List<VolunteerExperience> getVolunteerExperiencesList() {
		if (volunteerList == null) {
			volunteerList = new ArrayList<VolunteerExperience>();
        }
        return this.volunteerList;
	}

	public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

}
