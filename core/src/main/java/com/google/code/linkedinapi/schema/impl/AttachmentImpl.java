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
import com.google.code.linkedinapi.schema.Attachment;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "summary",
    "title",
    "contentDomain",
    "contentUrl",
    "imageUrl"
})
@XmlRootElement(name = "attachment")
public class AttachmentImpl
    implements Serializable, Attachment
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true)
    protected String summary;
    @XmlElement(required = true)
    protected String title;
    @XmlElement(name = "content-domain", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String contentDomain;
    @XmlElement(name = "content-url", required = true)
    protected String contentUrl;
    @XmlElement(name = "image-url", required = true)
    protected String imageUrl;

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

    public String getContentDomain() {
        return contentDomain;
    }

    public void setContentDomain(String value) {
        this.contentDomain = value;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String value) {
        this.contentUrl = value;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String value) {
        this.imageUrl = value;
    }

}
