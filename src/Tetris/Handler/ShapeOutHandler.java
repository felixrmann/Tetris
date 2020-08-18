package Tetris.Handler;

import Tetris.Model.Shapes.*;

import java.util.Collections;
import java.util.Vector;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-August-10
 */

public class ShapeOutHandler {
    Vector<Shape> shapeRotation, shapeOut;

    public ShapeOutHandler(){
        shapeRotation = new Vector<>();
        shapeOut = new Vector<>();

        fillVector();
    }

    public Shape getRandomShape(){
        if (shapeOut.size() == 0){
            refillOut();
        }
        Shape temp = shapeOut.get((int)(Math.random() * shapeOut.size()));
        shapeOut.remove(temp);
        return temp;
    }

    public Shape getShape(String color){
        switch (color){
            case "hb":
                return new I_Shape();
            case "db":
                return new J_Shape();
            case "o":
                return new L_Shape();
            case "g":
                return new S_Shape();
            case "v":
                return new T_Shape();
            case "r":
                return new Z_Shape();
            case "y":
                return new O_Shape();
            default:
                return null;
        }
    }

    private void fillVector(){
        for (int i = 0; i < 3; i++) {
            shapeRotation.add(new I_Shape());
            shapeRotation.add(new J_Shape());
            shapeRotation.add(new L_Shape());
            shapeRotation.add(new O_Shape());
            shapeRotation.add(new S_Shape());
            shapeRotation.add(new T_Shape());
            shapeRotation.add(new Z_Shape());
        }

        Collections.shuffle(shapeRotation);
    }

    private void refillOut(){
        shapeOut = (Vector<Shape>)shapeRotation.clone();
    }
}
