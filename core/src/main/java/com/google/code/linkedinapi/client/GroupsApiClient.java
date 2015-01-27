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
package com.google.code.linkedinapi.client;

import java.util.Date;
import java.util.Set;

import com.google.code.linkedinapi.client.enumeration.CommentField;
import com.google.code.linkedinapi.client.enumeration.GroupField;
import com.google.code.linkedinapi.client.enumeration.GroupMembershipField;
import com.google.code.linkedinapi.client.enumeration.PostField;
import com.google.code.linkedinapi.client.enumeration.PostSortOrder;
import com.google.code.linkedinapi.schema.Comment;
import com.google.code.linkedinapi.schema.Comments;
import com.google.code.linkedinapi.schema.EmailDigestFrequencyCode;
import com.google.code.linkedinapi.schema.Group;
import com.google.code.linkedinapi.schema.GroupMembership;
import com.google.code.linkedinapi.schema.GroupMemberships;
import com.google.code.linkedinapi.schema.Groups;
import com.google.code.linkedinapi.schema.Post;
import com.google.code.linkedinapi.schema.PostCategoryCode;
import com.google.code.linkedinapi.schema.Posts;


/**
 * The Interface GroupsApiClient.
 */
public interface GroupsApiClient extends LinkedInAuthenticationClient {
	
	/**
	 * Gets the group by id.
	 * 
	 * @param groupId the group id
	 * 
	 * @return the group by id
	 */
	public Group getGroupById(String groupId);
	
	/**
	 * Gets the group by id.
	 * 
	 * @param groupId the group id
	 * @param groupFields the group fields
	 * 
	 * @return the group by id
	 */
	public Group getGroupById(String groupId, Set<GroupField> groupFields);
	
	/**
	 * Gets the group memberships.
	 * 
	 * @return the group memberships
	 */
	public GroupMemberships getGroupMemberships();
	
	/**
	 * Gets the group memberships.
	 * 
	 * @param groupMembershipFields the group membership fields
	 * 
	 * @return the group memberships
	 */
	public GroupMemberships getGroupMemberships(Set<GroupMembershipField> groupMembershipFields);
	
	/**
	 * Gets the group memberships.
	 * 
	 * @param groupMembershipFields the group membership fields
	 * @param start the start
	 * @param count the count
	 * 
	 * @return the group memberships
	 */
	public GroupMemberships getGroupMemberships(Set<GroupMembershipField> groupMembershipFields, int start, int count);
	
	/**
	 * Gets the group memberships.
	 * 
	 * @param personId the person id
	 * 
	 * @return the group memberships
	 */
	public GroupMemberships getGroupMemberships(String personId);
	
	/**
	 * Gets the group memberships.
	 * 
	 * @param personId the person id
	 * @param groupMembershipFields the group membership fields
	 * 
	 * @return the group memberships
	 */
	public GroupMemberships getGroupMemberships(String personId, Set<GroupMembershipField> groupMembershipFields);
	
	/**
	 * Gets the group memberships.
	 * 
	 * @param personId the person id
	 * @param groupMembershipFields the group membership fields
	 * @param start the start
	 * @param count the count
	 * 
	 * @return the group memberships
	 */
	public GroupMemberships getGroupMemberships(String personId, Set<GroupMembershipField> groupMembershipFields, int start, int count);
	
	/**
	 * Gets the group membership.
	 * 
	 * @param groupId the group id
	 * 
	 * @return the group membership
	 */
	public GroupMembership getGroupMembership(String groupId);
	
	/**
	 * Gets the users posts for their group membership.
	 * 
	 * @param groupId the group id
	 * 
	 * @return the group membership
	 */
	
	public Posts getMyGroupPosts(String groupId, Set<PostField> postFields, String roleType);
	
	/**
	 * Gets the users posts for their group membership.
	 * 
	 * @param groupId the group id
	 * @param roleType the role you had in the post one of {"creator", "follower", "commenter"}
	 * 
	 * @return the posts
	 */
	public Posts getMyGroupPosts(String groupId, Set<PostField> postFields, String roleType, int start, int count);
	
