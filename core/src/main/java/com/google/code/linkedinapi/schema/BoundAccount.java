package com.google.code.linkedinapi.schema;

/**
 * 
 * @author Jonathon Willis
 * <bound-account>
 *    <id></id>
	  <account-type></account-type>
	  <binding-status></binding-status>
	  <is-primary></is-primary>
	  <provider-account-id></provider-account-id>
	  <provider-account-name></provider-account-name>
  <bound-account>
 */

public interface BoundAccount extends SchemaEntity {
	
	String getId();
	void setId(String value);
	String getAccountType();
	void setAccountType(String value);
	String getBindingStatus();
	void setBindingStatus(String value);
	Boolean getIsPrimary();
	void setIsPrimary(Boolean value);
	String getProviderAccountId();
	void setProviderAccountId(String value);
	String getProviderAccountName();
	void setProviderAccountName(String value);
	

}
