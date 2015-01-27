package com.google.code.linkedinapi.schema;

import java.util.List;

public interface HonorsAwards extends SchemaEntity {
	
	 List<HonorAward> getHonorAwardsList();
     Long getTotal();
     void setTotal(Long value);

}
