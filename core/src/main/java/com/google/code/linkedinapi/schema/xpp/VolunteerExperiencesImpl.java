/* Copyright 2014 */
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.VolunteerExperience;
import com.google.code.linkedinapi.schema.VolunteerExperiences;

public class VolunteerExperiencesImpl extends BaseSchemaEntity implements VolunteerExperiences {

	private final static long serialVersionUID = 2461660169443089969L;
	protected List<VolunteerExperience> volunteerList;
	protected Long total;
	
	public List<VolunteerExperience> getVolunteerExperiencesList() {
	    if (volunteerList == null) {
	    	volunteerList = new ArrayList<VolunteerExperience>();
	    }
	    return this.volunteerList;
	}
	
	public Long getTotal() {
	    return total;
	}
	
	public void setTotal(Long value) {
	    this.total = value;
	}
	
	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
	    parser.require(XmlPullParser.START_TAG, null, null);
		setTotal(XppUtils.getAttributeValueAsLongFromNode(parser, "total"));
	
	    while (parser.nextTag() == XmlPullParser.START_TAG) {
	    	String name = parser.getName();
	    	
	    	if (name.equals("volunteer-experience")) {
	    		VolunteerExperienceImpl volImpl = new VolunteerExperienceImpl();
	    		volImpl.init(parser);
				getVolunteerExperiencesList().add(volImpl);
	        } else {
	            // Consume something we don't understand.
	        	LOG.warning("Found tag that we don't recognize: " + name);
	        	XppUtils.skipSubTree(parser);
	        }
	    }
	}
	
	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "volunteer-experiences");
		XppUtils.setAttributeValueToNode(element, "total", getTotal());
		for (VolunteerExperience vol : getVolunteerExperiencesList()) {
			((VolunteerExperienceImpl) vol).toXml(serializer);
		}
		element.endTag(null, "volunteer-experiences");
	}
}