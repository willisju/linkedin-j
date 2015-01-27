package com.google.code.linkedinapi.schema;

public interface Following extends SchemaEntity{
	
	Industries getIndustries();
	void setIndustries(Industries value);
	Companies getCompanies();
	void setCompanies(Companies value);
	People getPeople();
	void setPeople(People value);

}
