/* Copyright 2014 */
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Causes;
import com.google.code.linkedinapi.schema.Opportunities;
import com.google.code.linkedinapi.schema.SupportedOrganizations;
import com.google.code.linkedinapi.schema.Volunteer;
import com.google.code.linkedinapi.schema.VolunteerExperiences;
import com.google.code.linkedinapi.schema.xpp.CausesImpl;
import com.google.code.linkedinapi.schema.xpp.OpportunitiesImpl;
import com.google.code.linkedinapi.schema.xpp.SupportedOrganizationsImpl;
import com.google.code.linkedinapi.schema.xpp.VolunteerExperiencesImpl;

public class VolunteerImpl extends BaseSchemaEntity implements Volunteer{
	
	private final static long serialVersionUID = 2461660169443089969L;
    protected VolunteerExperiencesImpl volunteerExperiences;
    protected CausesImpl causes;
    protected SupportedOrganizationsImpl supportedOrganizations;
    protected  OpportunitiesImpl opportunities;

    public VolunteerExperiences getVolunteerExperiences() {
        return volunteerExperiences;
    }

    public void setVolunteerExperiences(VolunteerExperiences value) {
        this.volunteerExperiences = ((VolunteerExperiencesImpl) value);
    }
    
    public Causes getCauses() {
        return causes;
    }

    public void setCauses(Causes value) {
        this.causes = ((CausesImpl) value);
    }

    public SupportedOrganizations getSupportedOrganizations() {
        return supportedOrganizations;
    }

    public void setSupportedOrganizations(SupportedOrganizations value) {
        this.supportedOrganizations = ((SupportedOrganizationsImpl) value);
    }

    public Opportunities getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(Opportunities value) {
        this.opportunities = ((OpportunitiesImpl) value);
    }
    
    @Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("volunter-experiences")) {
        		VolunteerExperiencesImpl volExImpl = new VolunteerExperiencesImpl();
        		volExImpl.init(parser);
    			setVolunteerExperiences(volExImpl);
            } else if(name.equals("causes")){
            	CausesImpl causeImpl = new CausesImpl();
            	causeImpl.init(parser);
    			setCauses(causeImpl);
            } else if(name.equals("supported-organizations")){
            	SupportedOrganizationsImpl suppOrgImpl = new SupportedOrganizationsImpl();
            	suppOrgImpl.init(parser);
    			setSupportedOrganizations(suppOrgImpl);
            } else if(name.equals("opportunities")){
            	OpportunitiesImpl oppImpl = new OpportunitiesImpl();
            	oppImpl.init(parser);
    			setOpportunities(oppImpl);
            } else {
                // Consume something we don't understand.
            	LOG.warning("Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
            }
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "volunteer");
		    if (getVolunteerExperiences() != null) {
	            ((VolunteerExperienceImpl) getVolunteerExperiences()).toXml(serializer);
	        }
	        if (getCauses() != null) {
	            ((CausesImpl) getCauses()).toXml(serializer);
	        }
	        if (getSupportedOrganizations() != null) {
	            ((SupportedOrganizationsImpl) getSupportedOrganizations()).toXml(serializer);
	        }
	        if (getOpportunities() != null) {
	            ((OpportunitiesImpl) getOpportunities()).toXml(serializer);
	        }
		element.endTag(null, "volunteer");
	}

}
