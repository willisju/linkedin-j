package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.ViewByMonth;
import com.google.code.linkedinapi.schema.ViewsByMonth;
import com.google.code.linkedinapi.schema.xpp.ViewByMonthImpl;

public class ViewsByMonthImpl extends BaseSchemaEntity implements ViewsByMonth {
	
	private static final long serialVersionUID = -5292550643831627395L;
    protected List<ViewByMonth> viewByMonthList;
    protected Long total;

	@Override
	public List<ViewByMonth> getViewByMonthList() {
		if(viewByMonthList == null){
			viewByMonthList = new ArrayList<ViewByMonth>();
		}
		return viewByMonthList;
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
		for (ViewByMonth viewByMonth : getViewByMonthList()) {
			((ViewByMonthImpl) viewByMonth).toXml(serializer);
		}
		serializer.endTag(null, "seniorities");
		
	}

	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
		parser.require(XmlPullParser.START_TAG, null, null);
		setTotal(XppUtils.getAttributeValueAsLongFromNode(parser, "total"));

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	if (name.equals("view-by-month")) {
        		ViewByMonthImpl viewByMonthImpl = new ViewByMonthImpl();
        		viewByMonthImpl.init(parser);
        		getViewByMonthList().add(viewByMonthImpl);
        	}else{
        		// Consume something we don't understand.
            	LOG.warning("Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
        	}
        	
        }
		
	}

}
