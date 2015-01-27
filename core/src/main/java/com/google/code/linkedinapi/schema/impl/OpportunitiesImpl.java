package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.google.code.linkedinapi.schema.Opportunities;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "proBono",
    "boardMember"
})
@XmlRootElement(name = "opportunities")

public class OpportunitiesImpl implements Serializable, Opportunities{

	private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "pro-bono")
	protected Boolean proBono;
    @XmlElement(name = "board-member")
    protected Boolean boardMember;
    
	public Boolean isProBono() {
		return proBono;
	}

	public void setIsProBono(Boolean value) {
		this.proBono = value;
		
	}

	public Boolean isBoardMember() {
		return boardMember;
	}

	public void setIsBoardMember(Boolean value) {
		this.boardMember = value;
	}

}
