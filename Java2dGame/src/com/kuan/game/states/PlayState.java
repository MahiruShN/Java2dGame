package com.kuan.game.states;

import com.kuan.game.graphics.Sprite;
import com.kuan.game.graphics.Font;

import com.kuan.game.util.KeyHandler;
import com.kuan.game.util.MouseHandler;
import com.kuan.game.util.Vector2f;

import java.awt.*;

public class PlayState extends GameState {

    private Font font;
    public PlayState(GameStateManager gsm) {
        super(gsm);
        font = new Font("font/ZeldaFont.png",16,16);
    }

    public void update(){}

    public void input(MouseHandler mouse, KeyHandler key) {

    }

    public void render(Graphics2D g) {
        Sprite.drawArray(g,font,"a xin chao", new Vector2f(100,100),32,32,16,0);
    }

}
