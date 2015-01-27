/* Copyright 2014 */
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Cause;
import com.google.code.linkedinapi.schema.Causes;

public class CausesImpl extends BaseSchemaEntity implements Causes {

	private final static long serialVersionUID = 2461660169443089969L;
	protected List<Cause> causesList;
	protected Long total;
	
	public List<Cause> getCausesList() {
	    if (causesList == null) {
	    	causesList = new ArrayList<Cause>();
	    }
	    return this.causesList;
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
				CauseImpl causeImpl = new CauseImpl();
				causeImpl.init(parser);
				getCausesList().add(causeImpl);
	        } else {
	            // Consume something we don't understand.
	        	LOG.warning("Found tag that we don't recognize: " + name);
	        	XppUtils.skipSubTree(parser);
	        }
	    }
	}
	
	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "causes");
		XppUtils.setAttributeValueToNode(element, "total", getTotal());
		for (Cause cause : getCausesList()) {
			((CauseImpl) cause).toXml(serializer);
		}
		element.endTag(null, "causes");
	}
}
