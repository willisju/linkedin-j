/* Copyright 2014 */
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Companies;
import com.google.code.linkedinapi.schema.Following;
import com.google.code.linkedinapi.schema.Industries;
import com.google.code.linkedinapi.schema.People;
import com.google.code.linkedinapi.schema.xpp.PeopleImpl;
import com.google.code.linkedinapi.schema.xpp.CompaniesImpl;
import com.google.code.linkedinapi.schema.xpp.IndustriesImpl;

public class FollowingImpl extends BaseSchemaEntity implements Following {
	
	private final static long serialVersionUID = 2461660169443089969L;
    protected CompaniesImpl  companies;
    protected IndustriesImpl industries;
    protected String specialEditions;
    protected PeopleImpl people;

	public Industries getIndustries() {
		return industries;
	}
	public void setIndustries(Industries value) {
		this.industries = ((IndustriesImpl) value);
	}
	public Companies getCompanies() {
		return companies;
	}
	public void setCompanies(Companies value) {
		this.companies = ((CompaniesImpl) value);
	}
	public People getPeople() {
		return people;
	}
	public void setPeople(People value) {
		this.people = ((PeopleImpl) value);
		
	}
	
	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "following");
		    if (getCompanies() != null) {
	            ((CompaniesImpl) getCompanies()).toXml(serializer);
	        }
	        if (getIndustries() != null) {
	            ((IndustriesImpl) getIndustries()).toXml(serializer);
	        }
	        if (getPeople() != null) {
	            ((PeopleImpl) getPeople()).toXml(serializer);
	        }
	       
		element.endTag(null, "following");
	}

	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
		 parser.require(XmlPullParser.START_TAG, null, null);
	        while (parser.nextTag() == XmlPullParser.START_TAG) {
	        	String name = parser.getName();
	        	
	        	if (name.equals("industries")) {
	        		IndustriesImpl indImpl = new IndustriesImpl();
	        		indImpl.init(parser);
	    			setIndustries(indImpl);
	            } else if(name.equals("companies")){
	            	CompaniesImpl compImpl = new CompaniesImpl();
	            	compImpl.init(parser);
	    			setCompanies(compImpl);
	            } else if(name.equals("people")){
	            	PeopleImpl peopleImpl = new PeopleImpl();
	            	 peopleImpl.init(parser);
	    			setPeople(peopleImpl);
	            } else {
	                // Consume something we don't understand.
	            	LOG.warning("Found tag that we don't recognize: " + name);
	            	XppUtils.skipSubTree(parser);
	            }
	        }
		
	}

}
