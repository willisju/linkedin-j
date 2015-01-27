/* Copyright 2014 */
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Project;

public class ProjectImpl extends BaseSchemaEntity implements Project {

	private final static long serialVersionUID = 2461660169443089969L;
    protected String id;
    protected String name;
    protected String description;
    protected String url;

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
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String value) {
		this.url = value;
	}
	
	

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "project");
		XppUtils.setElementValueToNode(element, "id", getId());
		XppUtils.setElementValueToNode(element, "name", getName());
		XppUtils.setElementValueToNode(element, "description", getDescription());
		XppUtils.setElementValueToNode(element, "url", getUrl());
		serializer.endTag(null, "project");
		
	}

	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
		parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("id")) {
        		setId(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("name")) {
        		setName(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("description")) {
        		setDescription(XppUtils.getElementValueFromNode(parser));
        	} else if (name.equals("url")) {
        		setUrl(XppUtils.getElementValueFromNode(parser));
        	} else {
                // Consume something we don't understand.
            	LOG.warning("Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
            }
        }
		
	}
}
