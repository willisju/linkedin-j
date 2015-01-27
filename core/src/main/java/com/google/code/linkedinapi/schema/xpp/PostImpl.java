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

import com.google.code.linkedinapi.schema.Attachment;
import com.google.code.linkedinapi.schema.Category;
import com.google.code.linkedinapi.schema.Comments;
import com.google.code.linkedinapi.schema.Creator;
import com.google.code.linkedinapi.schema.Likes;
import com.google.code.linkedinapi.schema.Post;
import com.google.code.linkedinapi.schema.RelationToViewer;
import com.google.code.linkedinapi.schema.Type;

public class PostImpl
extends BaseSchemaEntity    implements Post
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected String id;
    protected TypeImpl type;
    protected CategoryImpl category;
    protected Long creationTimestamp;
    protected CreatorImpl creator;
    protected String summary;
    protected String title;
    protected LikesImpl likes;
    protected RelationToViewerImpl relationToViewer;
    protected AttachmentImpl attachment;
    protected CommentsImpl comments;
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
        this.type = (TypeImpl) value;
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

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();
            if (name.equals("id")) {
                setId(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("type")) {
            	TypeImpl node = new TypeImpl();
            	node.init(parser);
                setType(node);
            } else if (name.equals("category")) {
                CategoryImpl node = new CategoryImpl();
                node.init(parser);
                setCategory(node);
            } else if (name.equals("creation-timestamp")) {
                setCreationTimestamp(XppUtils.getElementValueAsLongFromNode(parser));
            } else if (name.equals("creator")) {
                CreatorImpl node = new CreatorImpl();
                node.init(parser);
                setCreator(node);
            } else if (name.equals("summary")) {
                setSummary(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("title")) {
                setTitle(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("likes")) {
                LikesImpl node = new LikesImpl();
                node.init(parser);
                setLikes(node);
            } else if (name.equals("relation-to-viewer")) {
                RelationToViewerImpl node = new RelationToViewerImpl();
                node.init(parser);
                setRelationToViewer(node);
            } else if (name.equals("attachment")) {
                AttachmentImpl node = new AttachmentImpl();
                node.init(parser);
                setAttachment(node);
            } else if (name.equals("comments")) {
                CommentsImpl node = new CommentsImpl();
                node.init(parser);
                setComments(node);
            } else if (name.equals("site-group-post-url")) {
                setSiteGroupPostUrl(XppUtils.getElementValueFromNode(parser));
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }
    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "post");
        XppUtils.setElementValueToNode(element, "id", getId());
        XppUtils.setElementValueToNode(element, "type", getType());
        if (getCategory() != null) {
            ((CategoryImpl) getCategory()).toXml(serializer);
        }
        XppUtils.setElementValueToNode(element, "creation-timestamp", getCreationTimestamp());
        if (getCreator() != null) {
            ((CreatorImpl) getCreator()).toXml(serializer);
        }
        XppUtils.setElementValueToNode(element, "summary", getSummary());
        XppUtils.setElementValueToNode(element, "title", getTitle());
        if (getLikes() != null) {
            ((LikesImpl) getLikes()).toXml(serializer);
        }
        if (getRelationToViewer() != null) {
            ((RelationToViewerImpl) getRelationToViewer()).toXml(serializer);
        }
        if (getAttachment() != null) {
            ((AttachmentImpl) getAttachment()).toXml(serializer);
        }
        if (getComments() != null) {
            ((CommentsImpl) getComments()).toXml(serializer);
        }
        XppUtils.setElementValueToNode(element, "site-group-post-url", getSiteGroupPostUrl());
        
        
        serializer.endTag(null, "post");
    }
}
