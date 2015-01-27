/* Copyright 2014   */
package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.google.code.linkedinapi.schema.Causes;
import com.google.code.linkedinapi.schema.Opportunities;
import com.google.code.linkedinapi.schema.SupportedOrganizations;
import com.google.code.linkedinapi.schema.Volunteer;
import com.google.code.linkedinapi.schema.VolunteerExperiences;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "volunteerExperiences",
    "causes",
    "supportedOrganizations",
    "opportunities"
})
@XmlRootElement(name = "volunteer")

public class VolunteerImpl implements Serializable, Volunteer{

	private final static long serialVersionUID = 2461660169443089969L;
	@XmlElement(name = "volunteer-experiences", required = true, type = VolunteerExperiencesImpl.class)
    protected VolunteerExperiencesImpl  volunteerExperiences;
    @XmlElement(required = true, type = CausesImpl.class)
    protected CausesImpl causes;
    @XmlElement(name = "supported-organizations", required = true, type = SupportedOrganizationsImpl.class)
    protected SupportedOrganizationsImpl supportedOrganizations;
    @XmlElement(required = true, type = OpportunitiesImpl.class)
    protected  OpportunitiesImpl opportunities;
    
    public VolunteerExperiences getVolunteerExperiences() {
        return volunteerExperiences;
    }

    public void setVolunteerExperiences(VolunteerExperiences value) {
        this.volunteerExperiences = ((VolunteerExperiencesImpl) value);
    }
    
    public Causes getCauses() {
        return causes;
    }

    public void setCauses(Causes value) {
        this.causes = ((CausesImpl) value);
    }

    public SupportedOrganizations getSupportedOrganizations() {
        return supportedOrganizations;
    }

    public void setSupportedOrganizations(SupportedOrganizations value) {
        this.supportedOrganizations = ((SupportedOrganizationsImpl) value);
    }

    public Opportunities getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(Opportunities value) {
        this.opportunities = ((OpportunitiesImpl) value);
    }




}
