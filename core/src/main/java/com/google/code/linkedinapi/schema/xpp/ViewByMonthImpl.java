package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Date;
import com.google.code.linkedinapi.schema.ViewByMonth;
import com.google.code.linkedinapi.schema.xpp.DateImpl;

public class ViewByMonthImpl extends BaseSchemaEntity implements ViewByMonth {
	
	private static final long serialVersionUID = 4345388614456471465L;
    protected DateImpl date;
    protected Long clicks;
    protected Long likes;
    protected Long comments;
	protected Long shares;
    protected Long impressions;
    protected String engagement;

	@Override
	public Date getDate() {
		return date;
	}

	@Override
	public void setDate(Date value) {
		this.date = ((DateImpl) value);
	}

	@Override
	public Long getNumClicks() {
		return clicks;
	}

	@Override
	public void setNumClicks(Long value) {
		this.clicks = value;
	}

	@Override
	public Long getNumLikes() {
		return likes;
	}

	@Override
	public void setNumLikes(Long value) {
		this.likes = value;
	}

	@Override
	public Long getNumComments() {
		return comments;
	}

	@Override
	public void setNumComments(Long value) {
		this.comments = value;
	}

	@Override
	public Long getNumShares() {
		return shares;
	}

	@Override
	public void setNumShares(Long value) {
		this.shares = value;
	}

	@Override
	public Long getNumImpressions() {
		return impressions;
	}

	@Override
	public void setNumImpressions(Long value) {
		this.impressions = value;
	}

	@Override
	public String getEngagement() {
		return engagement;
	}

	@Override
	public void setEngagement(String value) {
		this.engagement = value;
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "view-by-month");
		XppUtils.setElementValueToNode(element, "clicks", getNumClicks());
		XppUtils.setElementValueToNode(element, "likes", getNumLikes());
		XppUtils.setElementValueToNode(element, "comments", getNumComments());
		XppUtils.setElementValueToNode(element, "engagement", getEngagement());
		XppUtils.setElementValueToNode(element, "shares", getNumShares());
		XppUtils.setElementValueToNode(element, "impressions", getNumImpressions());
		if (getDate() != null) {
			((DateImpl) getDate()).toXml(serializer);
		}
		element.endTag(null, "view-by-month");
	}

	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
		   parser.require(XmlPullParser.START_TAG, null, null);

	        while (parser.nextTag() == XmlPullParser.START_TAG) {
	        	String name = parser.getName();
	        	if (name.equals("date")) {
	        		DateImpl dateImpl = new DateImpl();
	        		dateImpl.init(parser);
	        		setDate(dateImpl);
	        	}else if(name.equals("clicks")){
	        		setNumClicks(XppUtils.getElementValueAsLongFromNode(parser));
	        	}else if(name.equals("comments")){
	        		setNumComments(XppUtils.getElementValueAsLongFromNode(parser));
	        	}else if(name.equals("likes")){
	        		setNumLikes(XppUtils.getElementValueAsLongFromNode(parser));
	        	}else if(name.equals("shares")){
	        		setNumShares(XppUtils.getElementValueAsLongFromNode(parser));
	        	}else if(name.equals("impressions")){
	        		setNumImpressions(XppUtils.getElementValueAsLongFromNode(parser));
	        	}else if(name.equals("engagements")){
	        		setEngagement(XppUtils.getElementValueFromNode(parser));
	        	}else{
	                // Consume something we don't understand.
	            	LOG.warning("Found tag that we don't recognize: " + name);
	            	XppUtils.skipSubTree(parser);
	        	}
	        }
		
	}

}
