/* Copyright 2014 */
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.BoundAccountType;
import com.google.code.linkedinapi.schema.BoundAccounts;
import com.google.code.linkedinapi.schema.impl.ViewsByMonthImpl;
import com.google.code.linkedinapi.schema.xpp.BoundAccountsImpl;

public class BoundAccountTypeImpl extends BaseSchemaEntity implements BoundAccountType{
	
	 private final static long serialVersionUID = 2461660169443089969L;
	 protected  BoundAccountsImpl boundAccounts;	
	 protected Long numAccounts;
	 

	public Long getNumAccounts() {
		return numAccounts;
	}

	public void setNumAccounts(Long value) {
		this.numAccounts = value;
	}

	public BoundAccounts getBoundAccounts() {
		return boundAccounts;
	}

	public void setBoundAccounts(BoundAccounts value) {
		this.boundAccounts = ((BoundAccountsImpl) value);
	}
	
	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
	    parser.require(XmlPullParser.START_TAG, null, null);
	
	    while (parser.nextTag() == XmlPullParser.START_TAG) {
	    	String name = parser.getName();
	    	if (name.equals("num-accounts")) {
	    		setNumAccounts(XppUtils.getElementValueAsLongFromNode(parser));
	        } else if(name.equals("bound-accounts")){
	        	BoundAccountsImpl bndAcctsImpl = new BoundAccountsImpl();
	        	bndAcctsImpl.init(parser);
    			setBoundAccounts(bndAcctsImpl);
	        } else {
	            // Consume something we don't understand.
	        	LOG.warning("Found tag that we don't recognize: " + name);
	        	XppUtils.skipSubTree(parser);
	        }
	    }
	}
	
	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "bound-account-type");
		XppUtils.setElementValueToNode(element, "num-accounts", getNumAccounts());
		if (getBoundAccounts() != null) {
            ((BoundAccountsImpl) getBoundAccounts()).toXml(serializer);
        }
		element.endTag(null, "bound-account-type");
	}
}
