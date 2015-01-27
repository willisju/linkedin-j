/* Copyright 2014 */
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.BoundAccount;
import com.google.code.linkedinapi.schema.BoundAccounts;
import com.google.code.linkedinapi.schema.xpp.BoundAccountImpl;

public class BoundAccountsImpl extends BaseSchemaEntity implements BoundAccounts {
	
	private final static long serialVersionUID = 2461660169443089969L;
    protected List<BoundAccount> boundAccountsList;
    protected Long total;
    
    public List<BoundAccount> getBoundAccountsList() {
		if (boundAccountsList == null) {
			boundAccountsList = new ArrayList<BoundAccount>();
        }
        return this.boundAccountsList;
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
	    	
	    	if (name.equals("bound-account")) {
				BoundAccountImpl bAcctImpl = new BoundAccountImpl();
				bAcctImpl.init(parser);
				getBoundAccountsList().add(bAcctImpl);
	        } else {
	            // Consume something we don't understand.
	        	LOG.warning("Found tag that we don't recognize: " + name);
	        	XppUtils.skipSubTree(parser);
	        }
	    }
	}
	
	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "bound-accounts");
		XppUtils.setAttributeValueToNode(element, "total", getTotal());
		for (BoundAccount acctType : getBoundAccountsList()) {
			((BoundAccountImpl) acctType).toXml(serializer);
		}
		element.endTag(null, "bound-accounts");
	}

}
