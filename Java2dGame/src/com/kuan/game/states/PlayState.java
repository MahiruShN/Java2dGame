package com.kuan.game.states;

import com.kuan.game.GamePanel;
import com.kuan.game.entity.Player;
import com.kuan.game.graphics.Sprite;
import com.kuan.game.graphics.Font;

import com.kuan.game.tiles.TileManager;
import com.kuan.game.util.KeyHandler;
import com.kuan.game.util.MouseHandler;
import com.kuan.game.util.Vector2f;

import java.awt.*;

public class PlayState extends GameState {

    private Font font;
    private Player player;
    private TileManager tm;

    public static Vector2f map;
    public PlayState(GameStateManager gsm) {
        super(gsm);
        map = new Vector2f();
        Vector2f.setWorldVar(map.x, map.y);
        tm = new TileManager("tile/tilemap2.xml");
        font = new Font("font/font.png",10,10);
        player = new Player(new Sprite("entity/linkformatted.png"), new Vector2f(0 +(GamePanel.width /2) - 32 ,0 + (GamePanel.height/2) - 32 ),64);
    }

    public void update(){
        Vector2f.setWorldVar(map.x, map.y);
        player.update();
    }

    public void input(MouseHandler mouse, KeyHandler key) {
        player.input(mouse, key);
    }

    private String teststr = "public static void main(String[] args";

    public void render(Graphics2D g) {
        tm.render(g);
        Sprite.drawArray(g,font, GamePanel.oldFrameCount + " FPS", new Vector2f(GamePanel.width - 192,32 ),32,32,26,0);
        Sprite.drawArray(g,font, teststr, new Vector2f(0,64 ),32,32,26,0);
        player.render(g);
    }

}
