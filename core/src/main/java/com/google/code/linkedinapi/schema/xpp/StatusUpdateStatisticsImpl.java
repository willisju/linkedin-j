package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.StatusUpdateStatistics;
import com.google.code.linkedinapi.schema.ViewsByMonth;
import com.google.code.linkedinapi.schema.xpp.ViewsByMonthImpl;

public class StatusUpdateStatisticsImpl extends BaseSchemaEntity implements StatusUpdateStatistics{
	
	private static final long serialVersionUID = -7385216946344816795L;
    protected ViewsByMonthImpl viewsByMonth;

	public ViewsByMonth getViewsByMonth() {
		return viewsByMonth;
	}
	
	public void setViewsByMonth(ViewsByMonth value) {
		this.viewsByMonth = ((ViewsByMonthImpl) value);
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "status-update-statistics");
		if (getViewsByMonth() != null) {
            ((ViewsByMonthImpl) getViewsByMonth()).toXml(serializer);
        }
		element.endTag(null, "status-update-statistics");
		
	}

	@Override
	public void init(XmlPullParser parser) throws IOException,XmlPullParserException {
		parser.require(XmlPullParser.START_TAG, null, null);
		while (parser.nextTag() == XmlPullParser.START_TAG) {
			String name = parser.getName();
			if(name.equals("views-by-month")){
				ViewsByMonthImpl viewsByMonthImpl = new ViewsByMonthImpl();
				viewsByMonthImpl.init(parser);
				setViewsByMonth(viewsByMonthImpl);
			}else{
				// Consume something we don't understand.
	        	LOG.warning("Found tag that we don't recognize: " + name);
	        	XppUtils.skipSubTree(parser);
			}
		}
	}

}
