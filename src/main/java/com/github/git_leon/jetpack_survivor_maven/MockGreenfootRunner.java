package com.github.git_leon.jetpack_survivor_maven;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import bluej.Config;
import greenfoot.Greenfoot;
import greenfoot.export.GreenfootScenarioViewer;
import greenfoot.util.StandalonePropStringManager;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Arrays;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MockGreenfootRunner {
    public static String scenarioName;
    public static String[] args;

    public MockGreenfootRunner() {
    }

    public static void main(String[] args) {
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        if (args.length != 3 && args.length != 0) {
            System.err.println("Wrong number of arguments");
        }

        args = args;
        initProperties();
        System.setProperty("com.apple.mrj.application.apple.menu.about.name", scenarioName);
        final GreenfootScenarioViewer[] gsv = new GreenfootScenarioViewer[1];
        final JFrame[] frame = new JFrame[1];

        try {
            EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    frame[0] = new JFrame(greenfoot.export.GreenfootScenarioMain.scenarioName);
                    gsv[0] = new GreenfootScenarioViewer(frame[0]);
                    frame[0].setDefaultCloseOperation(3);
                    frame[0].setResizable(false);
                    URL resource = this.getClass().getClassLoader().getResource("greenfoot.png");
                    ImageIcon icon = new ImageIcon(resource);
                    frame[0].setIconImage(icon.getImage());
                }
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
            var4.printStackTrace();
        }
    }

    public static void initProperties() {
        if (scenarioName == null) {
            Properties p = new Properties();

            try {
                ClassLoader loader = greenfoot.export.GreenfootScenarioMain.class.getClassLoader();
                InputStream is = loader.getResourceAsStream("standalone.properties");
                if (is == null && (args.length == 3 || args.length == 4)) {
                    p.put("project.name", args[0]);
                    p.put("main.class", args[1]);
                    p.put("scenario.lock", "true");
                    File f = new File(args[2]);
                    if (f.canRead()) {
                        is = new FileInputStream(f);
                    }

                    if (args.length == 4) {
                        p.put("scenario.hideControls", args[3]);
                    } else {
                        p.put("scenario.hideControls", false);
                    }
                }

                if (is != null) {
                    p.load((InputStream)is);
                }

                scenarioName = p.getProperty("project.name");
                Config.initializeStandalone(new StandalonePropStringManager(p));
                if (is != null) {
                    ((InputStream)is).close();
                }
            } catch (FileNotFoundException var4) {
                var4.printStackTrace();
            } catch (IOException var5) {
                var5.printStackTrace();
            }

        }
    }
}

