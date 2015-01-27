package com.google.code.linkedinapi.schema;
/**
 * 
 * @author Jonathon Willis
 *
 *<company-statistics>
 *  <status-update-statistics>
 *   <views-by-month total="12">
 *     <view-by-month>
 *       <date>
 *         <year>2012</year>
 *         <month>11</month>
 *       </date>
 *       <clicks>1</clicks>
 *       <likes>0</likes>
 *       <comments>0</comments>
 *       <shares>0</shares>
 *       <impressions>150</impressions>
 *       <engagement>0.006666666666666667</engagement>
 *     </view-by-month>
 * </status-update-statistics>
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
 *</company-statistics>
 *
 */

public interface CompanyStatistics {
	
	StatusUpdateStatistics getStatusUpdateStatistics();
	void setStatusUpdateStatistics(StatusUpdateStatistics value);
	FollowStatistics getFollowStatistics();
	void setFollowStatistics(FollowStatistics value);

}
