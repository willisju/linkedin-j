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

import com.google.code.linkedinapi.schema.EmailDigestFrequency;
import com.google.code.linkedinapi.schema.Group;
import com.google.code.linkedinapi.schema.GroupMembership;
import com.google.code.linkedinapi.schema.MembershipState;
import com.google.code.linkedinapi.schema.Person;

public class GroupMembershipImpl
extends BaseSchemaEntity    implements GroupMembership
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected GroupImpl group;
    protected PersonImpl person;
    protected MembershipStateImpl membershipState;
    protected String contactEmail;
    protected boolean showGroupLogoInProfile;
    protected boolean allowMessagesFromMembers;
    protected EmailDigestFrequencyImpl emailDigestFrequency;
    protected boolean emailAnnouncementsFromManagers;
    protected boolean emailForEveryNewPost;
    protected Long key;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group value) {
        this.group = ((GroupImpl) value);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person value) {
        this.person = ((PersonImpl) value);
    }

    public MembershipState getMembershipState() {
        return membershipState;
    }

    public void setMembershipState(MembershipState value) {
        this.membershipState = ((MembershipStateImpl) value);
    }
    
    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String value) {
        this.contactEmail = value;
    }

    public boolean isShowGroupLogoInProfile() {
        return showGroupLogoInProfile;
    }

    public void setShowGroupLogoInProfile(boolean value) {
        this.showGroupLogoInProfile = value;
    }

    public boolean isAllowMessagesFromMembers() {
        return allowMessagesFromMembers;
    }

    public void setAllowMessagesFromMembers(boolean value) {
        this.allowMessagesFromMembers = value;
    }

    public EmailDigestFrequency getEmailDigestFrequency() {
        return emailDigestFrequency;
    }

    public void setEmailDigestFrequency(EmailDigestFrequency value) {
        this.emailDigestFrequency = ((EmailDigestFrequencyImpl) value);
    }

    public boolean isEmailAnnouncementsFromManagers() {
        return emailAnnouncementsFromManagers;
    }

    public void setEmailAnnouncementsFromManagers(boolean value) {
        this.emailAnnouncementsFromManagers = value;
    }

    public boolean isEmailForEveryNewPost() {
        return emailForEveryNewPost;
    }

    public void setEmailForEveryNewPost(boolean value) {
        this.emailForEveryNewPost = value;
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long value) {
        this.key = value;
    }

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
        setKey(XppUtils.getAttributeValueAsLongFromNode(parser, "key"));
        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();
            if (name.equals("group")) {
                GroupImpl node = new GroupImpl();
                node.init(parser);
                setGroup(node);
            } else if (name.equals("person")) {
                PersonImpl node = new PersonImpl();
                node.init(parser);
                setPerson(node);
            } else if (name.equals("membership-state")) {
                MembershipStateImpl node = new MembershipStateImpl();
                node.init(parser);
                setMembershipState(node);
            } else if (name.equals("contact-email")) {
                setContactEmail(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("show-group-logo-in-profile")) {
                setShowGroupLogoInProfile(Boolean.parseBoolean(XppUtils.getElementValueFromNode(parser)));
            } else if (name.equals("allow-messages-from-members")) {
                setAllowMessagesFromMembers(Boolean.parseBoolean(XppUtils.getElementValueFromNode(parser)));
            } else if (name.equals("email-digest-frequency")) {
                EmailDigestFrequencyImpl node = new EmailDigestFrequencyImpl();
                node.init(parser);
                setEmailDigestFrequency(node);
            } else if (name.equals("email-announcements-from-managers")) {
                setEmailAnnouncementsFromManagers(Boolean.parseBoolean(XppUtils.getElementValueFromNode(parser)));
            } else if (name.equals("email-for-every-new-post")) {
                setEmailForEveryNewPost(Boolean.parseBoolean(XppUtils.getElementValueFromNode(parser)));
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
        XppUtils.setAttributeValueToNode(element, "key", getKey());
        if (getGroup() != null) {
            ((GroupImpl) getGroup()).toXml(serializer);
        }
        if (getPerson() != null) {
            ((PersonImpl) getPerson()).toXml(serializer);
        }
        if (getMembershipState() != null) {
            ((MembershipStateImpl) getMembershipState()).toXml(serializer);
        }
        XppUtils.setElementValueToNode(element, "contact-email", getContactEmail());
        XppUtils.setElementValueToNode(element, "show-group-logo-in-profile", String.valueOf(isShowGroupLogoInProfile()));
        XppUtils.setElementValueToNode(element, "allow-messages-from-members", String.valueOf(isAllowMessagesFromMembers()));
        if (getEmailDigestFrequency() != null) {
            ((EmailDigestFrequencyImpl) getEmailDigestFrequency()).toXml(serializer);
        }
        XppUtils.setElementValueToNode(element, "email-announcements-from-managers", String.valueOf(isEmailAnnouncementsFromManagers()));
        XppUtils.setElementValueToNode(element, "email-for-every-new-post", String.valueOf(isEmailForEveryNewPost()));
        
        
        serializer.endTag(null, "group-membership");
    }
}
