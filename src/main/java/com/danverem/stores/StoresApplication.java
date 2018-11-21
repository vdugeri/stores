package com.danverem.stores;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class StoresApplication extends ResourceConfig {

    public StoresApplication() {
        packages("com.danverem.stores");
        register(JacksonFeature.class);
    }
}
