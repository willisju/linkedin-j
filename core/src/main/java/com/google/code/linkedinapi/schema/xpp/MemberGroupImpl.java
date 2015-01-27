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

package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Group;
import com.google.code.linkedinapi.schema.MemberGroup;
import com.google.code.linkedinapi.schema.MembershipState;
import com.google.code.linkedinapi.schema.SiteGroupRequest;

public class MemberGroupImpl
	extends BaseSchemaEntity
    implements MemberGroup
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected GroupImpl group;
    protected SiteGroupRequestImpl siteGroupRequest;
    protected MembershipStateImpl membershipState;

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
    
	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("group")) {
        		GroupImpl group = new GroupImpl();
    			group.init(parser);
    			setGroup(group);	
        	} else if (name.equals("site-group-request")) {
    			SiteGroupRequestImpl siteGroup = new SiteGroupRequestImpl();
    			siteGroup.init(parser);
    			setSiteGroupRequest(siteGroup);
            } else if (name.equals("membership-state")) {
            	MembershipStateImpl membershipState = new MembershipStateImpl();
            	membershipState.init(parser);
    			setMembershipState(membershipState);
            } else {
                // Consume something we don't understand.
            	LOG.warning("Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
            }
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "group-membership");
		if (getGroup() != null) {
			((GroupImpl) getGroup()).toXml(serializer);
		}
		if (getSiteGroupRequest() != null) {
			((SiteGroupRequestImpl) getSiteGroupRequest()).toXml(serializer);
		}
		if (getSiteGroupRequest() != null) {
			((SiteGroupRequestImpl) getSiteGroupRequest()).toXml(serializer);
		}
		if (getMembershipState() != null) {
			((MembershipStateImpl) getMembershipState()).toXml(serializer);
		}
		serializer.endTag(null, "group-membership");
	}
}
