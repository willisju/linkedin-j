package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Seniority;

public class SeniorityImpl extends BaseSchemaEntity implements Seniority{
	
	private static final long serialVersionUID = 4291722986382706612L;
	protected String entryKey; 
	protected String entryValue; 

	@Override
	public String getEntryKey() {
		return entryKey;
	}

	@Override
	public void setEntryKey(String value) {
		this.entryKey = value;
	}

	@Override
	public String getEntryValue() {
		return entryValue;
	}

	@Override
	public void setEntryValue(String value) {
		this.entryValue = value;
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "seniority");
		XppUtils.setElementValueToNode(element, "entry-key", getEntryKey());
		XppUtils.setElementValueToNode(element, "entry-value", getEntryValue());
		element.endTag(null, "seniority");
	}

	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
		 parser.require(XmlPullParser.START_TAG, null, null);

	        while (parser.nextTag() == XmlPullParser.START_TAG) {
	        	String name = parser.getName();
	        	if (name.equals("entry-key")) {
	        		setEntryKey(XppUtils.getElementValueFromNode(parser));
	        	}else if(name.equals("entry-value")){
	        		setEntryValue(XppUtils.getElementValueFromNode(parser));
	        	}else{
	        		 // Consume something we don't understand.
	            	LOG.warning("Found tag that we don't recognize: " + name);
	            	XppUtils.skipSubTree(parser);
	        	}
	        }
	        
		
	}


}
