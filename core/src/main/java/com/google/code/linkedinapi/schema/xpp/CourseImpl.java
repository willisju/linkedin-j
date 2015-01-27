/* Copyright 2014 */
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Course;

public class CourseImpl extends BaseSchemaEntity implements Course {
	
	private final static long serialVersionUID = 2461660169443089969L;
    protected String id;
    protected String name;
    protected String number;

    public String getId() {
		return id;
	}

	public void setId(String value) {
		this.id = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String value) {
		this.name = value;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String value) {
		this.number = value;
	}
	
	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "course");
		XppUtils.setElementValueToNode(element, "id", getId());
		XppUtils.setElementValueToNode(element, "name", getName());
		XppUtils.setElementValueToNode(element, "number", getNumber());
		element.endTag(null, "course");
	}

	@Override
	public void init(XmlPullParser parser) throws IOException,XmlPullParserException {
		parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("id")) {
        		setId(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("name")) {
        		setName(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("number")) {
        		setNumber(XppUtils.getElementValueFromNode(parser));
            } else {
                // Consume something we don't understand.
            	LOG.warning("Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
            }
        }
		
	}

	

}
