/* Copyright 2014 */
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.HonorAward;
import com.google.code.linkedinapi.schema.HonorsAwards;
import com.google.code.linkedinapi.schema.xpp.HonorAwardImpl;

public class HonorsAwardsImpl extends BaseSchemaEntity implements HonorsAwards{

	private final static long serialVersionUID = 2461660169443089969L;
    protected List<HonorAward> honorsAwardsList;
    protected Long total;
    
	public List<HonorAward> getHonorAwardsList() {
		if (honorsAwardsList == null) {
			honorsAwardsList = new ArrayList<HonorAward>();
        }
		return honorsAwardsList;
	}
	
	public Long getTotal() {
		return total;
	}
	
	public void setTotal(Long value) {
		this.total = value;
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "honors-awards");
		XppUtils.setAttributeValueToNode(element, "total", getTotal());
		for (HonorAward ha : getHonorAwardsList()) {
			((HonorAwardImpl) ha).toXml(serializer);
		}
		serializer.endTag(null, "honors-awards");
		
	}

	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
		 parser.require(XmlPullParser.START_TAG, null, null);
			setTotal(XppUtils.getAttributeValueAsLongFromNode(parser, "total"));

	        while (parser.nextTag() == XmlPullParser.START_TAG) {
	        	String name = parser.getName();
	        	
	        	if (name.equals("honor-award")) {
	        		HonorAwardImpl honorAwardImpl = new HonorAwardImpl();
	    			honorAwardImpl.init(parser);
	    			getHonorAwardsList().add(honorAwardImpl);
	            } else {
	                // Consume something we don't understand.
	            	LOG.warning("Found tag that we don't recognize: " + name);
	            	XppUtils.skipSubTree(parser);
	            }
	        }
		
	}

}
