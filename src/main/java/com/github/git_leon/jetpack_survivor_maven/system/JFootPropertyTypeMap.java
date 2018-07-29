package com.github.git_leon.jetpack_survivor_maven.system;

import com.github.git_leon.collectionutils.maps.InvertableMap;

import java.util.Map;

public enum JFootPropertyTypeMap {
    INSTANCE;

    private final Map<String, JFootPropertyType> propertyMap = new InvertableMap<>();

    JFootPropertyTypeMap() {
        for (JFootPropertyType propertyType : JFootPropertyType.values()) {
            propertyMap.put(propertyType.toString(), propertyType);
        }
    }

    public JFootPropertyType get(String propertyValue) {
        return propertyMap.get(propertyValue);
    }
}
