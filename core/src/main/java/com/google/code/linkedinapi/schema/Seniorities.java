package com.google.code.linkedinapi.schema;

import java.util.List;

public interface Seniorities {
	
	List<Seniority> getSeniorityList();
	
	Long getTotal();
	void setTotal(Long value);

}
