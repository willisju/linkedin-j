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

import com.google.code.linkedinapi.client.impl.LinkedInApiXppClient;

/**
 * @author Nabeel Mukhtar
 *
 */
public class LinkedInApiXppClientTest extends LinkedInApiClientTest {

	/** 
	 * @see com.google.code.linkedinapi.client.LinkedInApiClientTest#setUp()
	 */
	public void setUp() throws Exception {
		super.setUp();
		client = factory.createLinkedInApiClient(LinkedInApiXppClient.class, accessToken);
	}

	/**
	 * @see com.google.code.linkedinapi.client.LinkedInApiClientTest#tearDown()
	 */
	public void tearDown() throws Exception {
		super.tearDown();
		client = null;
	}
}
