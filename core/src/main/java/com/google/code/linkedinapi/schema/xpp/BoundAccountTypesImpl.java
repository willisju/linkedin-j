/* Copyright 2014 */
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.BoundAccountType;
import com.google.code.linkedinapi.schema.BoundAccountTypes;
import com.google.code.linkedinapi.schema.xpp.BoundAccountTypeImpl;

public class BoundAccountTypesImpl extends BaseSchemaEntity implements BoundAccountTypes{
	
	private final static long serialVersionUID = 2461660169443089969L;
    protected List<BoundAccountType> boundAccountTypesList;
    protected Long total;
	
	public List<BoundAccountType> getBoundAccountTypesList() {
		if (boundAccountTypesList == null) {
			boundAccountTypesList = new ArrayList<BoundAccountType>();
        }
        return this.boundAccountTypesList;
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
	    	
	    	if (name.equals("bound-account-type")) {
				BoundAccountTypeImpl bAcctTypeImpl = new BoundAccountTypeImpl();
				bAcctTypeImpl.init(parser);
				getBoundAccountTypesList().add(bAcctTypeImpl);
	        } else {
	            // Consume something we don't understand.
	        	LOG.warning("Found tag that we don't recognize: " + name);
	        	XppUtils.skipSubTree(parser);
	        }
	    }
	}
	
	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "bound-account-types");
		XppUtils.setAttributeValueToNode(element, "total", getTotal());
		for (BoundAccountType acctType : getBoundAccountTypesList()) {
			((BoundAccountTypeImpl) acctType).toXml(serializer);
		}
		element.endTag(null, "bound-account-types");
	}
}
