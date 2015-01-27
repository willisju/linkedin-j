package com.google.code.linkedinapi.schema;

public interface VolunteerExperience extends SchemaEntity{

	String getId();
	void setId(String value);
	String getRole();
	void setRole(String value);
	SupportedOrganization getOrganization();
	void setOrganization(SupportedOrganization value);
}
