/**
 * Copyright (c) 2015 Hosting.com, Inc.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the
 * following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or substantial
 * portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO
 * EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE
 * USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.hosting.lb.healthcheck.web;

import java.util.Collections;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.hosting.lb.healthcheck.HealthCheck;
import com.hosting.lb.healthcheck.HealthCheckManager;
import com.hosting.lb.healthcheck.HealthCheckResult;
import com.hosting.lb.healthcheck.SimpleHealthCheck;

/**
 * Example health check hosted at the URI path "/health"
 */
@Path ("/health")
public class HealthCheckResource
{
	/**
	 * Run example health check
	 * 
	 * @return Response that indicates HTTP status code and JSON check result details
	 */
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public Response test ()
	{
		List<HealthCheck> checks = Collections.singletonList ((HealthCheck) new SimpleHealthCheck ());
		HealthCheckResult result = HealthCheckManager.process (checks);
		String resultMsg = result.toString ();
		if (result.isError ())
		{
			return Response.serverError ().type (MediaType.APPLICATION_JSON).entity (resultMsg).build ();
		}
		return Response.ok (resultMsg, MediaType.APPLICATION_JSON).build ();
	}
}
