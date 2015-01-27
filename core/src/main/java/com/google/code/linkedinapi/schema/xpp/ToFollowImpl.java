package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Companies;
import com.google.code.linkedinapi.schema.Industries;
import com.google.code.linkedinapi.schema.ToFollow;

public class ToFollowImpl extends BaseSchemaEntity implements ToFollow {
	
	private final static long serialVersionUID = 2461660169443089969L;
    protected CompaniesImpl  companies;
    protected IndustriesImpl industries;
    protected String specialEditions;
    protected String people;

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
	
	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "to-follow");
		    if (getCompanies() != null) {
	            ((CompaniesImpl)getCompanies()).toXml(serializer);
	        }
	        if (getIndustries() != null) {
	            ((IndustriesImpl) getIndustries()).toXml(serializer);
	        }
	       
		element.endTag(null, "to-follow");
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
	            } else {
	                // Consume something we don't understand.
	            	LOG.warning("Found tag that we don't recognize: " + name);
	            	XppUtils.skipSubTree(parser);
	            }
	        }
		
	}
}
