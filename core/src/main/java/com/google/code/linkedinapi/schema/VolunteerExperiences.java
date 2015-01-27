package com.google.code.linkedinapi.schema;

import java.util.List;

public interface VolunteerExperiences extends SchemaEntity{

	List<VolunteerExperience> getVolunteerExperiencesList();
    Long getTotal();
    void setTotal(Long value);
	
}
