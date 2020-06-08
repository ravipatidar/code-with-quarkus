package org.acme.config;

import io.quarkus.arc.config.ConfigProperties;

import java.util.List;
import java.util.Optional;

@ConfigProperties(prefix = "greeting") 
public class GreetingConfiguration {

    public String message;
    public String suffix; 
    public Optional<String> name;
    public HiddenConfig hidden;

    public static class HiddenConfig{
        public String prizeamount;
        public List<String> recipients;
    }

}
