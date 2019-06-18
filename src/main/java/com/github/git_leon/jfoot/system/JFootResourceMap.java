package com.github.git_leon.jfoot.system;

import com.github.git_leon.StringAssembler;

import java.util.TreeMap;

public class  JFootResourceMap<KeyType, ValueType> extends TreeMap<KeyType, ValueType> {
    @Override
    public String toString() {
        StringAssembler sa = new StringAssembler("\n");
        entrySet().forEach(row -> sa.append(row.toString()));
        return sa.toString();
    }
}
