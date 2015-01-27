package com.google.code.linkedinapi.schema;

/**
 * 
 * @author Jonathon Willis
 * 
 * <honors-awards total="">
 *   <honor-award>
 *     <id></id>
 *     <name></name>
 *     <issuer></issuer>
 *   </honor-award>
 * </honors-awards>
 *
 */

public interface HonorAward extends SchemaEntity{
	
	String getId();
    void setId(String value);
    String getName();
    void setName(String value);
    String getIssuer();
    void setIssuer(String value);
    

}
