package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Seniorities;
import com.google.code.linkedinapi.schema.Seniority;
import com.google.code.linkedinapi.schema.xpp.SeniorityImpl;

public class SenioritiesImpl extends BaseSchemaEntity implements Seniorities {
	
	private static final long serialVersionUID = 4345388614456471465L;
    protected List<Seniority> seniorityList;
    protected Long total;

	@Override
	public List<Seniority> getSeniorityList() {
		if(seniorityList == null){
			seniorityList = new ArrayList<Seniority>();
		}
		return seniorityList;
	}

	@Override
	public Long getTotal() {
		return total;
	}

	@Override
	public void setTotal(Long value) {
		this.total = value;
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "seniorities");
		XppUtils.setAttributeValueToNode(element, "total", getTotal());
		for (Seniority seniority : getSeniorityList()) {
			((SeniorityImpl) seniority).toXml(serializer);
		}
		serializer.endTag(null, "seniorities");
		
	}

	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
		parser.require(XmlPullParser.START_TAG, null, null);
		setTotal(XppUtils.getAttributeValueAsLongFromNode(parser, "total"));

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	if (name.equals("seniority")) {
        		SeniorityImpl seniorityImpl = new SeniorityImpl();
        		seniorityImpl.init(parser);
        		getSeniorityList().add(seniorityImpl);
        	}else{
        		// Consume something we don't understand.
            	LOG.warning("Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
        	}
        	
        }
		
	}


}
