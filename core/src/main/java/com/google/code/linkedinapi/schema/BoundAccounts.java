package com.google.code.linkedinapi.schema;

import java.util.List;

public interface BoundAccounts extends SchemaEntity {
	
	List<BoundAccount> getBoundAccountsList();
    Long getTotal();
    void setTotal(Long value);

}
