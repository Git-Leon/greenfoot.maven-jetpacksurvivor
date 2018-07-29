package com.github.git_leon.jetpack_survivor_maven.resources;

import com.github.git_leon.jetpack_survivor_maven.utils.JfootSound;
import com.github.git_leon.jetpack_survivor_maven.utils.exceptions.JFootError;
import greenfoot.GreenfootImage;
import greenfoot.GreenfootSound;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public enum ResourceDirectory {
    IMAGES("images/"),
    SOUNDS("sounds/");

    private final File directory;
    private Map<String, GreenfootSound> soundMap = new HashMap<>();
    private Map<String, GreenfootImage> imageMap = new HashMap<>();
    private Map<String, MediaPlayer> mediaPlayerMap = new HashMap<>();

    ResourceDirectory(String directoryPath) {
        String resourceDirectory = System.getProperty("user.dir") + "/src/main/resources/";
        this.directory = new File(resourceDirectory + directoryPath);
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not a directory.");
        }
    }

    public File getFile(String imageName) {
        File file = new File(toString() + imageName);
        if (!file.exists()) {
            String errorMessage = "Failed to find file with name [ %s ]";
            Throwable cause = new FileNotFoundException();
            throw new JFootError(cause, String.format(errorMessage, file.getAbsolutePath()));
        }
        return file;
    }

    public Clip getClip(String fileName) {
        Clip clip;
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(getFile(fileName)));
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new JFootError(e);
        }
        return clip;
    }

    @Deprecated
    public MediaPlayer getMediPlayer(String fileName) {
        File mediaFile = getFile(fileName);

        if (!mediaPlayerMap.containsKey(fileName)) {
            File file = new File(toString() + fileName);
            URI uri = file.toURI();
            Media media = new Media(uri.toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayerMap.put(fileName, mediaPlayer);
        }
        return mediaPlayerMap.get(fileName);
    }

    public GreenfootImage getImage(String imageName) {
        imageName = getFile(imageName).toString();

        if (imageMap.containsKey(imageName)) {
            return imageMap.get(imageName);
        }
        return new GreenfootImage(toString() + imageName);
    }

    public GreenfootSound getSound(String soundName) {
        soundName = getFile(soundName).toString();

        if (soundMap.containsKey(soundName)) {
            return soundMap.get(soundName);
        }
        return new JfootSound(toString() + soundName);
    }

    public File getDirectory() {
        return directory;
    }

    @Override
    public String toString() {
        System.out.println(directory);
        return directory.getAbsolutePath() + "/";
    }
}
