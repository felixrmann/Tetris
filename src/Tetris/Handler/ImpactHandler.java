package Tetris.Handler;

import Tetris.Model.Map.GameMap;
import Tetris.Model.Shapes.Shape;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-August-15
 */

public class ImpactHandler {
    private GameMap gameMap;

    public ImpactHandler(GameMap gameMap){
        this.gameMap = gameMap;
    }

    public boolean clearUnderBlock(Shape shape){
        boolean temp = false;
        int[][] info = shape.getPrintShape(shape.getRotation());
        for (int i = 0; i < 4; i++) {
            if (!(gameMap.getSetMap()[(shape.getyPos() + info[0][i]) + 1][shape.getxPos() + info[1][i]].equals(" "))){
                temp = true;
            }
        }
        return temp;
    }
}
