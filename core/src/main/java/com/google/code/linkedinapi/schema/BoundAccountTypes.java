package com.google.code.linkedinapi.schema;

import java.util.List;

public interface BoundAccountTypes extends SchemaEntity {

	List<BoundAccountType> getBoundAccountTypesList();
    Long getTotal();
    void setTotal(Long value);
	
}
