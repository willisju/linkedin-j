package com.google.code.linkedinapi.schema;

import com.google.code.linkedinapi.schema.Opportunities;


public interface Volunteer extends SchemaEntity{
	
	Causes getCauses();
	void setCauses(Causes Value);
	VolunteerExperiences getVolunteerExperiences();
	void setVolunteerExperiences(VolunteerExperiences Value);
	SupportedOrganizations getSupportedOrganizations();
	void setSupportedOrganizations(SupportedOrganizations Value);
	Opportunities getOpportunities();
	void setOpportunities(Opportunities value);
	

}
