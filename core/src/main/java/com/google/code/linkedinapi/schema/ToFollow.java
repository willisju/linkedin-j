package com.google.code.linkedinapi.schema;

public interface ToFollow extends SchemaEntity {
	
	Industries getIndustries();
	void setIndustries(Industries value);
	Companies getCompanies();
	void setCompanies(Companies value);

}
