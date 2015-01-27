package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.google.code.linkedinapi.schema.CompanyStatistics;
import com.google.code.linkedinapi.schema.FollowStatistics;
import com.google.code.linkedinapi.schema.StatusUpdateStatistics;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "statusUpdateStatistics",
    "followStatistics"
})
@XmlRootElement(name = "company-statistics")

public class CompanyStatisticsImpl implements Serializable, CompanyStatistics {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "status-update-statistics", required = true, type = StatusUpdateStatisticsImpl.class)
    protected StatusUpdateStatistics statusUpdateStatistics;
	@XmlElement(name = "follow-statistics", required = true, type = FollowStatisticsImpl.class)
    protected FollowStatistics followStatistics;
    

	@Override
	public StatusUpdateStatistics getStatusUpdateStatistics() {
		return statusUpdateStatistics;
	}

	@Override
	public void setStatusUpdateStatistics(StatusUpdateStatistics value) {
		this.statusUpdateStatistics = value;
	}

	@Override
	public FollowStatistics getFollowStatistics() {
		return followStatistics;
	}

	@Override
	public void setFollowStatistics(FollowStatistics value) {
		this.followStatistics = value;
	}

}
