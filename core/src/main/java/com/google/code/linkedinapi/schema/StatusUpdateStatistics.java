package com.google.code.linkedinapi.schema;

/**
 * 
 * @author Jonathon Willis
 * 
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
 *
 */

public interface StatusUpdateStatistics {
	
	ViewsByMonth getViewsByMonth();
	void setViewsByMonth(ViewsByMonth value);
	
}
