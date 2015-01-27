package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.CompanyStatistics;
import com.google.code.linkedinapi.schema.FollowStatistics;
import com.google.code.linkedinapi.schema.StatusUpdateStatistics;
import com.google.code.linkedinapi.schema.xpp.FollowStatisticsImpl;
import com.google.code.linkedinapi.schema.xpp.StatusUpdateStatisticsImpl;

public class CompanyStatisticsImpl extends BaseSchemaEntity implements CompanyStatistics{
	
	private static final long serialVersionUID = 1L;
    protected StatusUpdateStatistics statusUpdateStatistics;
    protected FollowStatistics followStatistics;
    

	@Override
	public StatusUpdateStatistics getStatusUpdateStatistics() {
		return statusUpdateStatistics;
	}

	@Override
	public void setStatusUpdateStatistics(StatusUpdateStatistics value) {
		this.statusUpdateStatistics = value;
	}

	@Override
	public FollowStatistics getFollowStatistics() {
		return followStatistics;
	}

	@Override
	public void setFollowStatistics(FollowStatistics value) {
		this.followStatistics = value;
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "company-statistics");
		element.endTag(null, "company-statistics");
		
	}

	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
		parser.require(XmlPullParser.START_TAG, null, null);

	    while (parser.nextTag() == XmlPullParser.START_TAG) {
	    	String name = parser.getName();
	    	if (name.equals("follow-statistics")) {
	    		FollowStatisticsImpl followStatisticsImpl = new FollowStatisticsImpl();
	    		followStatisticsImpl.init(parser);
	    		setFollowStatistics(followStatisticsImpl);
	        } else if(name.equals("status-update-statistics")){
	        	StatusUpdateStatisticsImpl statusUpdateStatisticsImpl = new StatusUpdateStatisticsImpl();
	        	statusUpdateStatisticsImpl.init(parser);
	    		setStatusUpdateStatistics(statusUpdateStatisticsImpl);
	        } else {
	            // Consume something we don't understand.
	        	LOG.warning("Found tag that we don't recognize: " + name);
	        	XppUtils.skipSubTree(parser);
	        }
	    }
		
	}

}
