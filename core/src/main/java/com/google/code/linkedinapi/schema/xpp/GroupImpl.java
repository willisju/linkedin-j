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

import com.google.code.linkedinapi.schema.CountsByCategory;
import com.google.code.linkedinapi.schema.Group;
import com.google.code.linkedinapi.schema.GroupCategory;
import com.google.code.linkedinapi.schema.Location;
import com.google.code.linkedinapi.schema.Posts;
import com.google.code.linkedinapi.schema.RelationToViewer;
import com.google.code.linkedinapi.schema.xpp.LocationImpl;

public class GroupImpl
extends BaseSchemaEntity    implements Group
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected String id;
    protected String name;
    protected String shortDescription;
    protected String description;
    protected RelationToViewerImpl relationToViewer;
    protected CountsByCategoryImpl countsByCategory;
    protected boolean isOpenToNonMembers;
    protected GroupCategoryImpl category;
    protected String siteGroupUrl;
    protected String contactEmail;
    protected String locale;
    protected boolean allowMemberInvites;
    protected String smallLogoUrl;
    protected String largeLogoUrl;
    protected PostsImpl posts;
    protected String websiteUrl;
    protected Long numMembers;
    protected LocationImpl location;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String value) {
        this.shortDescription = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public RelationToViewer getRelationToViewer() {
        return relationToViewer;
    }

    public void setRelationToViewer(RelationToViewer value) {
        this.relationToViewer = ((RelationToViewerImpl) value);
    }

    public CountsByCategory getCountsByCategory() {
        return countsByCategory;
    }

    public void setCountsByCategory(CountsByCategory value) {
        this.countsByCategory = ((CountsByCategoryImpl) value);
    }

    public boolean isIsOpenToNonMembers() {
        return isOpenToNonMembers;
    }

    public void setIsOpenToNonMembers(boolean value) {
        this.isOpenToNonMembers = value;
    }

    public GroupCategory getCategory() {
        return category;
    }

    public void setCategory(GroupCategory value) {
        this.category = ((GroupCategoryImpl) value);
    }

    public String getSiteGroupUrl() {
        return siteGroupUrl;
    }

    public void setSiteGroupUrl(String value) {
        this.siteGroupUrl = value;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String value) {
        this.contactEmail = value;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String value) {
        this.locale = value;
    }

    public boolean isAllowMemberInvites() {
        return allowMemberInvites;
    }

    public void setAllowMemberInvites(boolean value) {
        this.allowMemberInvites = value;
    }

    public String getSmallLogoUrl() {
        return smallLogoUrl;
    }

    public void setSmallLogoUrl(String value) {
        this.smallLogoUrl = value;
    }

    public String getLargeLogoUrl() {
        return largeLogoUrl;
    }

    public void setLargeLogoUrl(String value) {
        this.largeLogoUrl = value;
    }

    public Posts getPosts() {
        return posts;
    }

    public void setPosts(Posts value) {
        this.posts = ((PostsImpl) value);
    }
    
    public void setWebsiteUrl(String value) {
		this.websiteUrl = value;
	}

	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public void setNumMembers(Long value) {
		this.numMembers = value;
	}

	public Long getNumMembers() {
		return numMembers;
	}

	public void setLocation(Location value) {
		this.location = ((LocationImpl) value);
	}

	public Location getLocation() {
		return location;
	}

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();
            if (name.equals("id")) {
                setId(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("name")) {
                setName(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("short-description")) {
                setShortDescription(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("description")) {
                setDescription(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("relation-to-viewer")) {
                RelationToViewerImpl node = new RelationToViewerImpl();
                node.init(parser);
                setRelationToViewer(node);
            } else if (name.equals("counts-by-category")) {
                CountsByCategoryImpl node = new CountsByCategoryImpl();
                node.init(parser);
                setCountsByCategory(node);
            } else if (name.equals("is-open-to-non-members")) {
                setIsOpenToNonMembers(Boolean.parseBoolean(XppUtils.getElementValueFromNode(parser)));
            } else if (name.equals("category")) {
            	GroupCategoryImpl node = new GroupCategoryImpl();
                node.init(parser);
                setCategory(node);
            } else if (name.equals("site-group-url")) {
                setSiteGroupUrl(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("contact-email")) {
                setContactEmail(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("locale")) {
                setLocale(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("allow-member-invites")) {
                setAllowMemberInvites(Boolean.parseBoolean(XppUtils.getElementValueFromNode(parser)));
            } else if (name.equals("small-logo-url")) {
                setSmallLogoUrl(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("large-logo-url")) {
                setLargeLogoUrl(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("posts")) {
                PostsImpl node = new PostsImpl();
                node.init(parser);
                setPosts(node);
            } else if (name.equals("location")) {
                LocationImpl loc = new LocationImpl();
                loc.init(parser);
                setLocation(loc);
            } else if (name.equals("website-url")) {
                setWebsiteUrl(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("num-members")) {
                setNumMembers(XppUtils.getElementValueAsLongFromNode(parser));
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }
    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "group");
        XppUtils.setElementValueToNode(element, "id", getId());
        XppUtils.setElementValueToNode(element, "name", getName());
        XppUtils.setElementValueToNode(element, "short-description", getShortDescription());
        XppUtils.setElementValueToNode(element, "description", getDescription());
        if (getRelationToViewer() != null) {
            ((RelationToViewerImpl) getRelationToViewer()).toXml(serializer);
        }
        if (getLocation() != null) {
            ((LocationImpl) getLocation()).toXml(serializer);
        }
        if (getCountsByCategory() != null) {
            ((CountsByCategoryImpl) getCountsByCategory()).toXml(serializer);
        }
        XppUtils.setElementValueToNode(element, "is-open-to-non-members", String.valueOf(isIsOpenToNonMembers()));
        if (getCategory() != null) {
            ((GroupCategoryImpl) getCategory()).toXml(serializer);
        }
        XppUtils.setElementValueToNode(element, "site-group-url", getSiteGroupUrl());
        XppUtils.setElementValueToNode(element, "contact-email", getContactEmail());
        XppUtils.setElementValueToNode(element, "locale", getLocale());
        XppUtils.setElementValueToNode(element, "allow-member-invites", String.valueOf(isAllowMemberInvites()));
        XppUtils.setElementValueToNode(element, "small-logo-url", getSmallLogoUrl());
        XppUtils.setElementValueToNode(element, "large-logo-url", getLargeLogoUrl());
        XppUtils.setElementValueToNode(element, "website-url", getWebsiteUrl());
        XppUtils.setElementValueToNode(element, "num-members", getNumMembers());
        if (getPosts() != null) {
            ((PostsImpl) getPosts()).toXml(serializer);
        }
        
        
        serializer.endTag(null, "group");
    }
}
