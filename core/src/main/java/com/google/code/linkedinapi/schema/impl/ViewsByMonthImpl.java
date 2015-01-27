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
import com.google.code.linkedinapi.schema.ViewByMonth;
import com.google.code.linkedinapi.schema.ViewsByMonth;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "viewByMonthList"
})
@XmlRootElement(name = "views-by-month")

public class ViewsByMonthImpl implements Serializable, ViewsByMonth{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5292550643831627395L;
	@XmlElement(name = "view-by-month", required = true, type = ViewByMonthImpl.class)
    protected List<ViewByMonth> viewByMonthList;
	@XmlAttribute(required = true)
    @XmlJavaTypeAdapter(Adapter1 .class)
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

}
