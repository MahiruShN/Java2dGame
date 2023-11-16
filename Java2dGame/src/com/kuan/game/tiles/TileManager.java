package com.kuan.game.tiles;
import com.kuan.game.graphics.Sprite;
import com.kuan.game.util.Vector2f;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;


import javax.print.Doc;

import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class TileManager {

    public static ArrayList<TileMap> tm;
    public TileManager () {
        tm = new ArrayList<TileMap>();
    }

    public TileManager(String path) {
        tm = new ArrayList<TileMap>();
        addTileMap(path, 64, 64);
    }

    private void addTileMap(String path, int blockWidth, int blockHeight) {
        String imagePath;
        String imagePathTSX;
        int width = 0;
        int height = 0;
        int tileWidth;
        int tileHeight;
        int tileCount;
        int tileColumns;
        int layers = 0;
        Sprite sprite;
        String[] data = new String[10];
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder= builderFactory.newDocumentBuilder();
            Document doc = builder.parse(new File(getClass().getClassLoader().getResource(path).toURI()));

            doc.getDocumentElement().normalize();
            NodeList list = doc.getElementsByTagName("tileset");
            Node node = list.item(0);
            Element eElement = (Element) node;

            imagePath = eElement.getAttribute("name");
//            imagePathTSX = eElement.getAttribute("source");
//            imagePath = imagePathTSX.substring(0, imagePathTSX.length() - 4);

            list = doc.getElementsByTagName("map");
            node = list.item(0);
            eElement = (Element) node;

            tileWidth = Integer.parseInt(eElement.getAttribute("tilewidth"));
            tileHeight = Integer.parseInt(eElement.getAttribute("tileheight"));

//            tileWidth = Integer.parseInt(eElement.getAttribute("tilewidth"));
//            tileHeight = Integer.parseInt(eElement.getAttribute("tileheight"));

            sprite = new Sprite("tile/" + imagePath + ".png", tileWidth, tileHeight);

            tileCount = Integer.parseInt(eElement.getAttribute("tilecount"));
            tileColumns = Integer.parseInt(eElement.getAttribute("columns"));
//            tileColumns = sprite.getSpriteSheetWidth() / tileWidth;
//            tileCount = tileColumns * (sprite.getSpriteSheetHeight() / tileHeight);




            list = doc.getElementsByTagName("layer");
            layers = list.getLength();

            for (int i=0; i < layers; i++) {
                node = list.item(i);
                eElement = (Element) node;
                if (i <= 0) {
                    width = Integer.parseInt(eElement.getAttribute("width"));
                    height = Integer.parseInt(eElement.getAttribute("height"));

                }

                data[i] = eElement.getElementsByTagName("data").item(0).getTextContent();
                System.out.println("-----------------\n" + data[i]);
            }
        } catch (Exception e) {
            System.out.println("ERROR: cant read tilemap(tile manager)");
        }
    }

    public void render(Graphics2D g) {

    }

    //TODO fix tile map using 1.0.1 tile editor

}
