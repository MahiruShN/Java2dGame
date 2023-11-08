package com.kuan.game.states;

import com.kuan.game.util.KeyHandler;
import com.kuan.game.util.MouseHandler;

import java.awt.*;

public abstract class GameState {
    private GameStateManager gsm;
    public GameState (GameStateManager gsm) {
        this.gsm = gsm;
    }
    public abstract void update();
    public abstract void render(Graphics2D g);
    public abstract void input(MouseHandler mouse, KeyHandler key);
}
