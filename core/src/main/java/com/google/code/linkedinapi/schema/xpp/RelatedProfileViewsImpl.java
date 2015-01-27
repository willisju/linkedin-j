/* Copyright 2014 */
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Person;
import com.google.code.linkedinapi.schema.RelatedProfileViews;
import com.google.code.linkedinapi.schema.xpp.PersonImpl;

public class RelatedProfileViewsImpl extends BaseSchemaEntity implements RelatedProfileViews {
	
	private final static long serialVersionUID = 2461660169443089969L;
	protected List<Person> personList;
    protected Long total;

    public List<Person> getPersonList() {
        if (personList == null) {
            personList = new ArrayList<Person>();
        }
        return this.personList;
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
	        	
	        	if (name.equals("honor-award")) {
	        		PersonImpl personImpl = new PersonImpl();
	        		personImpl.init(parser);
	    			getPersonList().add(personImpl);
	            } else {
	                // Consume something we don't understand.
	            	LOG.warning("Found tag that we don't recognize: " + name);
	            	XppUtils.skipSubTree(parser);
	            }
	        }
		
	}
	
	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "related-profile-views");
		XppUtils.setAttributeValueToNode(element, "total", getTotal());
		for (Person pers : getPersonList()) {
			((PersonImpl) pers).toXml(serializer);
		}
		serializer.endTag(null, "related-profile-views");
		
	}

}
