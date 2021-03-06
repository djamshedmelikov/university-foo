/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.surfnet.example.api.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.surfnet.example.api.model.ClientDetails;
import org.surfnet.example.api.model.Student;
import org.surfnet.example.api.oauth.PrincipalService;

import com.yammer.dropwizard.auth.Auth;

/**
 * Serves up resources
 * 
 */
@Path("/student/{studentIdentifier}")
@Produces(MediaType.APPLICATION_JSON)
public class StudentResource {

  private PrincipalService<Student, UsernamePasswordCredentials> principalService;

  /**
   * @param principalService
   */
  public StudentResource(PrincipalService<Student, UsernamePasswordCredentials> principalService) {
    this.principalService = principalService;
  }

  @GET
  public Student getStudent(@Auth
  ClientDetails clientDetails, @PathParam("studentIdentifier")
  String studentIdentifier) {
    if ("@me".equalsIgnoreCase(studentIdentifier)) {
      studentIdentifier = ((Student)clientDetails.getPrincipal()).getIdentifier();
    }
    return principalService.getPrincipal(new UsernamePasswordCredentials(studentIdentifier, "not-used"));
  }

}
