package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.google.code.linkedinapi.schema.StatusUpdateStatistics;
import com.google.code.linkedinapi.schema.ViewsByMonth;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "viewsByMonth"
})
@XmlRootElement(name = "status-update-statistics")

public class StatusUpdateStatisticsImpl implements Serializable, StatusUpdateStatistics{

	private static final long serialVersionUID = -7385216946344816795L;
	@XmlElement(name = "views-by-month", required = true, type = ViewsByMonthImpl.class)
    protected ViewsByMonthImpl viewsByMonth;

	public ViewsByMonth getViewsByMonth() {
		return viewsByMonth;
	}
	
	public void setViewsByMonth(ViewsByMonth value) {
		this.viewsByMonth = ((ViewsByMonthImpl) value);
	}


}
