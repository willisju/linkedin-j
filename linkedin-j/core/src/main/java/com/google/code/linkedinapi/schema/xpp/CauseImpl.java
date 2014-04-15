/* Copyright 2014 */
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Cause;

public class CauseImpl extends BaseSchemaEntity implements Cause{

	private final static long serialVersionUID = 2461660169443089969L;
	protected String name;
	
	
	public String getName() {
	    return name;
	}
	
	public void setName(String value) {
	    this.name = value;
	}
	
	
	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
	    parser.require(XmlPullParser.START_TAG, null, null);
	
	    while (parser.nextTag() == XmlPullParser.START_TAG) {
	    	String name = parser.getName();
	    	if (name.equals("name")) {
	    		setName(XppUtils.getElementValueFromNode(parser));
	        } else {
	            // Consume something we don't understand.
	        	LOG.warning("Found tag that we don't recognize: " + name);
	        	XppUtils.skipSubTree(parser);
	        }
	    }
	}
	
	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "cause");
		XppUtils.setElementValueToNode(element, "name", getName());
		element.endTag(null, "cause");
	}

}