	/**
	 * Update group membership.
	 * 
	 * @param groupId the group id
	 * @param contactEmail the contact email
	 * @param emailFrequency the email frequency
	 * @param showLogoInProfile the show logo in profile
	 * @param emailAnnouncements the email announcements
	 * @param allowMessagesFromMembers the allow messages from members
	 * @param emailForEveryPost the email for every post
	 */
	public void updateGroupMembership(String groupId, String contactEmail, EmailDigestFrequencyCode emailFrequency,
			boolean showLogoInProfile, boolean emailAnnouncements, boolean allowMessagesFromMembers, boolean emailForEveryPost);
	
	/**
	 * Join group.
	 * 
	 * @param groupId the group id
	 */
	public void joinGroup(String groupId);
	
	/**
	 * Leave group.
	 * 
	 * @param groupId the group id
	 */
	public void leaveGroup(String groupId);
	
	/**
	 * Gets the posts by group.
	 * 
	 * @param groupId the group id
	 * 
	 * @return the posts by group
	 */
	public Posts getPostsByGroup(String groupId);
	
	/**
	 * Gets the posts by group.
	 * 
	 * @param groupId the group id
	 * 
	 * @return the posts by group
	 */
	public Posts getPostsByGroup(String groupId, Set<PostField> postFields);
	
	
	/**
	 * Gets the posts by group.
	 * 
	 * @param groupId the group id
	 * @param start the start
	 * @param count the count
	 * 
	 * @return the posts by group
	 */
	public Posts getPostsByGroup(String groupId, int start, int count);
	
	/**
	 * Gets the posts by group.
	 * 
	 * @param groupId the group id
	 * @param start the start
	 * @param count the count
	 * 
	 * @return the posts by group
	 */
	public Posts getPostsByGroup(String groupId, Set<PostField> postFields, int start, int count);
	
	/**
	 * Gets the posts by group.
	 * 
	 * @param groupId the group id
	 * @param start the start
	 * @param count the count
	 * @param order the order
	 * 
	 * @return the posts by group
	 */
	public Posts getPostsByGroup(String groupId, int start, int count, PostSortOrder order);
	
	/**
	 * Gets the posts by group.
	 * 
	 * @param groupId the group id
	 * @param start the start
	 * @param count the count
	 * @param order the order
	 * 
	 * @return the posts by group
	 */
	public Posts getPostsByGroup(String groupId, Set<PostField> postFields, int start, int count, PostSortOrder order);
	
	/**
	 * Gets the posts by group.
	 * 
	 * @param groupId the group id
	 * @param start the start
	 * @param count the count
	 * @param order the order
	 * @param category the category
	 * 
	 * @return the posts by group
	 */
	public Posts getPostsByGroup(String groupId, int start, int count, PostSortOrder order, PostCategoryCode category);
	
	/**
	 * Gets the posts by group.
	 * 
	 * @param groupId the group id
	 * @param start the start
	 * @param count the count
	 * @param order the order
	 * @param category the category
	 * 
	 * @return the posts by group
	 */
	public Posts getPostsByGroup(String groupId, Set<PostField> postFields, int start, int count, PostSortOrder order, PostCategoryCode category);
	
	/**
	 * Gets the posts by group.
	 * 
	 * @param groupId the group id
	 * @param start the start
	 * @param count the count
	 * @param modifiedSince the modified since
	 * 
	 * @return the posts by group
	 */
	public Posts getPostsByGroup(String groupId, int start, int count, Date modifiedSince);
	
	/**
	 * Gets the posts by group.
	 * 
	 * @param groupId the group id
	 * @param start the start
	 * @param count the count
	 * @param modifiedSince the modified since
	 * 
	 * @return the posts by group
	 */
	public Posts getPostsByGroup(String groupId, Set<PostField> postFields, int start, int count, Date modifiedSince);
	
	/**
	 * Gets the posts by group.
	 * 
	 * @param groupId the group id
	 * @param start the start
	 * @param count the count
	 * @param order the order
	 * @param modifiedSince the modified since
	 * 
	 * @return the posts by group
	 */
	public Posts getPostsByGroup(String groupId, int start, int count, PostSortOrder order, Date modifiedSince);
	
	/**
	 * Gets the posts by group.
	 * 
	 * @param groupId the group id
	 * @param start the start
	 * @param count the count
	 * @param order the order
	 * @param modifiedSince the modified since
	 * 
	 * @return the posts by group
	 */
	public Posts getPostsByGroup(String groupId, Set<PostField> postFields, int start, int count, PostSortOrder order, Date modifiedSince);
	
