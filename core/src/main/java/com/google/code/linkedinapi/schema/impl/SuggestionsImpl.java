package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.google.code.linkedinapi.schema.Suggestions;
import com.google.code.linkedinapi.schema.ToFollow;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "toFollow"
})
@XmlRootElement(name = "suggestions")


public class SuggestionsImpl implements Serializable, Suggestions {
	
	private final static long serialVersionUID = 2461660169443089969L;
	@XmlElement(name = "to-follow", required = true, type = ToFollowImpl.class)
    protected ToFollow toFollow;

	public ToFollow getToFollow() {
		return toFollow;
	}
	public void setToFollow(ToFollow value) {
		this.toFollow = ((ToFollowImpl) value);
	}


}
