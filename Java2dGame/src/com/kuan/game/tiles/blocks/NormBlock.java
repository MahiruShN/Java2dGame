package com.kuan.game.tiles.blocks;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import com.kuan.game.util.AABB;
import com.kuan.game.util.Vector2f;

public class NormBlock extends Block {
    public NormBlock(BufferedImage img, Vector2f pos, int w, int h) {
        super(img, pos, w, h);
    }

    public boolean update(AABB p) {
        return false;
    }

    public void render(Graphics2D g) {
        super.render(g);
    }

}
