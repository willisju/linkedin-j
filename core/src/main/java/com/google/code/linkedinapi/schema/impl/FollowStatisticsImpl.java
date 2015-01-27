package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.google.code.linkedinapi.schema.FollowStatistics;
import com.google.code.linkedinapi.schema.Seniorities;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	"count",
	"employeeCount",
	"nonEmployeeCount",
    "seniorities"
})
@XmlRootElement(name = "follow-statistics")

public class FollowStatisticsImpl implements Serializable, FollowStatistics {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4056427594603889947L;
	@XmlElement(required = true, type = SenioritiesImpl.class)
    protected SenioritiesImpl seniorities;
	@XmlElement(required = true)
	protected Long count;
	@XmlElement(name = "employee-count", required = true)
    protected Long employeeCount;
    @XmlElement(name = "non-employee-count", required = true)
    protected Long nonEmployeeCount;

	@Override
	public Long getCount() {
		return count;
	}

	@Override
	public void setCount(Long value) {
		this.count = value;
	}

	@Override
	public Long getEmployeeCount() {
		return employeeCount;
	}

	@Override
	public void setEmployeeCount(Long value) {
		this.employeeCount = value;
	}

	@Override
	public Long getNonEmployeeCount() {
		return nonEmployeeCount;
	}

	@Override
	public void setNonEmployeeCount(Long value) {
		this.nonEmployeeCount = value;
	}

	@Override
	public Seniorities getSeniorities() {
		return seniorities;
	}

	@Override
	public void setSenorities(Seniorities value) {
		this.seniorities = ((SenioritiesImpl) value);
	}

}
