package com.github.git_leon.jetpack_survivor_maven.system;

import com.github.git_leon.jetpack_survivor_maven.utils.exceptions.JFootError;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

import static com.github.git_leon.jetpack_survivor_maven.system.JFootPropertyType.*;

public class JFootProperty {
    private Properties properties;

    public JFootProperty(String... args) {
        this.properties = new Properties();
        args = args != null ? Arrays.copyOf(args, 5) : new String[5];
        set(PROJECT_NAME, args[0]);
        set(MAIN_CLASS, args[1]);
        set(SCENARIO_FILEINPUT, args[2]);
        set(SCENARIO_HIDECONTROLS, args[3]);
        set(SCENARIO_LOCK, "true");
    }

    public void set(JFootPropertyType propertyType, String arg) {
        if (arg != null)
            propertyType.set(properties, arg);
    }

    public String get(JFootPropertyType propertyType) {
        return propertyType.get(properties);
    }

    public Properties getProperties() {
        return properties;
    }

    public void load(InputStream inputStream) {
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new JFootError(e);
        }
    }
}
