/*
 * Copyright 2010-2011 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */

package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.google.code.linkedinapi.schema.Group;
import com.google.code.linkedinapi.schema.MemberGroup;
import com.google.code.linkedinapi.schema.MembershipState;
import com.google.code.linkedinapi.schema.SiteGroupRequest;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "group",
    "membershipState",
    "siteGroupRequest"
})
@XmlRootElement(name = "group-membership")
public class MemberGroupImpl
    implements Serializable, MemberGroup
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(type = GroupImpl.class)
    protected GroupImpl group;
    @XmlElement(name = "membership-state",  type = MembershipStateImpl.class)
    protected MembershipStateImpl membershipState;
    @XmlElement(name = "site-group-request",  type = SiteGroupRequestImpl.class)
    protected SiteGroupRequestImpl siteGroupRequest;


    public Group getGroup() {
        return group;
    }

    public void setGroup(Group value) {
        this.group = ((GroupImpl) value);
    }
    
    public SiteGroupRequest getSiteGroupRequest() {
        return siteGroupRequest;
    }

    public void setSiteGroupRequest(SiteGroupRequest value) {
        this.siteGroupRequest = ((SiteGroupRequestImpl) value);
    }

	public MembershipState getMembershipState() {
		return membershipState;
	}

	public void setMembershipState(MembershipState value) {
		this.membershipState = ((MembershipStateImpl) membershipState);
		
	}

}
