package com.github.git_leon.jetpack_survivor_maven.system;

import bluej.Config;
import com.github.git_leon.jetpack_survivor_maven.system.view.JFootFrame;
import com.github.git_leon.jetpack_survivor_maven.system.view.JFootFrameBuilder;
import com.github.git_leon.jetpack_survivor_maven.utils.exceptions.JFootError;
import greenfoot.Greenfoot;
import greenfoot.export.GreenfootScenarioMain;
import greenfoot.export.GreenfootScenarioViewer;
import greenfoot.util.StandalonePropStringManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

public class JFootApplication {
    private final JFootProperties properties;

    public JFootApplication(String[] args) throws IOException {
        ClassLoader loader = GreenfootScenarioMain.class.getClassLoader();
        InputStream is = loader.getResourceAsStream("standalone.properties");
        this.properties = new JFootProperties(is);
        properties.load(is);
        Config.initializeStandalone(new StandalonePropStringManager(properties.getProperties()));
        is.close();
    }

    public void run() {
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("com.apple.mrj.application.apple.menu.about.name", properties.PROJECT_NAME.get());

        final GreenfootScenarioViewer[] gsv = new GreenfootScenarioViewer[1];
        final JFrame[] frame = new JFrame[1];
        try {
            EventQueue.invokeAndWait(() -> {
                URL resource = this.getClass().getClassLoader().getResource("greenfoot.png");
                ImageIcon icon = new ImageIcon(resource);
                frame[0] = new JFrame(GreenfootScenarioMain.scenarioName);
                gsv[0] = new GreenfootScenarioViewer(frame[0]);
                frame[0].setDefaultCloseOperation(3);
                frame[0].setResizable(false);
                frame[0].setIconImage(icon.getImage());
            });
            gsv[0].init();
            EventQueue.invokeAndWait(() -> {
                frame[0].pack();
                frame[0].setVisible(true);
                if (Config.getPropBoolean("scenario.hideControls", false)) {
                    Greenfoot.start();
                }
            });
        } catch (InvocationTargetException | InterruptedException var4) {
            throw new JFootError(var4);
        }

    }

    public static void main(String[] args) {
        try {
            new JFootApplication(args).run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
