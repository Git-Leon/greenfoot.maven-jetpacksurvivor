package com.github.git_leon.jetpack_survivor_maven.system;

import com.github.git_leon.jetpack_survivor_maven.utils.exceptions.JFootError;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JFootProperties {
    private Properties properties;

    public JFootProperties(InputStream is) {
        this.properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            throw new JFootError(e);
        }
    }

    public JFProperty getProperty(JFootPropertyType jFootPropertyType) {
        String propertyName = jFootPropertyType.toString();
        String propertyValue = properties.getProperty(propertyName);
        return new JFProperty(propertyName).set(propertyValue);
    }

    public Properties getProperties() {
        return properties;
    }

    public void load(InputStream is) {
        try {
            getProperties().load(is);
        } catch (IOException e) {
            throw new JFootError(e);
        }
    }
}
