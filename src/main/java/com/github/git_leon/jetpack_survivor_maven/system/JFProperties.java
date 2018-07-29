package com.github.git_leon.jetpack_survivor_maven.system;

import com.github.git_leon.Introspection;
import com.github.git_leon.collectionutils.maps.InvertableMap;
import com.github.git_leon.jetpack_survivor_maven.utils.exceptions.JFootError;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class JFProperties {
    public final JFProperty PROJECT_NAME = new JFProperty("project.name");
    public final JFProperty MAIN_CLASS = new JFProperty("main.class");
    public final JFProperty SCENARIO_FILEINPUT= new JFProperty("scenario.fileInput");
    public final JFProperty SCENARIO_HIDECONTROLS = new JFProperty("scenario.hideControls");
    public final JFProperty SCENARIO_LOCK = new JFProperty("scenario.lock");

    public JFProperties(String... args) {
        args = args != null ? Arrays.copyOf(args, 5) : new String[5];
        PROJECT_NAME.set(args[0]);
        MAIN_CLASS.set(args[1]);
        SCENARIO_FILEINPUT.set(args[2]);
        SCENARIO_HIDECONTROLS.set(args[3]);
        SCENARIO_LOCK.set("true");
    }

    public Properties getProperties() {
        Properties properties = new Properties();
        List<JFProperty> propertyList = Introspection.getFieldValues(this, JFProperty.class);
        propertyList.forEach(jfProperty -> properties.putAll(jfProperty.getProperty()));
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
