package com.google.code.linkedinapi.schema;


public interface BoundAccountType extends SchemaEntity {
	
	 Long getNumAccounts();
	 void setNumAccounts(Long value);
	 BoundAccounts getBoundAccounts();
	 void setBoundAccounts(BoundAccounts value);

}
