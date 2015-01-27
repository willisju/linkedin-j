package com.google.code.linkedinapi.schema;

import java.util.List;

public interface Projects extends SchemaEntity {
	
	List<Project> getProjectsList();
    Long getTotal();
    void setTotal(Long value);

}
