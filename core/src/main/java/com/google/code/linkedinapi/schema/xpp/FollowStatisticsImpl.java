package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.FollowStatistics;
import com.google.code.linkedinapi.schema.Seniorities;
import com.google.code.linkedinapi.schema.xpp.SenioritiesImpl;

public class FollowStatisticsImpl extends BaseSchemaEntity implements FollowStatistics{
	
	private static final long serialVersionUID = 4056427594603889947L;
    protected SenioritiesImpl seniorities;
	protected Long count;
    protected Long employeeCount;
    protected Long nonEmployeeCount;

	@Override
	public Long getCount() {
		return count;
	}

	@Override
	public void setCount(Long value) {
		this.count = value;
	}

	@Override
	public Long getEmployeeCount() {
		return employeeCount;
	}

	@Override
	public void setEmployeeCount(Long value) {
		this.employeeCount = value;
	}

	@Override
	public Long getNonEmployeeCount() {
		return nonEmployeeCount;
	}

	@Override
	public void setNonEmployeeCount(Long value) {
		this.nonEmployeeCount = value;
	}

	@Override
	public Seniorities getSeniorities() {
		return seniorities;
	}

	@Override
	public void setSenorities(Seniorities value) {
		this.seniorities = ((SenioritiesImpl) value);
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "follow-statistics");
		XppUtils.setElementValueToNode(element, "count", getCount());
		XppUtils.setElementValueToNode(element, "employee-count", getEmployeeCount());
		XppUtils.setElementValueToNode(element, "non-employee-count", getNonEmployeeCount());
		if (getSeniorities() != null) {
            ((SenioritiesImpl) getSeniorities()).toXml(serializer);
        }
		element.endTag(null, "follow-statistics");	
	}

	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
		while (parser.nextTag() == XmlPullParser.START_TAG) {
			String name = parser.getName();
			if(name.equals("seniorities")){
				SenioritiesImpl senioritiesImpl = new SenioritiesImpl();
				senioritiesImpl.init(parser);
				setSenorities(senioritiesImpl);
			}else if(name.equals("count")){
				setCount(XppUtils.getElementValueAsLongFromNode(parser));
			}else if(name.equals("employee-count")){
				setEmployeeCount(XppUtils.getElementValueAsLongFromNode(parser));
			}else if(name.equals("non-employee-count")){
				setNonEmployeeCount(XppUtils.getElementValueAsLongFromNode(parser));
			}else{
				// Consume something we don't understand.
	        	LOG.warning("Found tag that we don't recognize: " + name);
	        	XppUtils.skipSubTree(parser);
			}
		}
		
	}

}
