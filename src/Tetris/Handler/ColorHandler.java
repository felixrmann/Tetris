package Tetris.Handler;

import java.awt.*;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-August-03
 */

public class ColorHandler {
    public static Color getColor(String field){
        switch (field){
            case " ":
                //return Color.GRAY;
                return new Color(0,0,0);
            case "hb":
                return new Color(0,255,255);
            case "db":
                return new Color(0,0,255);
            case "o":
                return new Color(255,128,0);
            case "y":
                return new Color(255,255,0);
            case "g":
                return new Color(0,255,0);
            case "v":
                return new Color(102,0,102);
            case "r":
                return new Color(255,0,0);
            default: 
                return null;
        }
    }
}
