package com.google.code.linkedinapi.schema;

import java.util.List;

public interface RelatedProfileViews extends SchemaEntity{
	
	List<Person> getPersonList();
    Long getTotal();
    void setTotal(Long value);

}
