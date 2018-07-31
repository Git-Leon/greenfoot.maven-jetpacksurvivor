package com.github.git_leon.jetpack_survivor_maven.system.application.properties;

import java.io.InputStream;
import java.util.Properties;

public interface JFootPropertiesInterface {

     JFProperty getProperty(JFootPropertyType jFootPropertyType);

     Properties getProperties() ;

     void load(InputStream is);
}
