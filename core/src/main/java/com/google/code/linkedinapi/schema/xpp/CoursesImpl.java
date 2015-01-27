/* Copyright 2014 */
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Courses;
import com.google.code.linkedinapi.schema.Course;

public class CoursesImpl extends BaseSchemaEntity implements Courses{

	private final static long serialVersionUID = 2461660169443089969L;
    protected List<Course> coursesList;
    protected Long total;
    
	public List<Course> getCoursesList() {
		if (coursesList == null) {
			coursesList = new ArrayList<Course>();
        }
		return coursesList;
	}
	
	public Long getTotal() {
		return total;
	}
	
	public void setTotal(Long value) {
		this.total = value;
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "courses");
		XppUtils.setAttributeValueToNode(element, "total", getTotal());
		for (Course course : getCoursesList()) {
			((CourseImpl) course).toXml(serializer);
		}
		serializer.endTag(null, "courses");
		
	}

	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
		 parser.require(XmlPullParser.START_TAG, null, null);
			setTotal(XppUtils.getAttributeValueAsLongFromNode(parser, "total"));

	        while (parser.nextTag() == XmlPullParser.START_TAG) {
	        	String name = parser.getName();
	        	
	        	if (name.equals("course")) {
	        		CourseImpl courseImpl = new CourseImpl();
	        		courseImpl.init(parser);
	    			getCoursesList().add(courseImpl);
	            } else {
	                // Consume something we don't understand.
	            	LOG.warning("Found tag that we don't recognize: " + name);
	            	XppUtils.skipSubTree(parser);
	            }
	        }
		
	}

}
