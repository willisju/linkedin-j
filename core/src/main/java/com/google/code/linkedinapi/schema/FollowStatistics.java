package com.google.code.linkedinapi.schema;

import java.util.List;

/**
 * 
 * @author Jonathon Willis
 *
 * <follow-statistics>
 *   <count>11</count>
 *   <employee-count>0</employee-count>
 *   <non-employee-count>11</non-employee-count>
 *   <seniorities total="11">
 *     <seniority>
 *       <entry-key>4</entry-key>
 *       <entry-value>5</entry-value>
 *     </seniority>
 * </follow-statistics>
 *
 */

public interface FollowStatistics {
	
	
	Long getCount();
	void setCount(Long value);
	
	Long getEmployeeCount();
	void setEmployeeCount(Long value);
	
	Long getNonEmployeeCount();
	void setNonEmployeeCount(Long value);
	
	Seniorities getSeniorities();
	void setSenorities(Seniorities value);
	
	

}
