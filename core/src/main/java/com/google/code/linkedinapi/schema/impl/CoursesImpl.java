/* Copyright 2014   */
package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.google.code.linkedinapi.schema.Adapter1;
import com.google.code.linkedinapi.schema.Course;
import com.google.code.linkedinapi.schema.Courses;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "coursesList"
})
@XmlRootElement(name = "courses")

public class CoursesImpl implements Serializable, Courses{
	
	private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "course", required = true, type = CourseImpl.class)
    protected List<Course> coursesList;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
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
}
