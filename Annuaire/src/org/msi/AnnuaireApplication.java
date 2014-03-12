package org.msi;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("annuaire")
public class AnnuaireApplication extends ResourceConfig {
	public AnnuaireApplication() {
		packages("org.msi");
	}
}
