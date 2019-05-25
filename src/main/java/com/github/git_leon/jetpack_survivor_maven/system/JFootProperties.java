package com.github.git_leon.jetpack_survivor_maven.system;

import com.github.git_leon.Introspection;
import com.github.git_leon.jetpack_survivor_maven.utils.exceptions.JFootError;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class JFootProperties {
    private Properties properties;
    public final JFProperty PROJECT_NAME = new JFProperty(JFootPropertyType.PROJECT_NAME);
    public final JFProperty MAIN_CLASS = new JFProperty(JFootPropertyType.MAIN_CLASS);
    public final JFProperty SCENARIO_FILEINPUT = new JFProperty(JFootPropertyType.SCENARIO_FILEINPUT);
    public final JFProperty SCENARIO_HIDECONTROLS = new JFProperty(JFootPropertyType.SCENARIO_HIDECONTROLS);
    public final JFProperty SCENARIO_LOCK = new JFProperty(JFootPropertyType.SCENARIO_LOCK);


    public JFootProperties(InputStream is) {
        this.properties = new Properties();
        load(is);
        PROJECT_NAME.set(properties);
        MAIN_CLASS.set(properties);
        SCENARIO_FILEINPUT.set(properties);
        SCENARIO_HIDECONTROLS.set(properties);
        SCENARIO_LOCK.set(properties);
    }

    public Properties getProperties() {
        return properties;
    }

    public void load(InputStream is) {
        try {
            properties.load(Optional.of(is).get());
        } catch (IOException e) {
            throw new JFootError(e);
        } catch(NullPointerException e) {

        }
    }


    public JFProperty valueOf(String s) {
        JFootPropertyType valueTypeToSeek = JFootPropertyType.valueOf(s);
        for(JFProperty property : values()) {
            if(property.getPropertyType().equals(valueTypeToSeek)) {
                return property;
            }
        }
        String errorMessage = "Unable to find property with value [ %s ].";
        throw new JFootError(new NullPointerException(), String.format(errorMessage, s));
    }

    public List<JFProperty> values() {
        return Introspection.getFieldValues(this, JFProperty.class);
    }

}
