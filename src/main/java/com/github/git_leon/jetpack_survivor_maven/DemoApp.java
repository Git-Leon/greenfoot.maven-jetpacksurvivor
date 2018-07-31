package com.github.git_leon.jetpack_survivor_maven;

import com.github.git_leon.jetpack_survivor_maven.system.application.JFootApplication;

import java.io.IOException;

/**
 * @author Lukas Fülling (lukas@k40s.net)
 */
public class DemoApp   {
    public static void main(String[] args) {
        try {
            new JFootApplication(args).run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
