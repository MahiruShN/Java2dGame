package com.kuan.game.states;

import com.kuan.game.util.KeyHandler;
import com.kuan.game.util.MouseHandler;

import java.awt.*;

public class PlayState extends GameState {
    public PlayState(GameStateManager gsm) {
        super(gsm);
    }

    public void update(){}

    public void input(MouseHandler mouse, KeyHandler key) {
        if(key.up.down) {
            System.out.println("W ");
        }
    }

    public void render(Graphics2D g) {
        g.setColor(Color.red);
        g.fillRect(100,100,64,64);
    }

}
