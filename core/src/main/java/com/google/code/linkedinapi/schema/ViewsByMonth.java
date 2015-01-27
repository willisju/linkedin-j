package com.google.code.linkedinapi.schema;

import java.util.List;

public interface ViewsByMonth {

	List<ViewByMonth> getViewByMonthList();
	
	Long getTotal();
	void setTotal(Long value);
	
}
