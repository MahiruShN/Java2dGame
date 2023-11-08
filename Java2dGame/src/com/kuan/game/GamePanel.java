package com.kuan.game;
import com.kuan.game.states.GameStateManager;
import com.kuan.game.util.KeyHandler;
import com.kuan.game.util.MouseHandler;
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
    private MouseHandler mouse;
    private KeyHandler key;
    private GameStateManager gsm;
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

        mouse = new MouseHandler();
        key = new KeyHandler(this); //vid 4
        gsm = new GameStateManager();
    }
    public void run() {
        init();
        final double GAME_HERTZ = 60.0;
        final double TBU = 1000000000 / GAME_HERTZ; //time be4 update
        final int MUBR = 5; //most update before render
        double lastUpdateTime = System.nanoTime();
        double lastRenderTime;
        final double TARGET_FPS = 60.0;
        final  double TTBR = 1000000000 / TARGET_FPS ; //total time be4 update
        int frameCount = 0;
        int lastSecondTime = (int) (lastUpdateTime/1000000000);
        int oldFrameCount = 0;
        while (running) {

            double now = System.nanoTime();
            int upDateCount = 0;
            while (((now - lastUpdateTime) > TBU) && (upDateCount < MUBR))  {
                update();
                input(mouse, key);
                lastUpdateTime += TBU;
                upDateCount++;

            }

            if(now - lastUpdateTime > TBU) {
                lastUpdateTime = now - TBU;
            }

            input(mouse,key);

            render();
            draw();
            lastRenderTime = now;
            frameCount++;

            int thisSecond = (int) (lastUpdateTime / 1000000000);
            if(thisSecond > lastSecondTime) {
                if(frameCount != oldFrameCount) {
                    System.out.println(thisSecond + "    " + frameCount);
                    oldFrameCount = frameCount;
                }
                frameCount = 0;
                lastSecondTime = thisSecond;
            }

            while(now - lastRenderTime < TTBR && now - lastUpdateTime < TBU) {
                Thread.yield();

                try{
                    Thread.sleep(1);
                } catch (Exception e) {
                    System.out.println("Error: yieldinf thread");
                }
                now = System.nanoTime();
            }
        }
    }

    private int x =0;
    public void update() {
        gsm.update();
    }

    public void input (MouseHandler mouse, KeyHandler key) {
        gsm.input(mouse,key);
    }
    public  void render() {
        g.setColor( new Color(66, 131, 168));
        g.fillRect(0,0,width,height);
        gsm.render(g);
    }
    public void draw() {
        Graphics g2 = (Graphics) this.getGraphics();
        g2.drawImage( img,0,0, width, height,null);
        g2.dispose();
    }
}
