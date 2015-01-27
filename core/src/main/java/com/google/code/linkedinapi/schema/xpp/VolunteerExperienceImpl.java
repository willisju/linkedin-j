/* Copyright 2014 */
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.SupportedOrganization;
import com.google.code.linkedinapi.schema.VolunteerExperience;
import com.google.code.linkedinapi.schema.xpp.SupportedOrganizationImpl;

public class VolunteerExperienceImpl extends BaseSchemaEntity implements VolunteerExperience {

	private final static long serialVersionUID = 2461660169443089969L;
	protected String id;
	protected String role;
	protected SupportedOrganizationImpl supportedOrganization;
	
	
	public String getId() {
		return id;
	}

	public void setId(String value) {
		this.id = value;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String value) {
		this.role = value;
	}

	public SupportedOrganization getOrganization() {
		return supportedOrganization;
	}

	public void setOrganization(SupportedOrganization value) {
		this.supportedOrganization = ((SupportedOrganizationImpl) value);
	}
	
	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "volunteer-experience");
			XppUtils.setElementValueToNode(element, "id", getId());
			XppUtils.setElementValueToNode(element, "role", getRole());
			if (getOrganization() != null) {
				((SupportedOrganizationImpl) getOrganization()).toXml(serializer);
			}
		element.endTag(null, "volunteer-experience");
	}
	
	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
	    parser.require(XmlPullParser.START_TAG, null, null);
	
	    while (parser.nextTag() == XmlPullParser.START_TAG) {
	    	String name = parser.getName();
	    	if (name.equals("id")) {
	    		setId(XppUtils.getElementValueFromNode(parser));
	        } else if (name.equals("role")) {
	    		setRole(XppUtils.getElementValueFromNode(parser));
	        } else if (name.equals("organization")) {
	        	SupportedOrganizationImpl org = new SupportedOrganizationImpl();
    			org.init(parser);
    			setOrganization(org);
	        } else {
	            // Consume something we don't understand.
	        	LOG.warning("Found tag that we don't recognize: " + name);
	        	XppUtils.skipSubTree(parser);
	        }
	    }
	}

}