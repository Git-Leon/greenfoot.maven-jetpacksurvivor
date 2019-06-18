package com.github.git_leon.jfoot.system.view;

import javax.swing.*;
import java.net.URL;

public class JFootFrameBuilder {

    private final JFrame jFrame;
    private int defaultCloseOperation;
    private boolean resizable;
    private ImageIcon imageIcon;

    public JFootFrameBuilder(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    public JFootFrameBuilder setDefaultCloseOperation(int i) {
        this.defaultCloseOperation = i;
        return this;
    }

    public JFootFrameBuilder setResizable(boolean b) {
        this.resizable = b;
        return this;
    }

    public JFootFrameBuilder setIconImage(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
        return this;
    }
    public JFootFrameBuilder setIconImage(String fileName) {
        return setIconImage(new ImageIcon(getClass().getClassLoader().getResource(fileName)));
    }



    public JFootFrame build() {
        jFrame.setDefaultCloseOperation(3);
        jFrame.setResizable(false);
        URL resource = this.getClass().getClassLoader().getResource("greenfoot.png");
        ImageIcon icon = new ImageIcon(resource);
        jFrame.setIconImage(icon.getImage());
        return new JFootFrame(jFrame);
    }
}
