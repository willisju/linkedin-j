/* Copyright 2014 */
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.SupportedOrganization;
import com.google.code.linkedinapi.schema.SupportedOrganizations;

public class SupportedOrganizationsImpl extends BaseSchemaEntity implements SupportedOrganizations {

	private final static long serialVersionUID = 2461660169443089969L;
	protected List<SupportedOrganization> supportedOrganizationsList;
	protected Long total;
	
	public List<SupportedOrganization> getSupportedOrganizationsList() {
	    if (supportedOrganizationsList == null) {
	    	supportedOrganizationsList = new ArrayList<SupportedOrganization>();
	    }
	    return this.supportedOrganizationsList;
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
	    	
	    	if (name.equals("cause")) {
				SupportedOrganizationImpl orgImpl = new SupportedOrganizationImpl();
				orgImpl.init(parser);
				getSupportedOrganizationsList().add(orgImpl);
	        } else {
	            // Consume something we don't understand.
	        	LOG.warning("Found tag that we don't recognize: " + name);
	        	XppUtils.skipSubTree(parser);
	        }
	    }
	}
	
	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "supported-organizations");
		XppUtils.setAttributeValueToNode(element, "total", getTotal());
		for (SupportedOrganization org : getSupportedOrganizationsList()) {
			((SupportedOrganizationImpl) org).toXml(serializer);
		}
		element.endTag(null, "supported-organizations");
	}
}
