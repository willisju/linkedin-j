package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Opportunities;

public class OpportunitiesImpl extends BaseSchemaEntity implements Opportunities {

	private final static long serialVersionUID = 2461660169443089969L;
	protected Boolean proBono;
	protected Boolean boardMember;
	
	public Boolean isProBono() {
		return proBono;
	}

	public void setIsProBono(Boolean value) {
		this.proBono = value;
		
	}

	public Boolean isBoardMember() {
		return boardMember;
	}

	public void setIsBoardMember(Boolean value) {
		this.boardMember = value;
	}
	
	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "opportunities");
			XppUtils.setAttributeValueToNode(element, "pro-bono", isProBono());
			XppUtils.setAttributeValueToNode(element, "board-member", isBoardMember());
		serializer.endTag(null, "opportunities");
		
	}

	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
		 parser.require(XmlPullParser.START_TAG, null, null);
		 while (parser.nextTag() == XmlPullParser.START_TAG) {
	        	String name = parser.getName();
			if (name.equals("board-member")) {
				setIsBoardMember(Boolean.parseBoolean(XppUtils.getElementValueFromNode(parser)));
        	} else if (name.equals("pro-bono")) {
        		setIsProBono(Boolean.parseBoolean(XppUtils.getElementValueFromNode(parser)));
            } else {
                // Consume something we don't understand.
            	LOG.warning("Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
            }
		 }
		
	}
	
}
