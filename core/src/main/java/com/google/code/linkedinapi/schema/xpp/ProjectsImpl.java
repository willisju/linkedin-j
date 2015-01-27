/* Copyright 2014 */
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Project;
import com.google.code.linkedinapi.schema.Projects;

public class ProjectsImpl extends BaseSchemaEntity implements Projects{

	private final static long serialVersionUID = 2461660169443089969L;
    protected List<Project> projectsList;
    protected Long total;
    
	public List<Project> getProjectsList() {
		if (projectsList == null) {
			projectsList = new ArrayList<Project>();
        }
		return projectsList;
	}
	
	public Long getTotal() {
		return total;
	}
	
	public void setTotal(Long value) {
		this.total = value;
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "projects");
		XppUtils.setAttributeValueToNode(element, "total", getTotal());
		for (Project proj : getProjectsList()) {
			((ProjectImpl) proj).toXml(serializer);
		}
		serializer.endTag(null, "projects");
		
	}

	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
		 parser.require(XmlPullParser.START_TAG, null, null);
			setTotal(XppUtils.getAttributeValueAsLongFromNode(parser, "total"));

	        while (parser.nextTag() == XmlPullParser.START_TAG) {
	        	String name = parser.getName();
	        	
	        	if (name.equals("project")) {
	        		ProjectImpl projectImpl = new ProjectImpl();
	        		projectImpl.init(parser);
	    			getProjectsList().add(projectImpl);
	            } else {
	                // Consume something we don't understand.
	            	LOG.warning("Found tag that we don't recognize: " + name);
	            	XppUtils.skipSubTree(parser);
	            }
	        }
		
	}

}
