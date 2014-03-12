package org.demo;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("dirapi")
public class DirectoryApplication extends ResourceConfig {
	public DirectoryApplication() {
		packages("org.demo");
	}
}
