package org.netcompany.accounts.account;

import org.glassfish.jersey.server.ResourceConfig;
import jakarta.ws.rs.ext.Provider;

@Provider
public class MyApplication extends ResourceConfig {

	public MyApplication() {
		
		register(new AppBinder());   
		
	}
	
	

}
