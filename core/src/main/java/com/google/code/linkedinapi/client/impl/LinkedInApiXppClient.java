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
package com.google.code.linkedinapi.client.impl;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.client.LinkedInApiClientException;
import com.google.code.linkedinapi.client.constant.ApplicationConstants;
import com.google.code.linkedinapi.client.constant.LinkedInApiUrls.LinkedInApiUrlBuilder;
import com.google.code.linkedinapi.schema.Activity;
import com.google.code.linkedinapi.schema.Comment;
import com.google.code.linkedinapi.schema.Comments;
import com.google.code.linkedinapi.schema.Companies;
import com.google.code.linkedinapi.schema.Company;
import com.google.code.linkedinapi.schema.CompanySearch;
import com.google.code.linkedinapi.schema.Connections;
import com.google.code.linkedinapi.schema.Error;
import com.google.code.linkedinapi.schema.Following;
import com.google.code.linkedinapi.schema.Group;
import com.google.code.linkedinapi.schema.GroupMembership;
import com.google.code.linkedinapi.schema.GroupMemberships;
import com.google.code.linkedinapi.schema.Groups;
import com.google.code.linkedinapi.schema.ImAccount;
import com.google.code.linkedinapi.schema.Industries;
import com.google.code.linkedinapi.schema.Industry;
import com.google.code.linkedinapi.schema.Job;
import com.google.code.linkedinapi.schema.JobBookmarks;
import com.google.code.linkedinapi.schema.JobSearch;
import com.google.code.linkedinapi.schema.JobSuggestions;
import com.google.code.linkedinapi.schema.Likes;
import com.google.code.linkedinapi.schema.MailboxItem;
import com.google.code.linkedinapi.schema.Network;
import com.google.code.linkedinapi.schema.People;
import com.google.code.linkedinapi.schema.PeopleSearch;
import com.google.code.linkedinapi.schema.Person;
import com.google.code.linkedinapi.schema.Post;
import com.google.code.linkedinapi.schema.Posts;
import com.google.code.linkedinapi.schema.Products;
import com.google.code.linkedinapi.schema.RelatedProfileViews;
import com.google.code.linkedinapi.schema.SchemaElementFactory;
import com.google.code.linkedinapi.schema.SchemaEntity;
import com.google.code.linkedinapi.schema.SupportedOrganizations;
import com.google.code.linkedinapi.schema.ToFollow;
import com.google.code.linkedinapi.schema.UpdateComment;
import com.google.code.linkedinapi.schema.UpdateComments;
import com.google.code.linkedinapi.schema.Volunteer;
import com.google.code.linkedinapi.schema.xpp.FollowingImpl;
import com.google.code.linkedinapi.schema.xpp.ImAccountImpl;
import com.google.code.linkedinapi.schema.xpp.RelatedProfileViewsImpl;
import com.google.code.linkedinapi.schema.xpp.SupportedOrganizationsImpl;
import com.google.code.linkedinapi.schema.xpp.ToFollowImpl;
import com.google.code.linkedinapi.schema.xpp.IndustriesImpl;
import com.google.code.linkedinapi.schema.xpp.IndustryImpl;
import com.google.code.linkedinapi.schema.xpp.ActivityImpl;
import com.google.code.linkedinapi.schema.xpp.BaseSchemaEntity;
import com.google.code.linkedinapi.schema.xpp.CommentImpl;
import com.google.code.linkedinapi.schema.xpp.CommentsImpl;
import com.google.code.linkedinapi.schema.xpp.CompaniesImpl;
import com.google.code.linkedinapi.schema.xpp.CompanyImpl;
import com.google.code.linkedinapi.schema.xpp.CompanySearchImpl;
import com.google.code.linkedinapi.schema.xpp.ConnectionsImpl;
import com.google.code.linkedinapi.schema.xpp.ErrorImpl;
import com.google.code.linkedinapi.schema.xpp.GroupImpl;
import com.google.code.linkedinapi.schema.xpp.GroupMembershipImpl;
import com.google.code.linkedinapi.schema.xpp.GroupMembershipsImpl;
import com.google.code.linkedinapi.schema.xpp.GroupsImpl;
import com.google.code.linkedinapi.schema.xpp.JobBookmarksImpl;
import com.google.code.linkedinapi.schema.xpp.JobImpl;
import com.google.code.linkedinapi.schema.xpp.JobSearchImpl;
import com.google.code.linkedinapi.schema.xpp.JobSuggestionsImpl;
import com.google.code.linkedinapi.schema.xpp.LikesImpl;
import com.google.code.linkedinapi.schema.xpp.MailboxItemImpl;
import com.google.code.linkedinapi.schema.xpp.NetworkImpl;
import com.google.code.linkedinapi.schema.xpp.PeopleImpl;
import com.google.code.linkedinapi.schema.xpp.PeopleSearchImpl;
import com.google.code.linkedinapi.schema.xpp.PersonImpl;
import com.google.code.linkedinapi.schema.xpp.PostImpl;
import com.google.code.linkedinapi.schema.xpp.PostsImpl;
import com.google.code.linkedinapi.schema.xpp.ProductsImpl;
import com.google.code.linkedinapi.schema.xpp.UpdateCommentImpl;
import com.google.code.linkedinapi.schema.xpp.UpdateCommentsImpl;
import com.google.code.linkedinapi.schema.xpp.VolunteerImpl;
import com.google.code.linkedinapi.schema.xpp.XppElementFactory;

