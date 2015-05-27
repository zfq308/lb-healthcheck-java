package org.lb.healthcheck.web;

import java.util.Collections;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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
	 * Method processing HTTP GET requests, producing "text/plain" MIME media type.
	 * 
	 * @return String that will be send back as a response of type "text/plain".
	 */
	@GET
	@Produces ("application/json")
	public String test ()
	{
		List<HealthCheck> checks = Collections.singletonList ((HealthCheck) new SimpleHealthCheck ());
		HealthCheckResult result = HealthCheckManager.process (checks);
		// response.setStatus (result.getCode ());
		// response.setContentType ("application/json");
		return result.toString ();
	}
}
