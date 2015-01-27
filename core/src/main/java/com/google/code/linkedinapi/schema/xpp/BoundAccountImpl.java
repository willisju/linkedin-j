/* Copyright 2014 */
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.BoundAccount;

public class BoundAccountImpl extends BaseSchemaEntity implements BoundAccount {
	
	private final static long serialVersionUID = 2461660169443089969L;
    protected String id;
    protected String accountType;
    protected String bindingStatus;
    protected Boolean isPrimary;
    protected String providerAccountId;
    protected String providerAccountName;

	public String getId() {
		return id;
	}

	public void setId(String value) {
		this.id = value;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String value) {
		this.accountType = value;
	}

	public String getBindingStatus() {
		return bindingStatus;
	}

	public void setBindingStatus(String value) {
		this.bindingStatus = value;
	}

	public Boolean getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(Boolean value) {
		this.isPrimary = value;
	}

	public String getProviderAccountId() {
		return providerAccountId;
	}

	public void setProviderAccountId(String value) {
		this.providerAccountId = value;
	}

	public String getProviderAccountName() {
		return providerAccountName;
	}

	public void setProviderAccountName(String value) {
		this.providerAccountName = value;
	}

	@Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
			parser.require(XmlPullParser.START_TAG, null, null);
			while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();
	            if (name.equals("id")) {
	                setId(XppUtils.getElementValueFromNode(parser));
	            } else if (name.equals("account-type")) {
	                setAccountType(XppUtils.getElementValueFromNode(parser));
	            } else if (name.equals("binding-status")) {
	                setBindingStatus(XppUtils.getElementValueFromNode(parser));
	            } else if (name.equals("is-primary")) {
	            	setIsPrimary(Boolean.parseBoolean(XppUtils.getElementValueFromNode(parser)));
	            } else if (name.equals("provider-account-id")) {
	            	setProviderAccountId(XppUtils.getElementValueFromNode(parser));
	            } else if (name.equals("provider-account-name")) {
	            	setProviderAccountName(XppUtils.getElementValueFromNode(parser)); 
	            } else {
	                // Consume something we don't understand.
	                LOG.warning("Found tag that we don't recognize: " + name);
	                XppUtils.skipSubTree(parser);
	            }
        	}
	    }
	    @Override
	    public void toXml(XmlSerializer serializer) throws IOException {
	        XmlSerializer element = serializer.startTag(null, "bound-account");
	        XppUtils.setElementValueToNode(element, "id", getId());
	        XppUtils.setElementValueToNode(element, "account-type", getAccountType());
	        XppUtils.setElementValueToNode(element, "binding-status", getBindingStatus());
	        XppUtils.setElementValueToNode(element, "is-primary", String.valueOf(getIsPrimary()));
	        XppUtils.setElementValueToNode(element, "provider-account-id", getProviderAccountId());
	        XppUtils.setElementValueToNode(element, "provider-account-name", getProviderAccountName());
	        serializer.endTag(null, "bound-account");
	    }
	
}
