package com.google.code.linkedinapi.schema;

import java.util.List;

public interface Courses extends SchemaEntity {
	
	List<Course> getCoursesList();
    Long getTotal();
    void setTotal(Long value);

}
