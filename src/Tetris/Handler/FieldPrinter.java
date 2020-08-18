package Tetris.Handler;

import Tetris.Model.Map.GameMap;

import javax.swing.*;
import java.awt.*;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-August-03
 */

public class FieldPrinter extends JPanel{
    private GameMap map;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 800;
    private static final int SIZE = 40;

    public FieldPrinter(GameMap map){
        this.map = map;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int y = 0; y < HEIGHT; y += SIZE) {
            for (int x = 0; x < WIDTH; x += SIZE) {
                g.setColor(ColorHandler.getColor(map.getTempMap()[y / SIZE][x / SIZE]));
                g.fillRect(x,y,SIZE,SIZE);
            }
        }
    }
}
