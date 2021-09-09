package com.trm.winecellar;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/myresource")
public class MyResource {
	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the client as  "text/plain" type.
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Got it!";
	}
	
	

}
