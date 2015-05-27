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
		String resultMsg = result.toString();
		if (result.isError ())
		{
			return Response.serverError ().type (MediaType.APPLICATION_JSON).entity (resultMsg).build ();
		}
		return Response.ok (resultMsg, MediaType.APPLICATION_JSON).build ();
	}
}
