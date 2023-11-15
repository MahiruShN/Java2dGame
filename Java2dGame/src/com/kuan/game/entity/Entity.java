package com.kuan.game.entity;

import com.kuan.game.graphics.Animation;
import com.kuan.game.util.AABB;
import com.kuan.game.util.KeyHandler;
import com.kuan.game.util.MouseHandler;
import com.kuan.game.util.Vector2f;
import com.kuan.game.graphics.Sprite;

import java.awt.*;
import java.awt.image.BufferedImage;


public abstract class Entity {
    private final int UP = 0;
    private final int DOWN = 1;
    private final int RIGHT = 2;
    private final int LEFT = 3;
    protected int currentAnimation;

    protected Animation ani;
    protected Sprite sprite;
    protected Vector2f pos;
    protected int size;
    protected boolean up;
    protected boolean down;
    protected boolean right;
    protected boolean left;
    protected boolean attack;
    protected int attackSpeed;
    protected int attackDuration;
    protected float dx;
    protected float dy;
    protected float maxSpeed;
    protected float acc;
    protected float deacc;

    protected AABB hitBounds;
    protected AABB bounds;






    public Entity (Sprite sprite, Vector2f orgin, int size) {
        this.sprite = sprite;
        pos = orgin;
        this.size = size;
        bounds = new AABB(orgin, size, size);
        hitBounds = new AABB(new Vector2f(orgin.x + (size / 2), orgin.y), size, size);
        ani = new Animation();
        setAnimation(RIGHT,sprite.getSpriteArray(RIGHT),10);
    }

    public int getSize() {return size;}

    public void setAnimation(int i, BufferedImage[] frames, int delay) {
        currentAnimation = i;
        ani.setFrames(frames);
        ani.setDelay(delay);
    }

    public void animate() {
        if (up) {
            if(currentAnimation != UP || ani.getDelay() ==-1) {
                setAnimation(UP, sprite.getSpriteArray(UP),5);
            }
        }
        else if(down) {
            if (currentAnimation != DOWN || ani.getDelay() == -1) {
                setAnimation (DOWN, sprite.getSpriteArray (DOWN),  5);
            }
        }
        else if(left) {
            if(currentAnimation != LEFT || ani.getDelay() == -1) {
                setAnimation (LEFT, sprite.getSpriteArray (LEFT),  5);
            }
        }
        else if(right) {
            if (currentAnimation != RIGHT || ani.getDelay() == -1) {
                setAnimation (RIGHT, sprite.getSpriteArray (RIGHT),  5);
            }
        } else {
            setAnimation (currentAnimation, sprite.getSpriteArray (currentAnimation),-1) ;
        }
    }

    public void update() {
        animate();
        setHitBoxDirection();
        ani.update();
    }

    public abstract  void render(Graphics2D g);
    public void input(KeyHandler key, MouseHandler mouse) {}

}