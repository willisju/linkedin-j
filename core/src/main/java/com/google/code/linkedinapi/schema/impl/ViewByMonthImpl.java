package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.google.code.linkedinapi.schema.Date;
import com.google.code.linkedinapi.schema.ViewByMonth;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	"date",
    "clicks",
    "likes",
    "comments",
    "shares",
    "impressions",
    "engagement"
})
@XmlRootElement(name = "view-by-month")

public class ViewByMonthImpl implements Serializable, ViewByMonth {
	
	private static final long serialVersionUID = 4345388614456471465L;
	@XmlElement(required = true, type = DateImpl.class)
    protected DateImpl date;
	@XmlElement(required = true)
    protected Long clicks;
	@XmlElement(required = true)
    protected Long likes;
	@XmlElement(required = true)
    protected Long comments;
	@XmlElement(required = true)
	protected Long shares;
	@XmlElement(required = true)
    protected Long impressions;
	@XmlElement(required = true)
    protected String engagement;

	@Override
	public Date getDate() {
		return date;
	}

	@Override
	public void setDate(Date value) {
		this.date = ((DateImpl) value);
	}

	@Override
	public Long getNumClicks() {
		return clicks;
	}

	@Override
	public void setNumClicks(Long value) {
		this.clicks = value;
	}

	@Override
	public Long getNumLikes() {
		return likes;
	}

	@Override
	public void setNumLikes(Long value) {
		this.likes = value;
	}

	@Override
	public Long getNumComments() {
		return comments;
	}

	@Override
	public void setNumComments(Long value) {
		this.comments = value;
	}

	@Override
	public Long getNumShares() {
		return shares;
	}

	@Override
	public void setNumShares(Long value) {
		this.shares = value;
	}

	@Override
	public Long getNumImpressions() {
		return impressions;
	}

	@Override
	public void setNumImpressions(Long value) {
		this.impressions = value;
	}

	@Override
	public String getEngagement() {
		return engagement;
	}

	@Override
	public void setEngagement(String value) {
		this.engagement = value;
	}

}
