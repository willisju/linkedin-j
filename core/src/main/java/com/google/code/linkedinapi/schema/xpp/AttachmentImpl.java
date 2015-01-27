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

public class AttachmentImpl
extends BaseSchemaEntity implements Attachment
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected String summary;
    protected String title;
    protected String contentDomain;
    protected String contentUrl;
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

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();
            if (name.equals("summary")) {
                setSummary(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("title")) {
                setTitle(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("content-domain")) {
                setContentDomain(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("content-url")) {
                setContentUrl(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("image-url")) {
                setImageUrl(XppUtils.getElementValueFromNode(parser));
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }
    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "attachment");
        XppUtils.setElementValueToNode(element, "summary", getSummary());
        XppUtils.setElementValueToNode(element, "title", getTitle());
        XppUtils.setElementValueToNode(element, "content-domain", getContentDomain());
        XppUtils.setElementValueToNode(element, "content-url", getContentUrl());
        XppUtils.setElementValueToNode(element, "image-url", getImageUrl());
        
        
        serializer.endTag(null, "attachment");
    }
}
