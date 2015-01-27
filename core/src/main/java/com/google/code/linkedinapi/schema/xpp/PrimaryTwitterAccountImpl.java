/* Copyright 2014 */
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.PrimaryTwitterAccount;

public class PrimaryTwitterAccountImpl extends BaseSchemaEntity
implements PrimaryTwitterAccount{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -2353467657168192272L;
	protected String providerAccountId;
    protected String providerAccountName;

	public String getId() {
		return providerAccountId;
	}

	public void setId(String value) {
		this.providerAccountId = value;
	}

	public String getName() {
		return providerAccountName;
	}

	public void setName(String value) {
		this.providerAccountName = value;
	}


	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "primary-twitter-account");
        XppUtils.setElementValueToNode(element, "provider-account-id", this.getId());
        XppUtils.setElementValueToNode(element, "provider-account-name", this.getName());
        serializer.endTag(null, "primary-twitter-account");
	}

	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
		parser.require(XmlPullParser.START_TAG, null, null);
        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();
            if (name.equals("provider-account-id")) {
                this.setId(XppUtils.getElementValueFromNode(parser));
            } else if(name.equals("provider-account-name")){
            	 this.setName(XppUtils.getElementValueFromNode(parser));
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
            
        }
		
	}

}
