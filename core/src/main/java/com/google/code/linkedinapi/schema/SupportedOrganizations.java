package com.google.code.linkedinapi.schema;

import java.util.List;

public interface SupportedOrganizations extends SchemaEntity{

	List<SupportedOrganization> getSupportedOrganizationsList();
    Long getTotal();
    void setTotal(Long value);
}
