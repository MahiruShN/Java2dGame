package com.kuan.game.graphics;

import java.awt.image.BufferedImage;

public class Animation {
    private BufferedImage[] frames;
    private int currentFrame;
    private int numFrames;
    private int count;
    private int delay;
    private int timePlayed;

    public Animation (BufferedImage[] frames) {
        timePlayed = 0;
        setFrames(frames);

    }

    public void setFrames(BufferedImage[] frames) {
        this.frames = frames;
        currentFrame = 0;
        count = 0;
        timePlayed = 0;
        delay = 2;
        numFrames =frames.length;

    }

    public void setDelay(int i) {
        delay = i;

    }

    public void setFrame(int i) {
        currentFrame = i;
    }

    public void setNumFrames (int i ) {
        numFrames = i;

    }

    public void update() {
        if(delay ==-1) {
            return;
        }

        count++;

        if (count == delay) {
            currentFrame++;
            count = 0;
        }
        if (currentFrame == numFrames) {
            currentFrame = 0;
            timePlayed++;
        }
    }

    public int getDelay() {return delay;}
    public int getFrame() {return currentFrame;}
    public int getCount() {return count;}
    public BufferedImage getImage() {
        return frames[currentFrame];
    }

    public boolean hasPlayedOnce() {
        return timePlayed > 0;

    }
    public boolean hasPlayed( int i) {
        return timePlayed==i;

    }

     

}