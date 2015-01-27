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
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.google.code.linkedinapi.schema.Adapter1;
import com.google.code.linkedinapi.schema.Attachment;
import com.google.code.linkedinapi.schema.Category;
import com.google.code.linkedinapi.schema.Comments;
import com.google.code.linkedinapi.schema.Creator;
import com.google.code.linkedinapi.schema.Likes;
import com.google.code.linkedinapi.schema.Post;
import com.google.code.linkedinapi.schema.RelationToViewer;
import com.google.code.linkedinapi.schema.Type;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "type",
    "category",
    "creationTimestamp",
    "creator",
    "summary",
    "title",
    "likes",
    "relationToViewer",
    "attachment",
    "comments",
    "siteGroupPostUrl"
})
@XmlRootElement(name = "post")
public class PostImpl
    implements Serializable, Post
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;
    @XmlElement(required = true, type = TypeImpl.class)
    protected TypeImpl type;
    @XmlElement(type = CategoryImpl.class)
    protected CategoryImpl category;
    @XmlElement(name = "creation-timestamp", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long creationTimestamp;
    @XmlElement(required = true, type = CreatorImpl.class)
    protected CreatorImpl creator;
    @XmlElement(required = true)
    protected String summary;
    @XmlElement(required = true)
    protected String title;
    @XmlElement(required = true, type = LikesImpl.class)
    protected LikesImpl likes;
    @XmlElement(name = "relation-to-viewer", required = true, type = RelationToViewerImpl.class)
    protected RelationToViewerImpl relationToViewer;
    @XmlElement(required = true, type = AttachmentImpl.class)
    protected AttachmentImpl attachment;
    @XmlElement(required = true, type = CommentsImpl.class)
    protected CommentsImpl comments;
    @XmlElement(name = "site-group-post-url")
    protected String siteGroupPostUrl;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type value) {
        this.type = ((TypeImpl) value);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category value) {
        this.category = ((CategoryImpl) value);
    }

    public Long getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Long value) {
        this.creationTimestamp = value;
    }

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator value) {
        this.creator = ((CreatorImpl) value);
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String value) {
        this.summary = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public Likes getLikes() {
        return likes;
    }

    public void setLikes(Likes value) {
        this.likes = ((LikesImpl) value);
    }

    public RelationToViewer getRelationToViewer() {
        return relationToViewer;
    }

    public void setRelationToViewer(RelationToViewer value) {
        this.relationToViewer = ((RelationToViewerImpl) value);
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment value) {
        this.attachment = ((AttachmentImpl) value);
    }

    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments value) {
        this.comments = ((CommentsImpl) value);
    }

    public String getSiteGroupPostUrl() {
        return siteGroupPostUrl;
    }

    public void setSiteGroupPostUrl(String value) {
        this.siteGroupPostUrl = value;
    }

}