	/**
	 * Gets the posts by group.
	 * 
	 * @param groupId the group id
	 * @param start the start
	 * @param count the count
	 * @param order the order
	 * @param category the category
	 * @param modifiedSince the modified since
	 * 
	 * @return the posts by group
	 */
	public Posts getPostsByGroup(String groupId, int start, int count, PostSortOrder order, PostCategoryCode category, Date modifiedSince);
	
	/**
	 * Gets the posts by group.
	 * 
	 * @param groupId the group id
	 * @param start the start
	 * @param count the count
	 * @param order the order
	 * @param category the category
	 * @param modifiedSince the modified since
	 * 
	 * @return the posts by group
	 */
	public Posts getPostsByGroup(String groupId, Set<PostField> postFields, int start, int count, PostSortOrder order, PostCategoryCode category, Date modifiedSince);
	
	/**
	 * Gets the post.
	 * 
	 * @param postId the post id
	 * 
	 * @return the post
	 */
	public Post getPost(String postId);
	
	/**
	 * Gets the post.
	 * 
	 * @param postId the post id
	 * @param postFields the post fields
	 * 
	 * @return the post
	 */
	public Post getPost(String postId, Set<PostField> postFields);
	
	/**
	 * Gets the post comments.
	 * 
	 * @param postId the post id
	 * 
	 * @return the post comments
	 */
	public Comments getPostComments(String postId);
	
	/**
	 * Gets the post comments.
	 * 
	 * @param postId the post id
	 * @param commentFields the comment fields
	 * 
	 * @return the post comments
	 */
	public Comments getPostComments(String postId, Set<CommentField> commentFields);
	
	/**
	 * Gets the post comments.
	 * 
	 * @param postId the post id
	 * @param start the start
	 * @param count the count
	 * 
	 * @return the post comments
	 */
	public Comments getPostComments(String postId, int start, int count);
	
	/**
	 * Gets the post comments.
	 * 
	 * @param postId the post id
	 * @param commentFields the comment fields
	 * @param start the start
	 * @param count the count
	 * 
	 * @return the post comments
	 */
	public Comments getPostComments(String postId, Set<CommentField> commentFields, int start, int count);
	
	/**
	 * Creates the post.
	 * 
	 * @param title the title
	 * @param summary the summary
	 */
	public void createPost(String groupId, String title, String summary);
	
	/**
	 * Like post.
	 * 
	 * @param postId the post id
	 */
	public void likeGroupPost(String postId);
	
	/**
	 * Unlike post.
	 * 
	 * @param postId the post id
	 */
	public void unlikeGroupPost(String postId);
	
	/**
	 * Follow post.
	 * 
	 * @param postId the post id
	 */
	public void followPost(String postId);
	
	/**
	 * Unfollow post.
	 * 
	 * @param postId the post id
	 */
	public void unfollowPost(String postId);
	
	/**
	 * Flag post.
	 * 
	 * @param postId the post id
	 * @param code the code
	 */
	public void flagPost(String postId, PostCategoryCode code);
	
	/**
	 * Delete post.
	 * 
	 * @param postId the post id
	 */
	public void deletePost(String postId);
	
	/**
	 * Gets the post comment.
	 * 
	 * @param commentId the comment id
	 * 
	 * @return the post comment
	 */
	public Comment getPostComment(String commentId);
	
	/**
	 * Gets the post comment.
	 * 
	 * @param commentId the comment id
	 * @param commentFields the comment fields
	 * 
	 * @return the post comment
	 */
	public Comment getPostComment(String commentId, Set<CommentField> commentFields);
	
	/**
	 * Adds the post comment.
	 * 
	 * @param postId the post id
	 * @param comment the comment
	 */
	public void addPostComment(String postId, String comment);
	
	/**
	 * Delete post comment.
	 * 
	 * @param commentId the comment id
	 */
	public void deletePostComment(String commentId);
	
	/**
	 * Gets the suggested groups.
	 * 
	 * @return the suggested groups
	 */
	public Groups getSuggestedGroups();
	
	/**
	 * Gets the suggested groups.
	 * 
	 * @param groupFields the group fields
	 * 
	 * @return the suggested groups
	 */
	public Groups getSuggestedGroups(Set<GroupField> groupFields);
	
	/**
	 * Delete group suggestion.
	 * 
	 * @param groupId the group id
	 */
	public void deleteGroupSuggestion(String groupId);

	
}
