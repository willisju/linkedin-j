package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.google.code.linkedinapi.schema.Seniority;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "entryKey",
    "entryValue"
})
@XmlRootElement(name = "seniority")

public class SeniorityImpl implements Serializable, Seniority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4291722986382706612L;
	@XmlElement(name = "entry-key", required = true)
	protected String entryKey; 
	@XmlElement(name = "entry-value", required = true)
	protected String entryValue; 

	@Override
	public String getEntryKey() {
		return entryKey;
	}

	@Override
	public void setEntryKey(String value) {
		this.entryKey = value;
	}

	@Override
	public String getEntryValue() {
		return entryValue;
	}

	@Override
	public void setEntryValue(String value) {
		this.entryValue = value;
	}

}
