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

import com.google.code.linkedinapi.schema.AvailableActions;
import com.google.code.linkedinapi.schema.MembershipState;
import com.google.code.linkedinapi.schema.RelatedConnections;
import com.google.code.linkedinapi.schema.RelationToViewer;

public class RelationToViewerImpl
    extends BaseSchemaEntity
    implements RelationToViewer
{

    /**
	 * 
	 */
	private static final long serialVersionUID = -5385043041125747824L;
    protected RelatedConnectionsImpl relatedConnections;
	protected Long distance;
	protected MembershipStateImpl membershipState;
	protected boolean isFollowing;
	protected boolean isLiked;
	protected AvailableActionsImpl availableActions;


    public RelatedConnections getRelatedConnections() {
        return relatedConnections;
    }

    public void setRelatedConnections(RelatedConnections value) {
        this.relatedConnections = ((RelatedConnectionsImpl) value);
    }
    
    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long value) {
        this.distance = value;
    }
    
    public MembershipState getMembershipState() {
        return membershipState;
    }

    public void setMembershipState(MembershipState value) {
        this.membershipState = ((MembershipStateImpl) value);
    }

    public boolean isIsFollowing() {
        return isFollowing;
    }

    public void setIsFollowing(boolean value) {
        this.isFollowing = value;
    }

    public boolean isIsLiked() {
        return isLiked;
    }

    public void setIsLiked(boolean value) {
        this.isLiked = value;
    }

    public AvailableActions getAvailableActions() {
        return availableActions;
    }

    public void setAvailableActions(AvailableActions value) {
        this.availableActions = ((AvailableActionsImpl) value);
    }
    
    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();
            if (name.equals("related-connections")) {
                RelatedConnectionsImpl node = new RelatedConnectionsImpl();
                node.init(parser);
                setRelatedConnections(node);
            } else if (name.equals("distance")) {
                setDistance(XppUtils.getElementValueAsLongFromNode(parser));
            } else if (name.equals("membership-state")) {
                MembershipStateImpl node = new MembershipStateImpl();
                node.init(parser);
                setMembershipState(node);
            } else if (name.equals("is-following")) {
                setIsFollowing(Boolean.parseBoolean(XppUtils.getElementValueFromNode(parser)));
            } else if (name.equals("is-liked")) {
                setIsLiked(Boolean.parseBoolean(XppUtils.getElementValueFromNode(parser)));
            } else if (name.equals("available-actions")) {
                AvailableActionsImpl node = new AvailableActionsImpl();
                node.init(parser);
                setAvailableActions(node);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }
    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "relation-to-viewer");
        if (getRelatedConnections() != null) {
            ((RelatedConnectionsImpl) getRelatedConnections()).toXml(serializer);
        }
        XppUtils.setElementValueToNode(element, "distance", getDistance());
        if (getMembershipState() != null) {
            ((MembershipStateImpl) getMembershipState()).toXml(serializer);
        }
        XppUtils.setElementValueToNode(element, "is-following", String.valueOf(isIsFollowing()));
        XppUtils.setElementValueToNode(element, "is-liked", String.valueOf(isIsLiked()));
        if (getAvailableActions() != null) {
            ((AvailableActionsImpl) getAvailableActions()).toXml(serializer);
        }
        
        
        serializer.endTag(null, "relation-to-viewer");
    }
}
