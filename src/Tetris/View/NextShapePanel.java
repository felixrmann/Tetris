package Tetris.View;

import Tetris.Handler.GameHandler;
import Tetris.Model.Shapes.Shape;

import javax.swing.*;
import java.awt.*;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-September-01
 */

public class NextShapePanel extends JPanel {
    private GameHandler gameHandler;
    private String[][] nextShapePrint = new String[][]{
            {" "," "," "," "},
            {" "," "," "," "},
            {" "," "," "," "},
            {" "," "," "," "}
    };


    public NextShapePanel(GameHandler gameHandler){
        this.gameHandler = gameHandler;

        setLayout(new GridLayout(1,3));
        //TODO next Shape
        setPreferredSize(new Dimension(200,800));
        setBackground(Color.BLACK);
    }

    public void setNestShape(){
        Shape printShape = gameHandler.getShapeOutHandler().getShape(gameHandler.getCurrentShape().getShapeColor());
        printShape.setRotation(gameHandler.getCurrentShape().getRotation());
        printShape.getPrintShape(gameHandler.getCurrentShape().getRotation());


    }
}