/**
 * @author Nabeel Mukhtar
 *
 */
public class LinkedInApiXppClient extends BaseLinkedInApiClient {

    /** Field description */
    private static final SchemaElementFactory<String> OBJECT_FACTORY = new XppElementFactory();
    
    /** Field description */
	private static final Map<Class<? extends SchemaEntity>, Class<? extends BaseSchemaEntity>> XPP_CLASSES_MAP = new HashMap<Class<? extends SchemaEntity>, Class<? extends BaseSchemaEntity>>();
	
	static {
		XPP_CLASSES_MAP.put(Person.class, PersonImpl.class);
		XPP_CLASSES_MAP.put(Network.class, NetworkImpl.class);
		XPP_CLASSES_MAP.put(People.class, PeopleImpl.class);
		XPP_CLASSES_MAP.put(Connections.class, ConnectionsImpl.class);
		XPP_CLASSES_MAP.put(Error.class, ErrorImpl.class);
		XPP_CLASSES_MAP.put(MailboxItem.class, MailboxItemImpl.class);
		XPP_CLASSES_MAP.put(UpdateComment.class, UpdateCommentImpl.class);
		XPP_CLASSES_MAP.put(Activity.class, ActivityImpl.class);
		XPP_CLASSES_MAP.put(UpdateComments.class, UpdateCommentsImpl.class);
		XPP_CLASSES_MAP.put(PeopleSearch.class, PeopleSearchImpl.class);
		XPP_CLASSES_MAP.put(Likes.class, LikesImpl.class);
		XPP_CLASSES_MAP.put(Job.class, JobImpl.class);
		XPP_CLASSES_MAP.put(JobSearch.class, JobSearchImpl.class);
		XPP_CLASSES_MAP.put(JobBookmarks.class, JobBookmarksImpl.class);
		XPP_CLASSES_MAP.put(JobSuggestions.class, JobSuggestionsImpl.class);
		XPP_CLASSES_MAP.put(Companies.class, CompaniesImpl.class);
		XPP_CLASSES_MAP.put(Company.class, CompanyImpl.class);
		XPP_CLASSES_MAP.put(CompanySearch.class, CompanySearchImpl.class);
		XPP_CLASSES_MAP.put(Products.class, ProductsImpl.class);
		XPP_CLASSES_MAP.put(Group.class, GroupImpl.class);
		XPP_CLASSES_MAP.put(GroupMembership.class, GroupMembershipImpl.class);
		XPP_CLASSES_MAP.put(GroupMemberships.class, GroupMembershipsImpl.class);
		XPP_CLASSES_MAP.put(Post.class, PostImpl.class);
		XPP_CLASSES_MAP.put(Comment.class, CommentImpl.class);
		XPP_CLASSES_MAP.put(Comments.class, CommentsImpl.class);
		XPP_CLASSES_MAP.put(Posts.class, PostsImpl.class);
		XPP_CLASSES_MAP.put(Groups.class, GroupsImpl.class);
		XPP_CLASSES_MAP.put(Industries.class, IndustriesImpl.class);
		XPP_CLASSES_MAP.put(Industry.class, IndustryImpl.class);
		XPP_CLASSES_MAP.put(ToFollow.class, ToFollowImpl.class);
		XPP_CLASSES_MAP.put(Following.class, FollowingImpl.class);
		XPP_CLASSES_MAP.put(SupportedOrganizations.class, SupportedOrganizationsImpl.class);
		XPP_CLASSES_MAP.put(Volunteer.class, VolunteerImpl.class);
		XPP_CLASSES_MAP.put(ImAccount.class, ImAccountImpl.class);
		XPP_CLASSES_MAP.put(RelatedProfileViews.class, RelatedProfileViewsImpl.class);
	}
	
