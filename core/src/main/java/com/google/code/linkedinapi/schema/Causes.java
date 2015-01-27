package com.google.code.linkedinapi.schema;

import java.util.List;

public interface Causes extends SchemaEntity{
	
	List<Cause> getCausesList();
    Long getTotal();
    void setTotal(Long value);

}
