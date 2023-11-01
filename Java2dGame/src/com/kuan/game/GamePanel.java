package com.kuan.game;
import org.ietf.jgss.GSSManager;

import  javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable{

    public static int width;
    public static int height;
    private  Thread thread;
    private BufferedImage img;
    private Graphics2D g;
    private  boolean running= false;
    public GamePanel (int width, int height) {
        this.height = height;
        this.width = width;

        setPreferredSize(new Dimension(width,height));
        setFocusable(true);
        requestFocus();
    }

    public void addNotify() {
        super.addNotify();

        if (thread ==null) {
            thread = new Thread(this,"GameThread");
            thread.start();
        }
    }
    public void init() {
        running = true;

        img = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        g = (Graphics2D) img.getGraphics();
    }
    public void run() {
        init();
        final double GAME_HERTZ = 60.0;
        final double TBU = 1000000000 / GAME_HERTZ;
        final int MUBR = 5;
        double lastUpdateTime = System.nanoTime();
        double lastRenderTime;
        final double TARGET_FPS = 60.0;
        final  double TTBR = 1000000000 / TARGET_FPS ;
        while (running) {
            update();
            render();
            draw();
        }
    }

    private int x =0;
    public void update() {
        x++;
    }
    public  void render() {
        g.setColor( new Color(66, 131, 168));
        g.fillRect(0,0,width,height);
    }
    public void draw() {
        Graphics g2 = (Graphics) this.getGraphics();
        g2.drawImage( img,0,0, width, height,null);
        g2.dispose();
    }
}
