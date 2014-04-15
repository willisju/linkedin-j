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
import com.google.code.linkedinapi.schema.Project;
import com.google.code.linkedinapi.schema.Projects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "projectsList"
})
@XmlRootElement(name = "projects")

public class ProjectsImpl implements Serializable, Projects{
	
	private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "project", required = true, type = ProjectImpl.class)
    protected List<Project> projectsList;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
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
}
