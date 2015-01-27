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
import com.google.code.linkedinapi.schema.Comment;
import com.google.code.linkedinapi.schema.Creator;
import com.google.code.linkedinapi.schema.RelationToViewer;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "creationTimestamp",
    "creator",
    "id",
    "relationToViewer",
    "text"
})
@XmlRootElement(name = "comment")
public class CommentImpl
    implements Serializable, Comment
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "creation-timestamp", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long creationTimestamp;
    @XmlElement(required = true, type = CreatorImpl.class)
    protected CreatorImpl creator;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;
    @XmlElement(name = "relation-to-viewer", required = true, type = RelationToViewerImpl.class)
    protected RelationToViewerImpl relationToViewer;
    @XmlElement(required = true)
    protected String text;

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

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public RelationToViewer getRelationToViewer() {
        return relationToViewer;
    }

    public void setRelationToViewer(RelationToViewer value) {
        this.relationToViewer = ((RelationToViewerImpl) value);
    }

    public String getText() {
        return text;
    }

    public void setText(String value) {
        this.text = value;
    }

}
