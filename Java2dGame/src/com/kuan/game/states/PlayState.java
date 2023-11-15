package com.kuan.game.states;

import com.kuan.game.entity.Player;
import com.kuan.game.graphics.Sprite;
import com.kuan.game.graphics.Font;

import com.kuan.game.util.KeyHandler;
import com.kuan.game.util.MouseHandler;
import com.kuan.game.util.Vector2f;

import java.awt.*;

public class PlayState extends GameState {

    private Font font;
    private Player player;
    public PlayState(GameStateManager gsm) {
        super(gsm);
        font = new Font("font/ZeldaFont.png",16,16);
        player = new Player(new Sprite("entity/linkformatted.png"), new Vector2f(500,500),128);
    }

    public void update(){
        player.update();
    }

    public void input(MouseHandler mouse, KeyHandler key) {
        player.input(mouse, key);
    }

    public void render(Graphics2D g) {
        Sprite.drawArray(g,font,"a xin chao", new Vector2f(300,100),32,32,16,0);
        player.render(g);
    }

}
