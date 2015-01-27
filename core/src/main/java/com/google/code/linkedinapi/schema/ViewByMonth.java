package com.google.code.linkedinapi.schema;

public interface ViewByMonth {
	
	Date getDate();
	void setDate(Date value);
	
	Long getNumClicks();
	void setNumClicks(Long value);
	
	Long getNumLikes();
	void setNumLikes(Long value);
	
	Long getNumComments();
	void setNumComments(Long value);
	
	Long getNumShares();
	void setNumShares(Long value);
	
	Long getNumImpressions();
	void setNumImpressions(Long value);
	
	String getEngagement();
	void setEngagement(String value);

}
