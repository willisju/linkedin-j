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

import com.google.code.linkedinapi.schema.Comment;
import com.google.code.linkedinapi.schema.Creator;
import com.google.code.linkedinapi.schema.RelationToViewer;

public class CommentImpl
extends BaseSchemaEntity    implements Comment
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected Long creationTimestamp;
    protected CreatorImpl creator;
    protected String id;
    protected RelationToViewerImpl relationToViewer;
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

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();
            if (name.equals("creation-timestamp")) {
                setCreationTimestamp(XppUtils.getElementValueAsLongFromNode(parser));
            } else if (name.equals("creator")) {
                CreatorImpl node = new CreatorImpl();
                node.init(parser);
                setCreator(node);
            } else if (name.equals("id")) {
                setId(XppUtils.getElementValueFromNode(parser));
            } else if (name.equals("relation-to-viewer")) {
                RelationToViewerImpl node = new RelationToViewerImpl();
                node.init(parser);
                setRelationToViewer(node);
            } else if (name.equals("text")) {
                setText(XppUtils.getElementValueFromNode(parser));
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }
    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "comment");
        XppUtils.setElementValueToNode(element, "creation-timestamp", getCreationTimestamp());
        if (getCreator() != null) {
            ((CreatorImpl) getCreator()).toXml(serializer);
        }
        XppUtils.setElementValueToNode(element, "id", getId());
        if (getRelationToViewer() != null) {
            ((RelationToViewerImpl) getRelationToViewer()).toXml(serializer);
        }
        XppUtils.setElementValueToNode(element, "text", getText());
        
        
        serializer.endTag(null, "comment");
    }
}
