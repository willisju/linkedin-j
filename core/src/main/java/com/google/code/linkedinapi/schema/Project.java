package com.google.code.linkedinapi.schema;

public interface Project extends SchemaEntity {
	
	String getId();
    void setId(String value);
    String getName();
    void setName(String value);
    String getDescription();
    void setDescription(String value);
    String getUrl();
    void setUrl(String value);
}
