package com.danverem.stores.services;

import com.danverem.stores.models.Ping;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class PingService {

    public Ping ping() {
        return new Ping("Health check successful");
    }
}
