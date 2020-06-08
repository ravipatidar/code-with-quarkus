package org.acme;

import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.acme.config.GreetingConfiguration;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.quarkus.arc.config.ConfigPrefix;

@Path("/hello")
public class ExampleResource {
    @Inject
   GreetingConfiguration greetingConfig;
   
   @ConfigPrefix("other") 
   GreetingConfiguration otherConfiguration;
   @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return greetingConfig.message+ " " + greetingConfig.name.orElse("world") + greetingConfig.suffix+greetingConfig.hidden.prizeamount;
    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/other")
    public String other() {
        return otherConfiguration.message+ " " + otherConfiguration.name.orElse("world") ;
    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public String hello(@PathParam String name) {
        return "hello "+name;
    }
}