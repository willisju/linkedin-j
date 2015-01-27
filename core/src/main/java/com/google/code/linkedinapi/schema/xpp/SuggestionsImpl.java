/* Copyright 2014 */
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Suggestions;
import com.google.code.linkedinapi.schema.ToFollow;
import com.google.code.linkedinapi.schema.xpp.ToFollowImpl;

public class SuggestionsImpl extends BaseSchemaEntity implements Suggestions {
	
	private final static long serialVersionUID = 2461660169443089969L;
    protected ToFollow toFollow;

	public ToFollow getToFollow() {
		return toFollow;
	}
	public void setToFollow(ToFollow value) {
		this.toFollow = ((ToFollowImpl) value);
	}
	
	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "suggestions");
		    if(getToFollow() != null) {
	            ((ToFollowImpl) getToFollow()).toXml(serializer);
	        }
	       
		element.endTag(null, "suggestions");
	}

	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
		 parser.require(XmlPullParser.START_TAG, null, null);
	        while (parser.nextTag() == XmlPullParser.START_TAG) {
	        	String name = parser.getName();
	        	
	        	if (name.equals("to-follow")) {
	        		ToFollowImpl tofollowImpl = new ToFollowImpl();
	        		tofollowImpl.init(parser);
	    			setToFollow(tofollowImpl);
	            } else {
	                // Consume something we don't understand.
	            	LOG.warning("Found tag that we don't recognize: " + name);
	            	XppUtils.skipSubTree(parser);
	            }
	        }
		
	}
}