    /**
     * Constructs ...
     *
     *
     * @param consumerKey
     * @param consumerSecret
     */
    public LinkedInApiXppClient(String consumerKey, String consumerSecret) {
        super(consumerKey, consumerSecret);
    }

    /**
     * Method description
     *
     *
     * @param xmlContent
     * @param <T>
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    protected <T> T unmarshallObject(Class<T> clazz, InputStream xmlContent) {
        try {
        	XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
        	parser.setInput(xmlContent, ApplicationConstants.CONTENT_ENCODING);
        	
        	if (parser.getEventType() == XmlPullParser.START_DOCUMENT) {
        		parser.nextTag();
        	}

        	BaseSchemaEntity entity = getSchemaEntityByClass(clazz);
        	
        	entity.init(parser);

            return (T) entity;
        } catch (Exception e) {
            throw new LinkedInApiClientException(e);
        }
    }

	/**
     * Method description
     *
     *
     * @param element
     *
     * @return
     */
    protected String marshallObject(Object element) {
    	if (element instanceof String) {
    		return (String) element;
    	} else if (element instanceof BaseSchemaEntity) {
    		try {
    			StringWriter writer = new StringWriter();
				XmlSerializer serializer = XmlPullParserFactory.newInstance().newSerializer();
				serializer.setOutput(writer);
				((BaseSchemaEntity) element).toXml(serializer);
				serializer.flush();
				return writer.toString();
			} catch (Exception e) {
	    		throw new LinkedInApiClientException("Unkown element encountered:" + element, e);
			}
    	} else {
    		throw new LinkedInApiClientException("Unkown element encountered:" + element);
    	}
    }

    /**
     * Method description
     *
     * @return
     */
    protected SchemaElementFactory<?> createObjectFactory() {
    	return OBJECT_FACTORY;
    }
    
    /**
     * Method description
     *
     *
     * @param urlFormat
     *
     * @return
     */
    protected LinkedInApiUrlBuilder createLinkedInApiUrlBuilder(String urlFormat) {
        return new LinkedInApiUrlBuilder(urlFormat);
    }
    
    /**
     * Method description
     *
     */
    private BaseSchemaEntity getSchemaEntityByClass(Class<?> clazz) {
    	if (XPP_CLASSES_MAP.containsKey(clazz)) {
    		Class<? extends BaseSchemaEntity> implClass = XPP_CLASSES_MAP.get(clazz);
    		try {
				return implClass.newInstance();
			} catch (Exception e) {
	    		throw new LinkedInApiClientException("Could not instantiate class: " + implClass.getName(), e);
			}
    	} else {
    		throw new LinkedInApiClientException("Unknown class encountered in response: " + clazz.getName());
    	}
	}
    
	@Override
	public JobBuilder newJobBuilder() {
		return new JobBuilderImpl(OBJECT_FACTORY);
	}
}
